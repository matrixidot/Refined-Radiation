package me.neo.refinedradiation.block.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.util.BaseRecipeRR;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class TestRecipe extends BaseRecipeRR {
    public TestRecipe(ResourceLocation id) {
        super(id);
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return getInputs();
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return getOutput();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return getOutput().copy();
    }

    @Override
    public ResourceLocation getId() {
        return getRecipeID();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<TestRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "test_recipe";
    }

    public static class Serializer implements RecipeSerializer<TestRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(RefinedRadiation.MOD_ID, "test_recipe");

        @Override
        public TestRecipe fromJson(ResourceLocation id, JsonObject json) {
            TestRecipe recipe = new TestRecipe(id);
            JsonArray ingredientJson = json.getAsJsonArray("ingredients");
            recipe.setIngredients(NonNullList.withSize(1, Ingredient.EMPTY));

            recipe.setIngredientCount(GsonHelper.getAsInt(ingredientJson.get(0).getAsJsonObject(), "count"));

            for (int i = 0; i < recipe.getInputs().size(); i++)
                recipe.getInputs().set(i, Ingredient.fromJson(ingredientJson.get(i)));

            JsonArray miscJson = json.getAsJsonArray("misc");
            recipe.setProcessingTime(GsonHelper.getAsInt(miscJson.get(0).getAsJsonObject(), "time", 100));
            recipe.setPowerUsageTick(GsonHelper.getAsInt(miscJson.get(1).getAsJsonObject(), "power", 0));

            ResourceLocation itemResourceLocation = ResourceLocation.of(GsonHelper.getAsString(json.get("output").getAsJsonObject(), "item", "minecraft:air"), ':');
            recipe.setOutput(new ItemStack(ForgeRegistries.ITEMS.getValue(itemResourceLocation)));
            recipe.setOutputAmount(GsonHelper.getAsInt(json.get("output").getAsJsonObject(), "count", 1));
            return recipe;
        }

        @Override
        public @Nullable TestRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf buf) {
            TestRecipe recipe = new TestRecipe(pRecipeId);
            recipe.setIngredientCount(0, buf.readInt());
            recipe.setOutput(buf.readItem());
            recipe.setOutput(buf.readItem());
            return recipe;
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, TestRecipe recipe) {
            buf.writeInt(recipe.getIngredientAmount(0));
            buf.writeItem(recipe.getOutput());
            buf.writeInt(recipe.getOutputAmount());

            recipe.getIngredients().get(0).toNetwork(buf);
        }
    }
}
