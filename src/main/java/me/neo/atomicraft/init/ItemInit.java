package me.neo.atomicraft.init;

import me.neo.atomicraft.AtomiCraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AtomiCraft.MOD_ID);

    public static final RegistryObject<Item> BURNED_POTATO = ITEMS.register("burned_potato", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> KELP_DUST = ITEMS.register("kelp_dust", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> POTASH = ITEMS.register("potash", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> POTASSIUM_IODIDE_PILL = ITEMS.register("potassium_iodide_pill", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1)));

    public static final RegistryObject<Item> PESTLE_AND_MORTAR = ITEMS.register("pestle_and_mortar", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).durability(48)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
