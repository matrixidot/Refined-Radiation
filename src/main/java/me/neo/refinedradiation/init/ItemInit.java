package me.neo.refinedradiation.init;

import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.custom.item.HazmatSuitArmorItem;
import me.neo.refinedradiation.custom.item.InputConfigurationCardItem.InputConfigurationCardItem;
import me.neo.refinedradiation.custom.item.OutputConfigurationCardItem.OutputConfigurationCardItem;
import me.neo.refinedradiation.custom.item.PestleAndMortarItem;
import me.neo.refinedradiation.custom.item.PotassiumIodinePillItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RefinedRadiation.MOD_ID);

    public static final RegistryObject<Item> BURNED_POTATO = ITEMS.register("burned_potato", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> POTASH = ITEMS.register("potash", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> POTASSIUM_DUST = ITEMS.register("potassium_dust", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> KELP_DUST = ITEMS.register("kelp_dust", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> IODINE_DUST = ITEMS.register("iodine_dust", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));

    public static final RegistryObject<Item> RUBBER_TREE_BOAT = ITEMS.register("rubber_tree_boat", () ->
            new BoatItem(false, Boat.Type.OAK, (new Item.Properties()).stacksTo(1).tab(ModTab.RR)));
    public static final RegistryObject<Item> RUBBER_TREE_CHEST_BOAT = ITEMS.register("rubber_tree_chest_boat", () ->
            new BoatItem(false, Boat.Type.OAK, (new Item.Properties()).stacksTo(1).tab(ModTab.RR)));

    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> LEAD_DUST = ITEMS.register("lead_dust", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));

    public static final RegistryObject<Item> AURORIUM_INGOT = ITEMS.register("aurorium_ingot", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> AURORIUM_NUGGET = ITEMS.register("aurorium_nugget", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> RAW_AURORIUM = ITEMS.register("raw_aurorium", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> AURORIUM_DUST = ITEMS.register("aurorium_dust", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> RAW_AURORIUM_DUST = ITEMS.register("raw_aurorium_dust", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));


    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> STEEL_DUST = ITEMS.register("steel_dust", () ->
            new Item(new Item.Properties().tab(ModTab.RR)));


    public static final RegistryObject<Item> INPUT_CONFIGURATION_CARD = ITEMS.register("input_configuration_card", () ->
            new InputConfigurationCardItem(new Item.Properties().tab(ModTab.RR).stacksTo(1)));
    public static final RegistryObject<Item> OUTPUT_CONFIGURATION_CARD = ITEMS.register("output_configuration_card", () ->
            new OutputConfigurationCardItem(new Item.Properties().tab(ModTab.RR).stacksTo(1)));

    public static final RegistryObject<Item> POTASSIUM_IODIDE_PILL = ITEMS.register("potassium_iodide_pill", () ->
            new PotassiumIodinePillItem(new Item.Properties().tab(ModTab.RR).stacksTo(1)));

    public static final RegistryObject<Item> PESTLE_AND_MORTAR = ITEMS.register("pestle_and_mortar", () ->
            new PestleAndMortarItem(new Item.Properties().tab(ModTab.RR).durability(48)));

    public static final RegistryObject<Item> HAZMAT_SUIT_HELMET = ITEMS.register("hazmat_suit_helmet",
            () -> new HazmatSuitArmorItem(ArmorMaterialInit.HAZMAT_SUIT, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> HAZMAT_SUIT_CHESTPLATE = ITEMS.register("hazmat_suit_chestplate",
            () -> new HazmatSuitArmorItem(ArmorMaterialInit.HAZMAT_SUIT, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> HAZMAT_SUIT_LEGGING = ITEMS.register("hazmat_suit_leggings",
            () -> new HazmatSuitArmorItem(ArmorMaterialInit.HAZMAT_SUIT, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModTab.RR)));
    public static final RegistryObject<Item> HAZMAT_SUIT_BOOTS = ITEMS.register("hazmat_suit_boots",
            () -> new HazmatSuitArmorItem(ArmorMaterialInit.HAZMAT_SUIT, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModTab.RR)));

    public static final RegistryObject<Item> RUBBER_TREE_SIGN = ITEMS.register("rubber_tree_sign", () ->
            new SignItem(new Item.Properties().tab(ModTab.RR).stacksTo(16), BlockInit.RUBBER_TREE_STANDING_SIGN.get(),
                    BlockInit.RUBBER_TREE_WALL_SIGN.get()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
