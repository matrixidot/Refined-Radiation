package me.neo.refinedradiation.networking.packet;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class EnergySyncS2C {
    private final int energy;
    private final BlockPos pos;

    public EnergySyncS2C(int energy, BlockPos pos) {
        this.energy = energy;
        this.pos = pos;
    }

    public EnergySyncS2C(FriendlyByteBuf buf) {
        this.energy = buf.readInt();
        this.pos = buf.readBlockPos();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(energy);
        buf.writeBlockPos(pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
        });
        return true;
    }

/*
 * if (Minecraft.getInstance.level.getBlockEntity(pos) isntanceof BlockEntity entity) {
 *      entity.setEnergyLevel(energy);
 *
 *      if (Minecraft.getInstance().player.containerMenu instanceof BlockEntityMenu menu && menu.getBlockEntity.getBlockpos.equals(pos)) {
 *          blockEntity.setEnergyLevel(energy);
 *      }
 * }
 */
}
