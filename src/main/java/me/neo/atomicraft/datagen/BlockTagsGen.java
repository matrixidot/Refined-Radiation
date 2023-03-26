package me.neo.atomicraft.datagen;

import me.neo.atomicraft.AtomiCraft;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class BlockTagsGen extends BlockTagsProvider {
    public BlockTagsGen(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, AtomiCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
    }
}
