package com.euphony.innate.block;

import com.euphony.innate.Innate;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InnateBlock {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Innate.MODID);

    public static final Supplier<Block> life_fragment_ore = BLOCKS.register("life_fragment_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE.strength(1f).requiresCorrectToolForDrops(), UniformInt.of(3, 7))));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
