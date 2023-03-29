package me.neo.atomicraft.custom.item;

import me.neo.atomicraft.init.EffectInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class PotassiumIodinePillItem extends Item {
    private static final int DRINK_DURATION = 32;
    public PotassiumIodinePillItem(Properties pProperties) {
        super(pProperties);
    }
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide) pEntityLiving.curePotionEffects(pStack);// FORGE - move up so stack.shrink does not turn stack into air
        if (pEntityLiving instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, pStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (pEntityLiving instanceof Player && !((Player)pEntityLiving).getAbilities().instabuild) {
            pStack.shrink(1);
        }

        if (pEntityLiving.hasEffect(EffectInit.RADIATION_POISONING.get())) {
            pEntityLiving.removeEffect(EffectInit.RADIATION_POISONING.get());
        }

        return pStack.isEmpty() ? new ItemStack(Items.AIR) : pStack;
    }

    public int getUseDuration(ItemStack pStack) {
        return DRINK_DURATION;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.EAT;
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }

    @Override
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @org.jetbrains.annotations.Nullable net.minecraft.nbt.CompoundTag nbt) {
        return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
    }
}
