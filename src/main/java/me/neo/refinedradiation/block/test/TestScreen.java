package me.neo.refinedradiation.block.test;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import me.neo.refinedradiation.RefinedRadiation;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
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
    private static boolean wing = false;

    protected int imageWidth = 226;
    protected int imageHeight = 166;

    public TestScreen(TestMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        addWidget(new Button(x + 200, y + 58 , 13, 13, Component.literal("config"), (buttonWidget) -> {
            wing = !wing;
        }));

    }

    @Override
    protected void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        this.font.draw(pPoseStack, this.title, (float)this.titleLabelX + 19, (float)this.titleLabelY, 7634824);
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

        blit(pPoseStack, x + 30, y + 77 + 54 - e, 62, 179 + 54 - e, 12, e);

        if (wing) {
            blit(pPoseStack, x + 216, y + 13, 0, 166, 62, 64);
            blit(pPoseStack, x + 200, y + 58 , 75, 166, 13, 13);
        }

        if (menu.isWorking()) {
            // Stack, pos x, pos y, filled texture x, filled texture y, something, something
            blit(pPoseStack, x + 106, y + 37, 74, 179, menu.getScaledProgress(), 17);
        }
        if (pMouseX >= x + 200 - 1 && pMouseX <= x + 200 + 13 - 1 && pMouseY >= y + 58 - 1 && pMouseY <= y + 58 + 13 - 1) {
            blit(pPoseStack, x + 200, y + 58, 62, 166, 13, 13);
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        if (mouseX >= x + 30 && mouseX <= x + 41 && mouseY >= y + 77 && mouseY <= y + 128) {
            renderComponentTooltip(pPoseStack, List.of(Component.literal(Math.round(menu.getEnergy()) + " RF"), Component.literal("Out of 8000 RF"), Component.literal("Using: " + 32 * (menu.isWorking() ? 1 : 0 ) + " RF/t")), mouseX, mouseY);
        }
    }
}