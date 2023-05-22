package me.neo.refinedradiation.util;

import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.custom.armor.hazmat_suit.HazmatSuitArmorRenderer;
import me.neo.refinedradiation.custom.item.HazmatSuitArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = RefinedRadiation.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(HazmatSuitArmorItem.class, new HazmatSuitArmorRenderer());
    }
}
