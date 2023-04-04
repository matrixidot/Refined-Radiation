package me.neo.refinedradiation.custom.item;

import me.neo.refinedradiation.RefinedRadiation;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class InputConfigurationCardItem extends Item {
    public InputConfigurationCardItem(Properties pProperties) {
        super(pProperties);
    }

    public static boolean lightblue = true;
    public static boolean cyan = false;
    public static boolean blue = true;
    public static boolean purple = false;

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if (lightblue) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".lightblue.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".lightblue.false"));
        }
        if (cyan) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".cyan.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".cyan.false"));
        }
        if (blue) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".blue.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".blue.false"));
        }
        if (purple) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".purple.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".purple.false"));
        }
        super.appendHoverText(stack, level, components, flag);
    }
}
