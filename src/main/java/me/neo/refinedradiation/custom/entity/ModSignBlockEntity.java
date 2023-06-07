package me.neo.refinedradiation.custom.entity;

import me.neo.refinedradiation.init.TileEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModSignBlockEntity extends SignBlockEntity {
    public ModSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState);
    }
    @Override
    public BlockEntityType<?> getType() {
        return TileEntityInit.SIGN_BLOCK_ENTITIES.get();
    }
}
