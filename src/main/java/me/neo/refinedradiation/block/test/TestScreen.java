package me.neo.refinedradiation.block.test;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import me.neo.refinedradiation.RefinedRadiation;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class TestScreen extends AbstractContainerScreen<TestMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(RefinedRadiation.MOD_ID, "textures/gui/electric_furnace.png");

    public TestScreen(TestMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        int e = Math.round((menu.getEnergy() / 8000) * 54);

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        blit(pPoseStack, x + 13, y + 17 + 54 - e, 176, 17 + 54 - e, 12, e);

        blit(pPoseStack, x - 45, y , 0, 166 , 54, 83);
        blit(pPoseStack, x + 167, y , 54, 166 , 54, 83);


        if (pMouseX > x + 27 && pMouseX < x + 32 && pMouseY > y + 42 && pMouseY < y + 51) {
            blit(pPoseStack, x + 28, y + 43, 108, 172 , 4, 8);
        }
        //else if (pMouseX > x + 0 && pMouseX < x + 9 && pMouseY >= y + 0 && pMouseY <= y + 81) {
        //    blit(pPoseStack, x + 3, y + 40, 108, 166 , 3, 6);
        //}
        //else if (pMouseX > x + 167 && pMouseX < x + 175 && pMouseY >= y + 0 && pMouseY <= y + 81) {
        //    blit(pPoseStack, x + 170, y + 40, 111, 166 , 3, 6);
        //}
        else if (pMouseX > x + -46 && pMouseX < x - 36 && pMouseY >= y + 0 && pMouseY <= y + 81) {
            blit(pPoseStack, x + -42, y + 40, 111, 166 , 3, 6);
        }
        else if (pMouseX > x + 211 && pMouseX < x + 221 && pMouseY >= y + 0 && pMouseY <= y + 81) {
            blit(pPoseStack, x + 215, y + 40, 108, 166, 3, 6);
        }


        renderProgressArrow(pPoseStack, x, y);
    }

    private void renderProgressArrow(PoseStack pPoseStack, int x, int y) {
        if(menu.isWorking()) {
        // Stack, pos x, pos y, filled texture x, filled texture y, something, something
            blit(pPoseStack, x + 85, y + 35, 177, 0, menu.getScaledProgress(), 17);
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}