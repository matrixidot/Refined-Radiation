package me.neo.refinedradiation.integration;

import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.init.BlockInit;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class TestBlockRecipeCategory implements IRecipeCategory<TestBlockRecipeCategory> {
    public final static ResourceLocation UID = new ResourceLocation(RefinedRadiation.MOD_ID, "gem_cutting");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(RefinedRadiation.MOD_ID, "textures/gui/gem_cutting_station_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public TestBlockRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockInit.TEST.get()));
    }


    @Override
    public RecipeType<TestBlockRecipeCategory> getRecipeType() {
        return RecipeType.create("test_block", "TestRecipe.class", TestBlockRecipeCategory.class);
    }

    @Override
    public Component getTitle() {
        return Component.literal("Test Block");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TestBlockRecipeCategory recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT,56, 35).addIngredients(Ingredient.of((Items.DIRT).getDefaultInstance()));
        builder.addSlot(RecipeIngredientRole.OUTPUT,125, 35).addIngredients(Ingredient.of((Items.DIAMOND).getDefaultInstance()));
    }
}
