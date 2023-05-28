package me.neo.refinedradiation.init;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ConfiguredFeatureInit {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>>
            RUBBER_TREE = FeatureUtils.register("rubber_tree", Feature.TREE,
            (new TreeConfiguration.TreeConfigurationBuilder
                    (BlockStateProvider.simple(BlockInit.RUBBER_TREE_LOG.get()),
                            new ForkingTrunkPlacer(5, 2, 2),
                            BlockStateProvider.simple(BlockInit.RUBBER_TREE_LEAVES.get()),
                            new AcaciaFoliagePlacer(ConstantInt.of(2),
                                    ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)
                    )).ignoreVines().build());

    public static final Holder<PlacedFeature> RUBBER_TREE_CHECKED = PlacementUtils.register(
            "rubber_tree_checked", RUBBER_TREE, PlacementUtils.filteredByBlockSurvival(BlockInit.RUBBER_TREE_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_RUBBER = FeatureUtils.register(
            "trees_rubber", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(RUBBER_TREE_CHECKED, 0.8F)), RUBBER_TREE_CHECKED));
}
