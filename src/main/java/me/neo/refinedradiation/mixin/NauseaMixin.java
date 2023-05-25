package me.neo.refinedradiation.mixin;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import me.neo.refinedradiation.init.EffectInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class NauseaMixin {
    @Shadow public abstract Minecraft getMinecraft();
    @Shadow protected abstract void renderConfusionOverlay(float pScalar);

    @Inject(at = @At("HEAD"), method = "render")
    private void render(float pPartialTicks, long pNanoTime, boolean pRenderLevel, CallbackInfo ci) {
        if (pRenderLevel && getMinecraft().level != null) {
            if (getMinecraft().player != null) {
                float f = Mth.lerp(pPartialTicks, getMinecraft().player.oPortalTime, getMinecraft().player.portalTime);
                float f1 = getMinecraft().options.screenEffectScale().get().floatValue();
                if (f > 0.0F && getMinecraft().player.hasEffect(EffectInit.RADIATION_POISONING.get()) && f1 < 1.0F) {
                    renderRadiationOverlay(f * (1.0F - f1));
                }
            }
        }
    }

    private static final ResourceLocation RADIATION_POISONING_LOCATION = new ResourceLocation("textures/misc/radiation_poisoning.png");

    private void renderRadiationOverlay(float pScalar) {
        int i = getMinecraft().getWindow().getGuiScaledWidth();
        int j = getMinecraft().getWindow().getGuiScaledHeight();
        double d0 = Mth.lerp(pScalar, 2.0D, 1.0D);
        float f = 0.2F * pScalar;
        float f1 = 0.4F * pScalar;
        float f2 = 0.2F * pScalar;
        double d1 = (double)i * d0;
        double d2 = (double)j * d0;
        double d3 = ((double)i - d1) / 2.0D;
        double d4 = ((double)j - d2) / 2.0D;
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        RenderSystem.setShaderColor(f, f1, f2, 1.0F);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, RADIATION_POISONING_LOCATION);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(d3, d4 + d2, -90.0D).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.vertex(d3 + d1, d4 + d2, -90.0D).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex(d3 + d1, d4, -90.0D).uv(1.0F, 0.0F).endVertex();
        bufferbuilder.vertex(d3, d4, -90.0D).uv(0.0F, 0.0F).endVertex();
        tesselator.end();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
    }

}
