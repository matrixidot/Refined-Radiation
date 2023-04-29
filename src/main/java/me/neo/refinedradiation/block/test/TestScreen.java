package me.neo.refinedradiation.block.test;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import me.neo.refinedradiation.RefinedRadiation;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.Collections;
import java.util.List;

public class TestScreen extends AbstractContainerScreen<TestMenu> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(RefinedRadiation.MOD_ID, "textures/gui/electric_furnace.png");
    private static boolean leftwing = false;
    private static boolean rightwing = false;

    public TestScreen(TestMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        this.addWidget(new Button(x - 45, y + 0, 9, 82, Component.literal("hi"), (buttonWidget) -> {
            if (leftwing) {
                leftwing = false;
            }
        }));
        this.addWidget(new Button(x + 212, y + 0, 9, 82, Component.literal("hi"), (buttonWidget) -> {
            if (rightwing) {
                rightwing = false;
            }
        }));
        this.addWidget(new Button(x - 0, y + 0, 9, 82, Component.literal("hi"), (buttonWidget) -> {
            if (!leftwing) {
                leftwing = true;
            }
        }));
        this.addWidget(new Button(x + 167, y + 0, 9, 82, Component.literal("hi"), (buttonWidget) -> {
            if (!rightwing) {
                rightwing = true;
            }
        }));
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

        blit(pPoseStack, x + 13, y + 17 + 54 - e, 108, 197 + 54 - e, 12, e);

        if (pMouseX > x + 27 && pMouseX < x + 32 && pMouseY > y + 42 && pMouseY < y + 51) {
            blit(pPoseStack, x + 28, y + 43, 108, 172, 4, 8);
        }
        if (leftwing) {
            blit(pPoseStack, x - 45, y, 0, 166, 54, 83);
            if (pMouseX > x + -46 && pMouseX < x - 36 && pMouseY >= y + 0 && pMouseY <= y + 81) {
                blit(pPoseStack, x + -42, y + 40, 111, 166, 3, 6);
            }
        } else {
            if (pMouseX > x + 0 && pMouseX < x + 9 && pMouseY >= y + 0 && pMouseY <= y + 81) {
                blit(pPoseStack, x + 3, y + 40, 108, 166, 3, 6);
            }
        }
        if (rightwing) {
            blit(pPoseStack, x + 167, y, 54, 166, 54, 83);
            if (pMouseX > x + 211 && pMouseX < x + 221 && pMouseY >= y + 0 && pMouseY <= y + 81) {
                blit(pPoseStack, x + 215, y + 40, 108, 166, 3, 6);
            }
        } else {
            if (pMouseX > x + 167 && pMouseX < x + 175 && pMouseY >= y + 0 && pMouseY <= y + 81) {
                blit(pPoseStack, x + 170, y + 40, 111, 166, 3, 6);
            }
        }

        if (menu.isWorking()) {
            // Stack, pos x, pos y, filled texture x, filled texture y, something, something
            blit(pPoseStack, x + 85, y + 35, 108, 180, menu.getScaledProgress(), 17);
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        int u = 0;
        if (menu.isWorking()) {
            u = 32;
        }
        if (mouseX > x + 27 && mouseX < x + 32 && mouseY > y + 42 && mouseY < y + 51) {
            renderComponentTooltip(pPoseStack, List.of(Component.literal(Math.round(menu.getEnergy()) + " RF"), Component.literal("Out of 8000 RF"), Component.literal("Using: " + u + " RF/t")), mouseX, mouseY);
        }
    }
}