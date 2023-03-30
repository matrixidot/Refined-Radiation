package me.neo.refinedradiation.datagen;

import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.init.BlockInit;
import me.neo.refinedradiation.init.ItemInit;
import me.neo.refinedradiation.util.ItemTagsAC;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ItemTagsGen extends ItemTagsProvider {
    public ItemTagsGen(DataGenerator generator, BlockTagsProvider provider, @Nullable ExistingFileHelper helper) {
        super(generator, provider, RefinedRadiation.MOD_ID, helper);
    }

    @Override
    protected void addTags() {
        tag(ItemTagsAC.BURNED_POTATO).add(ItemInit.BURNED_POTATO.get());
        tag(ItemTagsAC.POTASH).add(ItemInit.POTASH.get());
        tag(ItemTagsAC.POTASSIUM_DUST).add(ItemInit.POTASSIUM_DUST.get());
        tag(ItemTagsAC.KELP_DUST).add(ItemInit.KELP_DUST.get());
        tag(ItemTagsAC.IODINE_DUST).add(ItemInit.IODINE_DUST.get());
        tag(ItemTagsAC.POTASSIUM_IODIDE_PILL).add(ItemInit.POTASSIUM_IODIDE_PILL.get());
        tag(ItemTagsAC.PESTLE_AND_MORTAR).add(ItemInit.PESTLE_AND_MORTAR.get());

        tag(Tags.Items.INGOTS)
                .add(ItemInit.LEAD_INGOT.get());
        tag(Tags.Items.STORAGE_BLOCKS)
                .add(BlockInit.LEAD_BLOCK.get().asItem())
                .add(BlockInit.RAW_LEAD_BLOCK.get().asItem());
        tag(Tags.Items.NUGGETS)
                .add(ItemInit.LEAD_NUGGET.get());
        tag(Tags.Items.RAW_MATERIALS)
                .add(ItemInit.RAW_LEAD.get());
    }
}
