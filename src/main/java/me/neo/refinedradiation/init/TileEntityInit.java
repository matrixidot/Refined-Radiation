package me.neo.refinedradiation.init;
import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.block.test.TestTile;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TileEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RefinedRadiation.MOD_ID);

    public static final RegistryObject<BlockEntityType<TestTile>> TEST = TILE_ENTITIES.register("test",
            () -> BlockEntityType.Builder.of(TestTile::new, BlockInit.TEST.get()).build(null));




    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
