package me.neo.refinedradiation.datagen.client;

import me.neo.refinedradiation.RefinedRadiation;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGen extends ItemModelProvider {
    public ItemModelGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, RefinedRadiation.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("ctm_transparency_test", modLoc("block/ctm_transparency_test"));
        withExistingParent("reinforced_concrete", modLoc("block/reinforced_concrete"));

        withExistingParent("lead_block", modLoc("block/lead_block"));
        withExistingParent("raw_lead_block", modLoc("block/raw_lead_block"));
        withExistingParent("lead_ore", modLoc("block/lead_ore"));
        withExistingParent("deepslate_lead_ore", modLoc("block/deepslate_lead_ore"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        builder(itemGenerated, "burned_potato");
        builder(itemGenerated, "potash");
        builder(itemGenerated, "potassium_dust");
        builder(itemGenerated, "kelp_dust");
        builder(itemGenerated, "iodine_dust");
        builder(itemGenerated, "potassium_iodide_pill");
        builder(itemGenerated, "pestle_and_mortar");

        builder(itemGenerated, "lead_ingot");
        builder(itemGenerated, "lead_nugget");
        builder(itemGenerated, "raw_lead");
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}