package me.neo.refinedradiation.datagen.client;

import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateGen extends BlockStateProvider {
    public BlockStateGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, RefinedRadiation.MOD_ID, helper);
    }
    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockInit.REINFORCED_CONCRETE.get());
        simpleBlock(BlockInit.CTM_TRANSPARENCY_TEST.get());

        axisBlock((RotatedPillarBlock) BlockInit.STRIPPED_RUBBER_TREE_LOG.get(), modLoc("block/stripped_rubber_tree_log"), modLoc("block/stripped_rubber_tree_log_top"));
        axisBlock((RotatedPillarBlock) BlockInit.RUBBER_TREE_LOG.get(), modLoc("block/rubber_tree_log"), modLoc("block/rubber_tree_log_top"));
        simpleBlock(BlockInit.RUBBER_TREE_PLANKS.get());

        simpleBlock(BlockInit.STEEL_BLOCK.get());
        simpleBlock(BlockInit.STEEL_DUST_BLOCK.get());

        simpleBlock(BlockInit.LEAD_BLOCK.get());
        simpleBlock(BlockInit.RAW_LEAD_BLOCK.get());
        simpleBlock(BlockInit.LEAD_ORE.get());
        simpleBlock(BlockInit.DEEPSLATE_LEAD_ORE.get());
        simpleBlock(BlockInit.LEAD_DUST_BLOCK.get());

        simpleBlock(BlockInit.AURORIUM_BLOCK.get());
        simpleBlock(BlockInit.RAW_AURORIUM_BLOCK.get());
        simpleBlock(BlockInit.AURORIUM_ORE.get());
        simpleBlock(BlockInit.DEEPSLATE_AURORIUM_ORE.get());
        simpleBlock(BlockInit.AURORIUM_DUST_BLOCK.get());
        simpleBlock(BlockInit.RAW_AURORIUM_DUST_BLOCK.get());
    }
}
