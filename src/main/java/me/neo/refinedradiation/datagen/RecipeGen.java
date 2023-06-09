package me.neo.refinedradiation.datagen;

import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.init.BlockInit;
import me.neo.refinedradiation.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class RecipeGen extends RecipeProvider {
    public RecipeGen(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipe) {

        ShapedRecipeBuilder.shaped(ItemInit.PESTLE_AND_MORTAR.get(), 1).pattern(" W ").pattern("S S").pattern(" S ")
                .define('W', Items.ANDESITE_WALL).define('S', Items.ANDESITE_SLAB)
                .unlockedBy("has_item", has(Items.ANDESITE)).save(recipe, modId("pestle_and_mortar"));

        ShapedRecipeBuilder.shaped(ItemInit.INPUT_CONFIGURATION_CARD.get(), 1).pattern("SLS").pattern("CBP").pattern("SGS")
                .define('S', ItemInit.STEEL_INGOT.get()).define('L', Items.LIGHT_BLUE_DYE).define('C', Items.CYAN_DYE).define('B', Items.BLUE_DYE).define('P', Items.PURPLE_DYE).define('G', Items.GOLD_INGOT)
                .unlockedBy("has_item", has(ItemInit.STEEL_INGOT.get())).save(recipe, modId("input_configuration_card"));
        ShapedRecipeBuilder.shaped(ItemInit.OUTPUT_CONFIGURATION_CARD.get(), 1).pattern("SRS").pattern("OYP").pattern("SGS")
                .define('S', ItemInit.STEEL_INGOT.get()).define('R', Items.RED_DYE).define('O', Items.ORANGE_DYE).define('Y', Items.YELLOW_DYE).define('P', Items.PINK_DYE).define('G', Items.GOLD_INGOT)
                .unlockedBy("has_item", has(ItemInit.STEEL_INGOT.get())).save(recipe, modId("output_configuration_card"));


        ShapelessRecipeBuilder.shapeless(ItemInit.POTASH.get(), 2).requires(ItemInit.BURNED_POTATO.get(), 1).requires(ItemInit.PESTLE_AND_MORTAR.get(), 1)
                .unlockedBy("has_item", has(ItemInit.BURNED_POTATO.get())).save(recipe, modId("potash"));
        ShapelessRecipeBuilder.shapeless(ItemInit.POTASSIUM_DUST.get(), 1).requires(ItemInit.POTASH.get(), 4)
                .unlockedBy("has_item", has(ItemInit.POTASH.get())).save(recipe, modId("potassium_dust"));

        ShapelessRecipeBuilder.shapeless(ItemInit.KELP_DUST.get(), 2).requires(Items.DRIED_KELP, 1).requires(ItemInit.PESTLE_AND_MORTAR.get(), 1)
                .unlockedBy("has_item", has(Items.DRIED_KELP)).save(recipe, modId("kelp_dust"));
        ShapelessRecipeBuilder.shapeless(ItemInit.IODINE_DUST.get(), 8).requires(ItemInit.KELP_DUST.get(), 8).requires(Items.WATER_BUCKET, 1)
                .unlockedBy("has_item", has(ItemInit.KELP_DUST.get())).save(recipe, modId("iodine_dust"));

        ShapelessRecipeBuilder.shapeless(ItemInit.POTASSIUM_IODIDE_PILL.get(), 1).requires(ItemInit.POTASSIUM_DUST.get(), 1).requires(ItemInit.IODINE_DUST.get(), 2).requires(Items.SUGAR, 1)
                .unlockedBy("has_item", has(ItemInit.PESTLE_AND_MORTAR.get())).save(recipe, modId("potassium_iodide_pill"));

        cook(recipe, Items.BAKED_POTATO, ItemInit.BURNED_POTATO.get(), .7f, 200, "burned_potato");

        storageBlock(recipe, ItemInit.LEAD_NUGGET.get(), ItemInit.LEAD_INGOT.get(), "lead_i");
        storageBlock(recipe, ItemInit.LEAD_INGOT.get(), BlockInit.LEAD_BLOCK.get(), "lead_b");
        storageBlock(recipe, ItemInit.RAW_LEAD.get(), BlockInit.RAW_LEAD_BLOCK.get(), "raw_lead_b");
        storageBlock(recipe, ItemInit.LEAD_DUST.get(), BlockInit.LEAD_DUST_BLOCK.get(), "lead_db");

        storageBlock(recipe, ItemInit.AURORIUM_NUGGET.get(), ItemInit.AURORIUM_INGOT.get(), "aurorium_i");
        storageBlock(recipe, ItemInit.AURORIUM_INGOT.get(), BlockInit.AURORIUM_BLOCK.get(), "aurorium_b");
        storageBlock(recipe, ItemInit.RAW_AURORIUM.get(), BlockInit.RAW_AURORIUM_BLOCK.get(), "raw_aurorium_b");
        storageBlock(recipe, ItemInit.AURORIUM_DUST.get(), BlockInit.AURORIUM_DUST_BLOCK.get(), "aurorium_db");
        storageBlock(recipe, ItemInit.RAW_AURORIUM_DUST.get(), BlockInit.RAW_AURORIUM_DUST_BLOCK.get(), "raw_aurorium_db");

        storageBlock(recipe, ItemInit.STEEL_NUGGET.get(), ItemInit.STEEL_INGOT.get(), "steel_i");
        storageBlock(recipe, ItemInit.STEEL_INGOT.get(), BlockInit.STEEL_BLOCK.get(), "steel_b");
        storageBlock(recipe, ItemInit.STEEL_DUST.get(), BlockInit.STEEL_DUST_BLOCK.get(), "steel_db");


        smelt(recipe, ItemInit.RAW_LEAD.get(), ItemInit.LEAD_INGOT.get(), .7f, 200, "lead_i");

        blast_only(recipe, Items.IRON_INGOT, ItemInit.STEEL_INGOT.get(), .7f, 200, "steel_i");
    }



    public void smelt(Consumer<FinishedRecipe> finishedRecipe, ItemLike in, ItemLike out, float exp, int time, String name) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(in), out, exp, time)
                .unlockedBy("has_item", has(in)).save(finishedRecipe, modId(name + "_smelt"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(in), out, exp, time/2)
                .unlockedBy("has_item", has(in)).save(finishedRecipe, modId(name + "_blast"));
    }

    public void blast_only(Consumer<FinishedRecipe> finishedRecipe, ItemLike in, ItemLike out, float exp, int time, String name) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(in), out, exp, time)
                .unlockedBy("has_item", has(in)).save(finishedRecipe, modId(name + "_blast"));
    }
    public void cook(Consumer<FinishedRecipe> finishedRecipe, ItemLike in, ItemLike out, float exp, int time, String name) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(in), out, exp, time)
                .unlockedBy("has_item", has(in)).save(finishedRecipe, modId(name + "_smelt"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(in), out, exp, time/2)
                .unlockedBy("has_item", has(in)).save(finishedRecipe, modId(name + "_smoke"));
    }

    private void storageBlock(Consumer<FinishedRecipe> recipeConsumer, ItemLike unpacked, ItemLike packed, String name) {
        ShapelessRecipeBuilder.shapeless(unpacked, 9).requires(packed).unlockedBy(getHasName(packed), has(packed)).save(recipeConsumer, modId(name + "_unpack"));
        ShapedRecipeBuilder.shaped(packed).define('#', unpacked).pattern("###").pattern("###").pattern("###").unlockedBy(getHasName(unpacked), has(unpacked)).save(recipeConsumer, modId(name + "_pack"));
    }
    private ResourceLocation modId(String path) {
        return new ResourceLocation(RefinedRadiation.MOD_ID, path);
    }
}
