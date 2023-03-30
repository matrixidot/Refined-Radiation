package me.neo.atomicraft.util;

import me.neo.atomicraft.AtomiCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BlockTagsAC {

    public static final TagKey<Block> ORES_LEAD = forgeTag("ores/lead");
    public static final TagKey<Block> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");


    private static TagKey<Block> forgeTag(String name) {
        return BlockTags.create(new ResourceLocation("forge", name));
    }

    private static TagKey<Block> acTag(String name) {
        return BlockTags.create(new ResourceLocation(AtomiCraft.MOD_ID, name));
    }
}
