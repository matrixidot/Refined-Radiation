package me.neo.refinedradiation.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTab {
    public static final CreativeModeTab RR = new CreativeModeTab("rrtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.POTASSIUM_IODIDE_PILL.get());
        }
    };
}
