package me.neo.refinedradiation.datagen.loot;

import me.neo.refinedradiation.init.BlockInit;
import me.neo.refinedradiation.init.ItemInit;
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
        this.add(BlockInit.LEAD_ORE.get(), (block) -> createOreDrop(BlockInit.LEAD_ORE.get(), ItemInit.RAW_LEAD.get()));
        this.add(BlockInit.DEEPSLATE_LEAD_ORE.get(), (block) -> createOreDrop(BlockInit.DEEPSLATE_LEAD_ORE.get(), ItemInit.RAW_LEAD.get()));
    }

    private void blockDrops() {
        this.dropSelf(BlockInit.CTM_TRANSPARENCY_TEST.get());
        this.dropSelf(BlockInit.REINFORCED_CONCRETE.get());
        this.dropSelf(BlockInit.TEST.get());

        this.dropSelf(BlockInit.STEEL_BLOCK.get());

        this.dropSelf(BlockInit.LEAD_BLOCK.get());
        this.dropSelf(BlockInit.RAW_LEAD_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
