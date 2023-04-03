package me.neo.refinedradiation;

import com.mojang.logging.LogUtils;
import me.neo.refinedradiation.block.test.TestScreen;
import me.neo.refinedradiation.init.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RefinedRadiation.MOD_ID)
public class RefinedRadiation {
    public static final String MOD_ID = "refinedradiation";
    private static final Logger LOGGER = LogUtils.getLogger();
    public RefinedRadiation() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.register(modEventBus);
        BlockInit.register(modEventBus);
        TileEntityInit.register(modEventBus);
        MenuInit.register(modEventBus);
        RecipeInit.register(modEventBus);
        EffectInit.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Packets.register();
        });
    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // SCREENS!!!
            MenuScreens.register(MenuInit.TEST.get(), TestScreen::new);
        }
    }
}
