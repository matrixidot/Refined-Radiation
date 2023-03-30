package me.neo.atomicraft.init;

import me.neo.atomicraft.AtomiCraft;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeInit {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AtomiCraft.MOD_ID);
    /* Recipe Serializers go here */


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
