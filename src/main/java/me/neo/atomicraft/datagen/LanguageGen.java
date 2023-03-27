package me.neo.atomicraft.datagen;

import me.neo.atomicraft.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguageGen extends LanguageProvider {
    public LanguageGen(DataGenerator generator, String mod_id, String locale) {
        super(generator, mod_id, locale);
    }

    @Override
    protected void addTranslations() {
        add(BlockInit.CTM_TRANSPARENCY_TEST.get(), "Transparency Test");
    }
}
