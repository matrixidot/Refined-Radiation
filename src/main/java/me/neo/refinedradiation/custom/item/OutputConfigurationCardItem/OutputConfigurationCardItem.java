package me.neo.refinedradiation.custom.item.OutputConfigurationCardItem;

import me.neo.refinedradiation.RefinedRadiation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class OutputConfigurationCardItem extends Item {
    public OutputConfigurationCardItem(Properties pProperties) {
        super(pProperties);
    }

    public static boolean getData(ItemStack stack, String color) {
        if(stack.hasTag()) {
            return stack.getTagElement("data").getByte(color) != 0;
        } else return false;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

        if (!pStack.hasTag()) {
            pStack.addTagElement("data", new CompoundTag());

            pStack.getTagElement("data").putByte("red", (byte) 0);
            pStack.getTagElement("data").putByte("orange", (byte) 0);
            pStack.getTagElement("data").putByte("yellow", (byte) 0);
            pStack.getTagElement("data").putByte("pink", (byte) 0);
        }

        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if (OutputConfigurationCardItem.getData(stack, "red")) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".red.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".red.false"));
        }
        if (OutputConfigurationCardItem.getData(stack, "orange")) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".orange.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".orange.false"));
        }
        if (OutputConfigurationCardItem.getData(stack, "yellow")) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".yellow.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".yellow.false"));
        }
        if (OutputConfigurationCardItem.getData(stack, "pink")) {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".pink.true"));
        } else {
            components.add(Component.translatable(RefinedRadiation.MOD_ID+".pink.false"));
        }

        super.appendHoverText(stack, level, components, flag);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getLevel().isClientSide) {
            if (pContext.getItemInHand().getTagElement("data").getByte("red") == 0) {
                pContext.getItemInHand().getTagElement("data").putByte("red", (byte) 1);
            } else {
                pContext.getItemInHand().getTagElement("data").putByte("red", (byte) 0);
            }
            System.out.println(pContext.getItemInHand().getTagElement("data").getByte("red") != 0);
        }
        return super.useOn(pContext);
    }
}
