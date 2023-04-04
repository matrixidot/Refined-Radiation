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

public class OutputConfigurationCardItem extends Item {
    public OutputConfigurationCardItem(Properties pProperties) {
        super(pProperties);
    }

    public static boolean red = true;
    public static boolean orange = false;
    public static boolean yellow = true;
    public static boolean pink = true;

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if (red) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".red.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".red.false"));
        }
        if (orange) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".orange.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".orange.false"));
        }
        if (yellow) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".yellow.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".yellow.false"));
        }
        if (pink) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".pink.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".pink.false"));
        }

        super.appendHoverText(stack, level, components, flag);
    }
}
