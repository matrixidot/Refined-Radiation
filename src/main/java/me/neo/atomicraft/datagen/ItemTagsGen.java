package me.neo.atomicraft.datagen;

import me.neo.atomicraft.AtomiCraft;
import me.neo.atomicraft.init.ItemInit;
import me.neo.atomicraft.util.ItemTagsAC;
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
        tag(ItemTagsAC.BURNED_POTATO).add(ItemInit.BURNED_POTATO.get());
        tag(ItemTagsAC.KELP_DUST).add(ItemInit.KELP_DUST.get());
        tag(ItemTagsAC.POTASH).add(ItemInit.POTASH.get());
        tag(ItemTagsAC.POTASSIUM_IODIDE_PILL).add(ItemInit.POTASSIUM_IODIDE_PILL.get());
        tag(ItemTagsAC.PESTLE_AND_MORTAR).add(ItemInit.PESTLE_AND_MORTAR.get());
    }
}
