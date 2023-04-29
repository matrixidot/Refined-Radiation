package me.neo.refinedradiation.util;

import me.neo.refinedradiation.RefinedRadiation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BlockTagsAC {

    public static final TagKey<Block> ORES_LEAD = forgeTag("ores/lead");
    public static final TagKey<Block> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");
    public static final TagKey<Block> ORES_AURORIUM = forgeTag("ores/aurorium");
    public static final TagKey<Block> STORAGE_BLOCKS_AURORIUM = forgeTag("storage_blocks/aurorium");
    public static final TagKey<Block> STORAGE_BLOCKS_STEEL = forgeTag("storage_blocks/steel");


    private static TagKey<Block> forgeTag(String name) {
        return BlockTags.create(new ResourceLocation("forge", name));
    }

    private static TagKey<Block> acTag(String name) {
        return BlockTags.create(new ResourceLocation(RefinedRadiation.MOD_ID, name));
    }
}
