package me.neo.refinedradiation.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.init.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public abstract class HazmatSuitHelmetOverlayMixin {

    public abstract Minecraft getMinecraft();


    @Shadow protected abstract void renderTextureOverlay(ResourceLocation pTextureLocation, float pAlpha);

    private final ResourceLocation HAZMAT_SUIT_HELMET_OVERLAY_LOCATION = new ResourceLocation(RefinedRadiation.MOD_ID, "textures/misc/hazmat_suit_helmet_overlay.png");

    @Inject(at = @At("HEAD"), method = "render")
    public void render(PoseStack pPoseStack, float pPartialTick, CallbackInfo ci) {
        System.out.println("first person2");
        if (getMinecraft().options.getCameraType().isFirstPerson() && getMinecraft().player != null) {
            System.out.println("first person");
            if (!getMinecraft().player.isScoping()) {
                System.out.println("not scoping");
                ItemStack itemstack = getMinecraft().player.getInventory().getArmor(3);
                if (itemstack.is(ItemInit.HAZMAT_SUIT_HELMET.get())) {
                    renderTextureOverlay(HAZMAT_SUIT_HELMET_OVERLAY_LOCATION, 1.0F);
                    System.out.println("rendering");
                }
            }
        }
    }
}
