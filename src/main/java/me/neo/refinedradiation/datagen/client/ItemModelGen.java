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
        withExistingParent("test", modLoc("block/test"));

        withExistingParent("rubber_tree_leaves", modLoc("block/rubber_tree_leaves"));
        withExistingParent("rubber_tree_log", modLoc("block/rubber_tree_log"));
        withExistingParent("stripped_rubber_tree_log", modLoc("block/stripped_rubber_tree_log"));
        withExistingParent("rubber_tree_planks", modLoc("block/rubber_tree_planks"));
        withExistingParent("rubber_tree_trapdoor", modLoc("block/rubber_tree_trapdoor_bottom"));
        withExistingParent("rubber_tree_wood", modLoc("block/rubber_tree_wood"));
        withExistingParent("stripped_rubber_tree_wood", modLoc("block/stripped_rubber_tree_wood"));
        withExistingParent("rubber_tree_fence", modLoc("block/rubber_tree_fence_post"));
        withExistingParent("rubber_tree_fence_gate", modLoc("block/rubber_tree_fence_gate_open"));
        withExistingParent("rubber_tree_stairs", modLoc("block/rubber_tree_stairs"));
        withExistingParent("rubber_tree_slab", modLoc("block/rubber_tree_slab"));
        withExistingParent("rubber_tree_button", modLoc("block/rubber_tree_button"));
        withExistingParent("rubber_tree_pressure_plate", modLoc("block/rubber_tree_pressure_plate"));


        withExistingParent("steel_block", modLoc("block/steel_block"));
        withExistingParent("steel_dust_block", modLoc("block/steel_dust_block"));

        withExistingParent("lead_block", modLoc("block/lead_block"));
        withExistingParent("raw_lead_block", modLoc("block/raw_lead_block"));
        withExistingParent("lead_ore", modLoc("block/lead_ore"));
        withExistingParent("deepslate_lead_ore", modLoc("block/deepslate_lead_ore"));
        withExistingParent("lead_dust_block", modLoc("block/lead_dust_block"));

        withExistingParent("aurorium_block", modLoc("block/aurorium_block"));
        withExistingParent("raw_aurorium_block", modLoc("block/raw_aurorium_block"));
        withExistingParent("aurorium_ore", modLoc("block/aurorium_ore"));
        withExistingParent("deepslate_aurorium_ore", modLoc("block/deepslate_aurorium_ore"));
        withExistingParent("aurorium_dust_block", modLoc("block/aurorium_dust_block"));
        withExistingParent("raw_aurorium_dust_block", modLoc("block/raw_aurorium_dust_block"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, "burned_potato");
        builder(itemGenerated, "potash");
        builder(itemGenerated, "potassium_dust");
        builder(itemGenerated, "kelp_dust");
        builder(itemGenerated, "iodine_dust");
        builder(itemGenerated, "potassium_iodide_pill");
        builder(itemGenerated, "pestle_and_mortar");

        builder(itemGenerated, "steel_ingot");
        builder(itemGenerated, "steel_nugget");
        builder(itemGenerated, "steel_dust");

        builder(itemGenerated, "lead_ingot");
        builder(itemGenerated, "lead_nugget");
        builder(itemGenerated, "raw_lead");
        builder(itemGenerated, "lead_dust");

        builder(itemGenerated, "aurorium_ingot");
        builder(itemGenerated, "aurorium_nugget");
        builder(itemGenerated, "raw_aurorium");
        builder(itemGenerated, "aurorium_dust");
        builder(itemGenerated, "raw_aurorium_dust");

        builder(itemGenerated, "hazmat_suit_helmet");
        builder(itemGenerated, "hazmat_suit_chestplate");
        builder(itemGenerated, "hazmat_suit_leggings");
        builder(itemGenerated, "hazmat_suit_boots");

        builder(itemGenerated, "rubber_tree_door");
        builder(itemGenerated, "rubber_tree_sign");
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
