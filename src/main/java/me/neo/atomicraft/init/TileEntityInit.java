package me.neo.atomicraft.init;
import me.neo.atomicraft.AtomiCraft;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AtomiCraft.MOD_ID);






    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
