package me.neo.refinedradiation.datagen.client;

import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.init.BlockInit;
import net.minecraft.data.DataGenerator;
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

        simpleBlock(BlockInit.LEAD_BLOCK.get());
        simpleBlock(BlockInit.RAW_LEAD_BLOCK.get());
        simpleBlock(BlockInit.LEAD_ORE.get());
        simpleBlock(BlockInit.DEEPSLATE_LEAD_ORE.get());
    }
}