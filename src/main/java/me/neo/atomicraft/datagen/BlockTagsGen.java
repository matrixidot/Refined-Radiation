package me.neo.atomicraft.datagen;

import me.neo.atomicraft.AtomiCraft;
import me.neo.atomicraft.init.BlockInit;
import me.neo.atomicraft.util.BlockTagsAC;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class BlockTagsGen extends BlockTagsProvider {
    public BlockTagsGen(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, AtomiCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockInit.LEAD_BLOCK.get())
                .add(BlockInit.RAW_LEAD_BLOCK.get())
                .add(BlockInit.LEAD_ORE.get())
                .add(BlockInit.DEEPSLATE_LEAD_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL);

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BlockInit.LEAD_BLOCK.get())
                .add(BlockInit.RAW_LEAD_BLOCK.get())
                .add(BlockInit.LEAD_ORE.get())
                .add(BlockInit.DEEPSLATE_LEAD_ORE.get());
        tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(BlockInit.LEAD_BLOCK.get());

        tag(Tags.Blocks.ORES)
                .add(BlockInit.LEAD_ORE.get())
                .add(BlockInit.DEEPSLATE_LEAD_ORE.get());

        tag(BlockTagsAC.STORAGE_BLOCKS_LEAD).add(BlockInit.LEAD_BLOCK.get());

        tag(BlockTagsAC.ORES_LEAD).add(BlockInit.LEAD_ORE.get());
        tag(BlockTagsAC.ORES_LEAD).add(BlockInit.DEEPSLATE_LEAD_ORE.get());
    }
}
