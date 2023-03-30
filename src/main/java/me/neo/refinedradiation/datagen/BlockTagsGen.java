package me.neo.refinedradiation.datagen;

import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.init.BlockInit;
import me.neo.refinedradiation.util.BlockTagsAC;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class BlockTagsGen extends BlockTagsProvider {
    public BlockTagsGen(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, RefinedRadiation.MOD_ID, existingFileHelper);
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
