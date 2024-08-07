package com.euphony.innate.data.texture;

import com.euphony.innate.Innate;
import com.euphony.innate.item.InnateItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class InnateItemStateProvider extends ItemModelProvider{
    public InnateItemStateProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, Innate.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        item(InnateItem.LIFE_FRAGMENT.get());
    }

    private void item(Item item) {
        String name = getItemName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/" + name);
    }

    private @NotNull String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(Innate.MODID + ":", "");
    }
}
