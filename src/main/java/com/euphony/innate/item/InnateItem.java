package com.euphony.innate.item;

import com.euphony.innate.Innate;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class InnateItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Innate.MODID);

    public static final Supplier<Item> life_fragment = ITEMS.register("life_fragment", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
