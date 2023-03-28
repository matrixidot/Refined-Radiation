package me.neo.atomicraft.mixin;

import me.neo.atomicraft.init.EffectInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.effect.MobEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class oPortalTimeMixin {

    @Inject(at = @At("HEAD"), method = "handleNetherPortalClient")
    private void handleNetherPortalClient(CallbackInfo ci) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player != null) {
            player.oPortalTime = player.portalTime;
            if (player.hasEffect(EffectInit.RADIATION_POISONING.get()) && player.getEffect(EffectInit.RADIATION_POISONING.get()).getDuration() > 60) {
                player.portalTime += 0.006666667F;
                if (player.portalTime > 1.0F) {
                    player.portalTime = 1.0F;
                }
            } else {
                if (player.portalTime > 0.0F) {
                    player.portalTime -= 0.05F;
                }

                if (player.portalTime < 0.0F) {
                    player.portalTime = 0.0F;
                }
            }
        }
    }
}
