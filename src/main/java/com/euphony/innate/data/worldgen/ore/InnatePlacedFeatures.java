package com.euphony.innate.data.worldgen.ore;

import com.euphony.innate.Innate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class InnatePlacedFeatures {
    public static ResourceKey<PlacedFeature> LIFE_FRAGMENT_ORE = createKey("life_fragment_ore");
    public static ResourceKey<PlacedFeature> NETHER_LIFE_FRAGMENT_ORE = createKey("nether_life_fragment_ore");
    public static ResourceKey<PlacedFeature> END_LIFE_FRAGMENT_ORE = createKey("end_life_fragment_ore");
    public static ResourceKey<PlacedFeature> DEEPSLATE_LIFE_FRAGMENT_ORE = createKey("deepslate_life_fragment_ore");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> holder =
                configuredFeatures.getOrThrow(InnateConfiguredFeatures.LIFE_FRAGMENT_ORE);

        register(context, LIFE_FRAGMENT_ORE, holder, InnateOrePlacement.commonOrePlacements(10,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(50))));
        register(context, DEEPSLATE_LIFE_FRAGMENT_ORE, holder, InnateOrePlacement.commonOrePlacements(10,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0))));
        register(context, NETHER_LIFE_FRAGMENT_ORE, holder, InnateOrePlacement.commonOrePlacements(10,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(50))));
        register(context, END_LIFE_FRAGMENT_ORE, holder, InnateOrePlacement.commonOrePlacements(10,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(50))));
    }


    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Innate.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placementModifiers) {
        context.register(key, new PlacedFeature(feature, placementModifiers));
    }
}
