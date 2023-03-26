package me.neo.atomicraft.datagen;

import me.neo.atomicraft.AtomiCraft;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ItemTagsGen extends ItemTagsProvider {
    public ItemTagsGen(DataGenerator generator, BlockTagsProvider provider, @Nullable ExistingFileHelper helper) {
        super(generator, provider, AtomiCraft.MOD_ID, helper);
    }

    @Override
    protected void addTags() {
    }
}
