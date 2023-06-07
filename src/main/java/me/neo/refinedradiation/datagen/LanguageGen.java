package me.neo.refinedradiation.datagen;

import me.neo.refinedradiation.init.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguageGen extends LanguageProvider {
    public LanguageGen(DataGenerator generator, String mod_id, String locale) {
        super(generator, mod_id, locale);
    }
    String DeathBy = "death.attack.";

    @Override
    protected void addTranslations() {
        add("itemGroup." + ModTab.RR.getRecipeFolderName(), "Refined Radiation");

        add(BlockInit.CTM_TRANSPARENCY_TEST.get(), "Transparency Test");
        add(BlockInit.REINFORCED_CONCRETE.get(), "Reinforced Concrete");

        add(BlockInit.RUBBER_TREE_LEAVES.get(), "Rubber Tree Leaves");
        add(BlockInit.RUBBER_TREE_LOG.get(), "Rubber Tree Log");
        add(BlockInit.STRIPPED_RUBBER_TREE_LOG.get(), "Stripped Rubber Tree Log");
        add(BlockInit.RUBBER_TREE_PLANKS.get(), "Rubber Tree Planks");
        add(BlockInit.RUBBER_TREE_TRAPDOOR.get(), "Rubber Tree Trapdoor");
        add(BlockInit.RUBBER_TREE_DOOR.get(), "Rubber Tree Door");
        add(BlockInit.RUBBER_TREE_WOOD.get(), "Rubber Tree Wood");
        add(BlockInit.STRIPPED_RUBBER_TREE_WOOD.get(), "Stripped Rubber Tree Wood");
        add(BlockInit.RUBBER_TREE_SAPLING.get(), "Rubber Tree Sapling");
        add(BlockInit.RUBBER_TREE_FENCE.get(), "Rubber Tree Fence");
        add(BlockInit.RUBBER_TREE_FENCE_GATE.get(), "Rubber Tree Fence Gate");
        add(BlockInit.RUBBER_TREE_STAIRS.get(), "Rubber Tree Stairs");
        add(BlockInit.RUBBER_TREE_SLAB.get(), "Rubber Tree Slab");
        add(BlockInit.RUBBER_TREE_PRESSURE_PLATE.get(), "Rubber Tree Pressure Plate");
        add(BlockInit.RUBBER_TREE_BUTTON.get(), "Rubber Tree Button");
        add(ItemInit.RUBBER_TREE_SIGN.get(), "Rubber Tree Sign");

        add(BlockInit.STEEL_BLOCK.get(), "Block of Steel");
        add(BlockInit.STEEL_DUST_BLOCK.get(), "Block of Dusted Steel");

        add(BlockInit.LEAD_BLOCK.get(), "Block of Lead");
        add(BlockInit.RAW_LEAD_BLOCK.get(), "Block of Raw Lead");
        add(BlockInit.LEAD_ORE.get(), "Lead Ore");
        add(BlockInit.DEEPSLATE_LEAD_ORE.get(), "Deepslate Lead Ore");
        add(BlockInit.LEAD_DUST_BLOCK.get(), "Block of Dusted Lead");

        add(BlockInit.AURORIUM_BLOCK.get(), "Block of Aurorium");
        add(BlockInit.RAW_AURORIUM_BLOCK.get(), "Block of Raw Aurorium");
        add(BlockInit.AURORIUM_ORE.get(), "Aurorium Ore");
        add(BlockInit.DEEPSLATE_AURORIUM_ORE.get(), "Deepslate Aurorium Ore");
        add(BlockInit.AURORIUM_DUST_BLOCK.get(), "Block of Dusted Aurorium");
        add(BlockInit.RAW_AURORIUM_DUST_BLOCK.get(), "Block of Raw Dusted Aurorium");

        add(BlockInit.TEST.get(), "Test Block");

        add(ItemInit.STEEL_INGOT.get(), "Steel Ingot");
        add(ItemInit.STEEL_NUGGET.get(), "Steel Nugget");
        add(ItemInit.STEEL_DUST.get(), "Steel Dust");

        add(ItemInit.LEAD_INGOT.get(), "Lead Ingot");
        add(ItemInit.LEAD_NUGGET.get(), "Lead Nugget");
        add(ItemInit.RAW_LEAD.get(), "Raw Lead");
        add(ItemInit.LEAD_DUST.get(), "Lead Dust");

        add(ItemInit.AURORIUM_INGOT.get(), "Aurorium Ingot");
        add(ItemInit.AURORIUM_NUGGET.get(), "Aurorium Nugget");
        add(ItemInit.RAW_AURORIUM.get(), "Raw Aurorium");
        add(ItemInit.AURORIUM_DUST.get(), "Aurorium Dust");
        add(ItemInit.RAW_AURORIUM_DUST.get(), "Raw Aurorium Dust");

        add(ItemInit.BURNED_POTATO.get(), "Burned Potato");
        add(ItemInit.POTASH.get(), "Potash");
        add(ItemInit.POTASSIUM_DUST.get(), "Potassium Dust");
        add(ItemInit.KELP_DUST.get(), "Kelp Dust");
        add(ItemInit.IODINE_DUST.get(), "Iodine Dust");
        add(ItemInit.POTASSIUM_IODIDE_PILL.get(), "Potassium Iodide Pill");
        add(ItemInit.PESTLE_AND_MORTAR.get(), "Pestle and Mortar");

        add(ItemInit.HAZMAT_SUIT_HELMET.get(), "Hazmat Suit Helmet");
        add(ItemInit.HAZMAT_SUIT_CHESTPLATE.get(), "Hazmat Suit Chestplate");
        add(ItemInit.HAZMAT_SUIT_LEGGING.get(), "Hazmat Suit Leggings");
        add(ItemInit.HAZMAT_SUIT_BOOTS.get(), "Hazmat Suit Boots");

        add(ItemInit.INPUT_CONFIGURATION_CARD.get(), "Input Configuration Card");
        add(ItemInit.OUTPUT_CONFIGURATION_CARD.get(), "Output Configuration Card");

        add("refinedradiation.container.test", "Electric Furnace");

        add("refinedradiation.lightblue.true", "§b█ §7Light Blue: §bTrue");
        add("refinedradiation.lightblue.false", "§8█ §7Light Blue: §cFalse");
        add("refinedradiation.cyan.true", "§3█ §7Cyan: §bTrue");
        add("refinedradiation.cyan.false", "§8█ §7Cyan: §cFalse");
        add("refinedradiation.blue.true", "§9█ §7Blue: §bTrue");
        add("refinedradiation.blue.false", "§8█ §7Blue: §cFalse");
        add("refinedradiation.purple.true", "§5█ §7Purple: §bTrue");
        add("refinedradiation.purple.false", "§8█ §7Purple: §cFalse");

        add("refinedradiation.red.true", "§c█ §7Red: §bTrue");
        add("refinedradiation.red.false", "§8█ §7Red: §cFalse");
        add("refinedradiation.orange.true", "§6█ §7Orange: §bTrue");
        add("refinedradiation.orange.false", "§8█ §7Orange: §cFalse");
        add("refinedradiation.yellow.true", "§e█ §7Yellow: §bTrue");
        add("refinedradiation.yellow.false", "§8█ §7Yellow: §cFalse");
        add("refinedradiation.pink.true", "§d█ §7Pink: §bTrue");
        add("refinedradiation.pink.false", "§8█ §7Pink: §cFalse");



        add(EffectInit.RADIATION_POISONING.get(), "Radiation Poisoning");
        add(DeathBy + DamageSourceInit.RADIATION_POISONING.getMsgId(), "%1$s was killed by radiation poisoning");
    }
}
