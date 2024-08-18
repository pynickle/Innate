package com.euphony.innate.block;

import com.euphony.innate.Innate;
import com.euphony.innate.item.InnateItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class InnateBlock {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Innate.MODID);

    public static final Supplier<Block> LIFE_FRAGMENT_ORE = registerBlock("life_fragment_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                            .strength(0.5f, 1.0f)
                            .requiresCorrectToolForDrops()));

    public static final Supplier<Block> NETHER_LIFE_FRAGMENT_BLOCK = registerBlock("nether_life_fragment_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                    .strength(0.3f, 0.8f)
                    .requiresCorrectToolForDrops()));

    public static final Supplier<Block> END_LIFE_FRAGMENT_BLOCK = registerBlock("end_life_fragment_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                    .strength(0.8f, 1.3f)
                    .requiresCorrectToolForDrops()));

    public static final Supplier<Block> DEEPSLATE_LIFE_FRAGMENT_BLOCK = registerBlock("deepslate_life_fragment_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                    .strength(0.8f, 1.3f)
                    .requiresCorrectToolForDrops()));

    private static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        Supplier<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> Supplier<Item> registerBlockItem(String name, Supplier<T> block) {
        return InnateItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
