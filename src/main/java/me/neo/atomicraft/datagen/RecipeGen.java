package me.neo.atomicraft.datagen;

import me.neo.atomicraft.AtomiCraft;
import me.neo.atomicraft.init.ItemInit;
import me.neo.atomicraft.util.ItemTagsAC;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
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

    }
    private ResourceLocation modId(String path) {
        return new ResourceLocation(AtomiCraft.MOD_ID, path);
    }
}
