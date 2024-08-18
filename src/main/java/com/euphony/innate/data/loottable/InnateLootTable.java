package com.euphony.innate.data.loottable;

import com.euphony.innate.Innate;
import com.google.common.collect.Sets;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class InnateLootTable extends LootTableProvider {
    public InnateLootTable(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, Set.of(), List.of(new SubProviderEntry(InnateBlockLootTable::new, LootContextParamSets.BLOCK)), pRegistries);
    }

    @Override
    protected void validate(WritableRegistry<LootTable> writableRegistry, @NotNull ValidationContext validationContext, ProblemReporter.@NotNull Collector problemReporter$collecter) {
        var innateLootTableId = BuiltInLootTables.all()
                .stream()
                .filter(id -> id.registry().getNamespace().equals(Innate.MODID))
                .collect(Collectors.toSet());
        for (var id : Sets.difference(innateLootTableId, writableRegistry.keySet())) {
            validationContext.reportProblem("Missing built-in tables: " + id);
        }

        writableRegistry.forEach(lootTable -> lootTable.validate(validationContext));
    }
}
