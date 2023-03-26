package me.neo.atomicraft.datagen.loot;

import me.neo.atomicraft.init.BlockInit;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class BlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
        oreDrops();
        blockDrops();
    }

    private void oreDrops() {

    }

    private void blockDrops() {

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
