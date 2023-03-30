package me.neo.refinedradiation.init;

import me.neo.refinedradiation.RefinedRadiation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeInit {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, RefinedRadiation.MOD_ID);
    /* Recipe Serializers go here */


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
