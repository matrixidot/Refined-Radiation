package me.neo.refinedradiation.datagen.client.registries;

import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.init.BlockInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RefinedRadiation.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BlockRenderTypeRegistry {

    @SubscribeEvent
    public static void register(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlockInit.CTM_TRANSPARENCY_TEST.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.RUBBER_TREE_LEAVES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.RUBBER_TREE_SAPLING.get(), RenderType.cutout());
    }
}