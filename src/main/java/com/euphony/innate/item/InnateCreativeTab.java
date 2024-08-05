package com.euphony.innate.item;

import com.euphony.innate.Innate;
import com.euphony.innate.block.InnateBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class InnateCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Innate.MODID);

    public static final Supplier<CreativeModeTab> INNATE_TAB = CREATIVE_MODE_TABS.register("innate_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(InnateItem.LIFE_FRAGMENT.get()))
                    .title(Component.translatable(("creativetab.innate_tab")))
                    .displayItems(((pPara, pOutput) -> {
                       pOutput.accept(InnateItem.LIFE_FRAGMENT.get());
                       pOutput.accept(InnateBlock.LIFE_FRAGMENT_ORE.get());
                    }))
                    .build());

    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TABS.register(eventbus);
    }
}
