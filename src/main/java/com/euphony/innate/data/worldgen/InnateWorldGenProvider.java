package com.euphony.innate.data.worldgen;

import com.euphony.innate.Innate;
import com.euphony.innate.data.worldgen.ore.InnateConfiguredFeatures;
import com.euphony.innate.data.worldgen.ore.InnatePlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class InnateWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public InnateWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, new RegistrySetBuilder()
                        .add(Registries.CONFIGURED_FEATURE, InnateConfiguredFeatures::bootstrap)
                        .add(Registries.PLACED_FEATURE, InnatePlacedFeatures::bootstrap)
                        .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, InnateBiomesModifiers::bootstrap),
                Set.of(Innate.MODID));
    }
}