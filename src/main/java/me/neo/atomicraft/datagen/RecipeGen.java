package me.neo.atomicraft.datagen;

import me.neo.atomicraft.AtomiCraft;
import me.neo.atomicraft.init.ItemInit;
import me.neo.atomicraft.util.ItemTagsAC;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

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
    }



    public void smelt(Consumer<FinishedRecipe> finishedRecipe, ItemLike in, ItemLike out, float exp, int time, String name) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(in), out, exp, time)
                .unlockedBy("has_item", has(in)).save(finishedRecipe, modId(name + "_smelt"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(in), out, exp, time/2)
                .unlockedBy("has_item", has(in)).save(finishedRecipe, modId(name + "_blast"));
    }
    public void cook(Consumer<FinishedRecipe> finishedRecipe, ItemLike in, ItemLike out, float exp, int time, String name) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(in), out, exp, time)
                .unlockedBy("has_item", has(in)).save(finishedRecipe, modId(name + "_smelt"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(in), out, exp, time/2)
                .unlockedBy("has_item", has(in)).save(finishedRecipe, modId(name + "_smoke"));
    }
    private ResourceLocation modId(String path) {
        return new ResourceLocation(AtomiCraft.MOD_ID, path);
    }
}
