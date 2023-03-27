package me.neo.atomicraft.datagen.client;

import me.neo.atomicraft.AtomiCraft;
import me.neo.atomicraft.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateGen extends BlockStateProvider {
    public BlockStateGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, AtomiCraft.MOD_ID, helper);
    }
    @Override
    protected void registerStatesAndModels() {

    }
}
