package me.neo.refinedradiation.block.test;

import me.neo.refinedradiation.block.WrappedHandler;
import me.neo.refinedradiation.init.Packets;
import me.neo.refinedradiation.init.TileEntityInit;
import me.neo.refinedradiation.networking.packet.EnergySyncS2C;
import me.neo.refinedradiation.util.CustomEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Optional;

public class TestTile extends BlockEntity implements MenuProvider {
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;
    private int energyUsage = 32;

    public int maxEnergyStored = 8000;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();

    public TestTile(BlockPos pos, BlockState state) {
        super(TileEntityInit.TEST.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> TestTile.this.progress;
                    case 1 -> TestTile.this.maxProgress;
                    case 2 -> TestTile.this.getEnergyStorage().getEnergyStored();
                    case 3 -> TestTile.this.maxEnergyStored;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> TestTile.this.progress = pValue;
                    case 1 -> TestTile.this.maxProgress = pValue;
                    case 2 -> TestTile.this.energyStorage.setEnergy(pValue);
                    case 3 -> TestTile.this.maxEnergyStored = pValue;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        };
    }

    private final ItemStackHandler itemHandler = new ItemStackHandler(15) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> true;
                case 1 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private final CustomEnergyStorage energyStorage = new CustomEnergyStorage(maxEnergyStored, 1024) {
        @Override
        public void onEnergyChanged() {
            setChanged();
            Packets.sendToClients(new EnergySyncS2C(this.energy, getBlockPos()));
        }
    };
    public IEnergyStorage getEnergyStorage() {
        return energyStorage;
    }
    public void setEnergyLevel(int energy) {
        this.energyStorage.setEnergy(energy);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyEnergyHandler = LazyOptional.of(() -> energyStorage);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyEnergyHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("test.inv", itemHandler.serializeNBT());
        nbt.putInt("test.progress", this.progress);
        nbt.putInt("test.energy", energyStorage.getEnergyStored());
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("test.inv"));
        progress = nbt.getInt("test.progress");
        energyStorage.setEnergy(nbt.getInt("test.energy"));
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("testtile");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        Packets.sendToClients(new EnergySyncS2C(this.energyStorage.getEnergyStored(), worldPosition));
        return new TestMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        if (cap == ForgeCapabilities.ENERGY) {
            return lazyEnergyHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++)
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, TestTile tile) {
        if (level.isClientSide()) return;
        if (!hasRecipe(tile)) {
            tile.progress = 0;
        }
        if (hasRecipe(tile) && hasEnergy(tile)) {
            if (tile.progress >= tile.maxProgress) {
                craftItem(tile);
                tile.progress = 0;
            } else {
                state = state.setValue(TestBlock.WORKING, true);
                tile.progress++;
                tile.energyStorage.extractEnergy(tile.energyUsage, false);
            }
        } else {
            state = state.setValue(TestBlock.WORKING, false);
        }
        level.setBlock(pos, state, 3);
        setChanged(level, pos, state);
    }

    private static void craftItem(TestTile tile) {
        ItemStackHandler itemHandler = tile.itemHandler;
        SimpleContainer container = new SimpleContainer(15);
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            container.setItem(i, itemHandler.getStackInSlot(i));
        }
        Optional<TestRecipe> recipe = tile.level.getRecipeManager().getRecipeFor(TestRecipe.Type.INSTANCE, container, tile.level);

        if (itemHandler.getStackInSlot(1).getCount() + recipe.get().getOutputAmount() < itemHandler.getStackInSlot(1).getMaxStackSize()) {
            itemHandler.extractItem(0, recipe.get().getIngredientAmount(0), false);
            itemHandler.setStackInSlot(1, new ItemStack(recipe.get().getResultItem().getItem(), itemHandler.getStackInSlot(1).getCount() + recipe.get().getOutputAmount()));
        }
    }

    private static boolean hasRecipe(TestTile tile) {
        Level level = tile.level;
        SimpleContainer inventory = new SimpleContainer(tile.itemHandler.getSlots());
        for (int i = 0; i < tile.itemHandler.getSlots(); i++)
            inventory.setItem(i, tile.itemHandler.getStackInSlot(i));

        Optional<TestRecipe> recipe = level.getRecipeManager().getRecipeFor(TestRecipe.Type.INSTANCE, inventory, level);
        boolean hasRecipe = recipe.isPresent() && hasEnoughIngredients(recipe.get(), inventory, level)
                && canOutput(inventory, recipe.get().getResultItem(), 1) && canOutputAmount(inventory, 1);

        if (hasRecipe) {
            tile.maxProgress = recipe.get().getProcessingTime();
            tile.energyUsage = recipe.get().getPowerUsageTick();
        }
        return hasRecipe;
    }

    private static boolean hasEnergy(TestTile tile) {
        return tile.energyStorage.getEnergyStored() > 0;
    }
    private static <T extends Recipe<SimpleContainer>> boolean hasEnoughIngredients(T recipe, SimpleContainer inventory, Level level) {
        return recipe.matches(inventory, level);
    }
    private static boolean canOutput(SimpleContainer inventory, ItemStack stack, int outputSlotIndex) {
        return inventory.getItem(outputSlotIndex).getItem() == stack.getItem() || inventory.getItem(outputSlotIndex).isEmpty();
    }
    private static boolean canOutputAmount(SimpleContainer inventory, int outputSlotIndex) {
        return inventory.getItem(outputSlotIndex).getMaxStackSize() > inventory.getItem(outputSlotIndex).getCount();
    }
}