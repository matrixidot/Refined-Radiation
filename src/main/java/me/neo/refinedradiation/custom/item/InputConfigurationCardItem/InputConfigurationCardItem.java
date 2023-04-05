package me.neo.refinedradiation.custom.item.InputConfigurationCardItem;

import me.neo.refinedradiation.RefinedRadiation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.List;

public class InputConfigurationCardItem extends Item {
    public InputConfigurationCardItem(Properties pProperties) {
        super(pProperties);
    }
    public static boolean getData(ItemStack stack, String color) {
        if(stack.hasTag()) {
            return stack.getTagElement("data").getByte(color) != 0;
        } else return false;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

        if (!pStack.hasTag()) {
            pStack.addTagElement("data", new CompoundTag());

            pStack.getTagElement("data").putByte("lightblue", (byte) 0);
            pStack.getTagElement("data").putByte("cyan", (byte) 0);
            pStack.getTagElement("data").putByte("blue", (byte) 0);
            pStack.getTagElement("data").putByte("purple", (byte) 0);
        }

        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if (InputConfigurationCardItem.getData(stack, "lightblue")) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".lightblue.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".lightblue.false"));
        }
        if (InputConfigurationCardItem.getData(stack, "cyan")) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".cyan.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".cyan.false"));
        }
        if (InputConfigurationCardItem.getData(stack, "blue")) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".blue.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".blue.false"));
        }
        if (InputConfigurationCardItem.getData(stack, "purple")) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".purple.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".purple.false"));
        }
        super.appendHoverText(stack, level, components, flag);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getLevel().isClientSide) {
            if (pContext.getItemInHand().getTagElement("data").getByte("lightblue") == 0) {
                pContext.getItemInHand().getTagElement("data").putByte("lightblue", (byte) 1);
            } else {
                pContext.getItemInHand().getTagElement("data").putByte("lightblue", (byte) 0);
            }
            System.out.println(pContext.getItemInHand().getTagElement("data").getByte("lightblue") != 0);
        }
        return super.useOn(pContext);
    }
}
