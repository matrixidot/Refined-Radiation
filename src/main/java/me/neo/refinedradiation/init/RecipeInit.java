package me.neo.refinedradiation.init;

import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.block.test.TestRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeInit {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, RefinedRadiation.MOD_ID);
    /* Recipe Serializers go here */

    public static final RegistryObject<RecipeSerializer<TestRecipe>> TEST = SERIALIZERS.register("test_recipe",
            () -> TestRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
