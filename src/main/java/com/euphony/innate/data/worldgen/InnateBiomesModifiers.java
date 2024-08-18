package com.euphony.innate.data.worldgen;

import com.euphony.innate.Innate;
import com.euphony.innate.data.worldgen.ore.InnatePlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class InnateBiomesModifiers {
    protected static ResourceKey<BiomeModifier> ADD_LIFE_FRAGMENT_ORE = createKey("add_life_fragment_ore");
    protected static ResourceKey<BiomeModifier> ADD_DEEPSLATE_LIFE_FRAGMENT_ORE = createKey("add_deepslate_life_fragment_ore");
    protected static ResourceKey<BiomeModifier> ADD_NETHER_LIFE_FRAGMENT_ORE = createKey("add_nether_fragment_ore");
    protected static ResourceKey<BiomeModifier> ADD_END_LIFE_FRAGMENT_ORE = createKey("add_end_fragment_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(
                ADD_LIFE_FRAGMENT_ORE,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeatures.getOrThrow(InnatePlacedFeatures.LIFE_FRAGMENT_ORE)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
        context.register(
                ADD_DEEPSLATE_LIFE_FRAGMENT_ORE,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeatures.getOrThrow(InnatePlacedFeatures.DEEPSLATE_LIFE_FRAGMENT_ORE)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
        context.register(
                ADD_NETHER_LIFE_FRAGMENT_ORE,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_NETHER),
                        HolderSet.direct(placedFeatures.getOrThrow(InnatePlacedFeatures.NETHER_LIFE_FRAGMENT_ORE)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
        context.register(
                ADD_END_LIFE_FRAGMENT_ORE,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_END),
                        HolderSet.direct(placedFeatures.getOrThrow(InnatePlacedFeatures.END_LIFE_FRAGMENT_ORE)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
    }

    private static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Innate.MODID, name));
    }
}