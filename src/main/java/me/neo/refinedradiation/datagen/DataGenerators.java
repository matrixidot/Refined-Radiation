package me.neo.refinedradiation.datagen;

import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.datagen.client.BlockStateGen;
import me.neo.refinedradiation.datagen.client.ItemModelGen;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RefinedRadiation.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        ExistingFileHelper existingFileHelper = e.getExistingFileHelper();

        generator.addProvider(e.includeClient(), new BlockStateGen(generator, existingFileHelper));
        generator.addProvider(e.includeClient(), new ItemModelGen(generator, existingFileHelper));

        BlockTagsGen blockTags = new BlockTagsGen(generator, existingFileHelper);
        generator.addProvider(true, blockTags);
        generator.addProvider(true, new ItemTagsGen(generator, blockTags, existingFileHelper));

        generator.addProvider(true, new LootTableGen(generator));
        generator.addProvider(true, new RecipeGen(generator));

        generator.addProvider(true, new LanguageGen(generator, RefinedRadiation.MOD_ID, "en_us"));
    }
}
