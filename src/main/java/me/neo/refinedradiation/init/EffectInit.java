package me.neo.refinedradiation.init;

import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.effects.RadiationPoisoning;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectInit {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, RefinedRadiation.MOD_ID);

    public static final RegistryObject<MobEffect> RADIATION_POISONING = MOB_EFFECTS.register("radiation_poisoning",
            () -> new RadiationPoisoning(MobEffectCategory.HARMFUL, 10420213));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}