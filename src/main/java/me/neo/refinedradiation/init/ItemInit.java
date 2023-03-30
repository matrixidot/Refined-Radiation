package me.neo.refinedradiation.init;

import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.custom.item.PestleAndMortarItem;
import me.neo.refinedradiation.custom.item.PotassiumIodinePillItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RefinedRadiation.MOD_ID);

    public static final RegistryObject<Item> BURNED_POTATO = ITEMS.register("burned_potato", () ->
            new Item(new Item.Properties().tab(ModTab.ATOMI_CRAFT)));
    public static final RegistryObject<Item> POTASH = ITEMS.register("potash", () ->
            new Item(new Item.Properties().tab(ModTab.ATOMI_CRAFT)));
    public static final RegistryObject<Item> POTASSIUM_DUST = ITEMS.register("potassium_dust", () ->
            new Item(new Item.Properties().tab(ModTab.ATOMI_CRAFT)));
    public static final RegistryObject<Item> KELP_DUST = ITEMS.register("kelp_dust", () ->
            new Item(new Item.Properties().tab(ModTab.ATOMI_CRAFT)));
    public static final RegistryObject<Item> IODINE_DUST = ITEMS.register("iodine_dust", () ->
            new Item(new Item.Properties().tab(ModTab.ATOMI_CRAFT)));

    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () ->
            new Item(new Item.Properties().tab(ModTab.ATOMI_CRAFT)));
    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", () ->
            new Item(new Item.Properties().tab(ModTab.ATOMI_CRAFT)));
    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead", () ->
            new Item(new Item.Properties().tab(ModTab.ATOMI_CRAFT)));

    public static final RegistryObject<Item> POTASSIUM_IODIDE_PILL = ITEMS.register("potassium_iodide_pill", () ->
            new PotassiumIodinePillItem(new Item.Properties().tab(ModTab.ATOMI_CRAFT).stacksTo(1)));

    public static final RegistryObject<Item> PESTLE_AND_MORTAR = ITEMS.register("pestle_and_mortar", () ->
            new PestleAndMortarItem(new Item.Properties().tab(ModTab.ATOMI_CRAFT).durability(48)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
