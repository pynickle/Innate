package com.euphony.innate.data;

import com.euphony.innate.Innate;
import com.euphony.innate.data.worldgen.InnateWorldGenProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public class DataGenerators {
    public static void gatherData(GatherDataEvent event) {
        try {
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();
            ExistingFileHelper helper = event.getExistingFileHelper();
            CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

            // generator.addProvider(true, new InnateBlockStateProvider(output, helper));
            // generator.addProvider(true, new InnateItemStateProvider(output, helper));
            // generator.addProvider(true, new InnateLootTable(output, lookUpProvider));

            generator.addProvider(true, new InnateWorldGenProvider(output, lookUpProvider));
            Innate.LOGGER.info("finish");
        } catch (RuntimeException e) {
            Innate.LOGGER.error("Failed to gather data", e);
        }
    }
}