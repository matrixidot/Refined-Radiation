package me.neo.refinedradiation.init;

import me.neo.refinedradiation.RefinedRadiation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RefinedRadiation.MOD_ID);
    /* TILES */


    /* BLOCKS */
    public static final RegistryObject<Block> CTM_TRANSPARENCY_TEST = registerBlock("ctm_transparency_test",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()), ModTab.ATOMI_CRAFT);

    public static final RegistryObject<Block> REINFORCED_CONCRETE = registerBlock("reinforced_concrete",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)), ModTab.ATOMI_CRAFT);

    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), ModTab.ATOMI_CRAFT);
    public static final RegistryObject<Block> RAW_LEAD_BLOCK = registerBlock("raw_lead_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)), ModTab.ATOMI_CRAFT);
    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)), ModTab.ATOMI_CRAFT);
    public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)), ModTab.ATOMI_CRAFT);










    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}