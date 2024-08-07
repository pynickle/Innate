package com.euphony.innate.data;

import com.euphony.innate.Innate;
import com.euphony.innate.data.loottable.InnateLootTable;
import com.euphony.innate.data.texture.InnateBlockStateProvider;
import com.euphony.innate.data.texture.InnateItemStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {
    public static void gatherData(GatherDataEvent event) {
        try {
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();
            ExistingFileHelper helper = event.getExistingFileHelper();

            generator.addProvider(true, new InnateBlockStateProvider(output, helper));
            generator.addProvider(true, new InnateItemStateProvider(output, helper));
            generator.addProvider(true, new InnateLootTable(output, event.getLookupProvider()));
            Innate.LOGGER.info("finish");
        } catch (RuntimeException e) {
            Innate.LOGGER.error("Failed to gather data", e);
        }
    }
}