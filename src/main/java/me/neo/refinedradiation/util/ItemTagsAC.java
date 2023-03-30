package me.neo.refinedradiation.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ItemTagsAC {
    public static final TagKey<Item> BURNED_POTATO = forgeTag("burned_potato");
    public static final TagKey<Item> POTASH = forgeTag("potash");
    public static final TagKey<Item> POTASSIUM_DUST = forgeTag("potassium_dust");
    public static final TagKey<Item> KELP_DUST = forgeTag("kelp_dust");
    public static final TagKey<Item> IODINE_DUST = forgeTag("iodine_dust");
    public static final TagKey<Item> POTASSIUM_IODIDE_PILL = forgeTag("potassium_iodide_pill");
    public static final TagKey<Item> PESTLE_AND_MORTAR = forgeTag("pestle_and_mortar");

    private static TagKey<Item> forgeTag(String name) {
        return ItemTags.create(new ResourceLocation("forge", name));
    }
}
