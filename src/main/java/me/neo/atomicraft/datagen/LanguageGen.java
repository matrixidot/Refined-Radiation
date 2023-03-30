package me.neo.atomicraft.datagen;

import me.neo.atomicraft.init.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguageGen extends LanguageProvider {
    public LanguageGen(DataGenerator generator, String mod_id, String locale) {
        super(generator, mod_id, locale);
    }
    String DeathBy = "death.attack.";

    @Override
    protected void addTranslations() {
        add("itemGroup." + ModTab.ATOMI_CRAFT.getRecipeFolderName(), "AtomiCraft");

        add(BlockInit.CTM_TRANSPARENCY_TEST.get(), "Transparency Test");
        add(BlockInit.REINFORCED_CONCRETE.get(), "Reinforced Concrete");


        add(BlockInit.LEAD_BLOCK.get(), "Block of Lead");
        add(BlockInit.RAW_LEAD_BLOCK.get(), "Block of Raw Lead");
        add(BlockInit.LEAD_ORE.get(), "Lead Ore");
        add(BlockInit.DEEPSLATE_LEAD_ORE.get(), "Deepslate Lead Ore");

        add(ItemInit.LEAD_INGOT.get(), "Lead Ingot");
        add(ItemInit.LEAD_NUGGET.get(), "Lead Nugget");
        add(ItemInit.RAW_LEAD.get(), "Raw Lead");


        add(ItemInit.BURNED_POTATO.get(), "Burned Potato");
        add(ItemInit.POTASH.get(), "Potash");
        add(ItemInit.POTASSIUM_DUST.get(), "Potassium Dust");
        add(ItemInit.KELP_DUST.get(), "Kelp Dust");
        add(ItemInit.IODINE_DUST.get(), "Iodine Dust");
        add(ItemInit.POTASSIUM_IODIDE_PILL.get(), "Potassium Iodide Pill");
        add(ItemInit.PESTLE_AND_MORTAR.get(), "Pestle and Mortar");


        add(EffectInit.RADIATION_POISONING.get(), "Radiation Poisoning");
        add(DeathBy + DamageSourceInit.RADIATION_POISONING.getMsgId(), "%1$s was killed by radiation poisoning");
    }
}
