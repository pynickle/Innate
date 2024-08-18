package com.euphony.innate.data.worldgen.ore;

import com.euphony.innate.Innate;
import com.euphony.innate.block.InnateBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class InnateConfiguredFeatures {
    protected static ResourceKey<ConfiguredFeature<?, ?>> LIFE_FRAGMENT_ORE = createKey("life_fragment_ore");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest endStoneReplacableable = new BlockMatchTest(Blocks.END_STONE);
        RuleTest netherrackReplaceable = new BlockMatchTest(Blocks.NETHERRACK);

        List<OreConfiguration.TargetBlockState> lifeFragmentOre =
                List.of(OreConfiguration.target(stoneReplaceable, InnateBlock.LIFE_FRAGMENT_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceable, InnateBlock.DEEPSLATE_LIFE_FRAGMENT_BLOCK.get().defaultBlockState()),
                        OreConfiguration.target(endStoneReplacableable, InnateBlock.END_LIFE_FRAGMENT_BLOCK.get().defaultBlockState()),
                        OreConfiguration.target(netherrackReplaceable, InnateBlock.NETHER_LIFE_FRAGMENT_BLOCK.get().defaultBlockState()));

        register(context, LIFE_FRAGMENT_ORE, Feature.ORE, new OreConfiguration(lifeFragmentOre, 6));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Innate.MODID, name));
    }

    private static  <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?,?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
