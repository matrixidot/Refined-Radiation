package me.neo.atomicraft.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTab {
    public static final CreativeModeTab ATOMI_CRAFT = new CreativeModeTab("actab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.POTASSIUM_IODIDE_PILL.get());
        }
    };
}
