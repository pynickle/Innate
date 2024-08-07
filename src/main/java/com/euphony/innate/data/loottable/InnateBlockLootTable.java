package com.euphony.innate.data.loottable;

import com.euphony.innate.Innate;
import com.euphony.innate.block.InnateBlock;
import com.euphony.innate.item.InnateItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class InnateBlockLootTable extends BlockLootSubProvider {
    public InnateBlockLootTable(HolderLookup.Provider p_344943_) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), p_344943_);
    }

    @Override
    protected void generate() {
        add(InnateBlock.LIFE_FRAGMENT_ORE.get(), createOreDrop(InnateBlock.LIFE_FRAGMENT_ORE.get(), InnateItem.LIFE_FRAGMENT.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter(key -> key.getNamespace().equals(Innate.MODID))
                        .isPresent())
                .collect(Collectors.toSet());
    }
}
