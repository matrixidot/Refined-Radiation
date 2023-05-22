package me.neo.refinedradiation.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.init.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public abstract class HazmatSuitHelmetOverlayMixin {

    @Shadow @Final protected Minecraft minecraft;


    @Shadow protected abstract void renderTextureOverlay(ResourceLocation pTextureLocation, float pAlpha);

    private ResourceLocation HAZMAT_SUIT_HELMET_OVERLAY_LOCATION = new ResourceLocation(RefinedRadiation.MOD_ID, "textures/misc/hazmat_suit_helmet_overlay.png");

    @Inject(at = @At("HEAD"), method = "render")
    public void render(PoseStack pPoseStack, float pPartialTick, CallbackInfo ci) {
        if (minecraft.options.getCameraType().isFirstPerson()) {
            if (!minecraft.player.isScoping()) {
                ItemStack itemstack = minecraft.player.getInventory().getArmor(3);
                if (itemstack.is(ItemInit.HAZMAT_SUIT_HELMET.get())) {
                    renderTextureOverlay(HAZMAT_SUIT_HELMET_OVERLAY_LOCATION, 1.0F);
                }
            }
        }
    }
}
