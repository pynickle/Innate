package com.euphony.innate.data.texture;

import com.euphony.innate.Innate;
import com.euphony.innate.block.InnateBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class InnateBlockStateProvider extends BlockStateProvider {
    public InnateBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Innate.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        normalBlock(InnateBlock.LIFE_FRAGMENT_ORE.get());
    }

    private void normalBlock(Block block) {
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();
        simpleBlock(block, models().cubeAll(path, modLoc("block/" + path)));
        simpleBlockItem(block, models().getExistingFile(modLoc("block/" + path)));
    }
}