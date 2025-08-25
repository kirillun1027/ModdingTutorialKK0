package net.kirillun1027.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kirillun1027.tutorialmod.block.ModBlocks;
import net.kirillun1027.tutorialmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PINK_GEM_BLOCK)
                .add(ModBlocks.RAW_GEMSTONE_BLOCK)
                .add(ModBlocks.GEMSTONE_ORE)
                .add(ModBlocks.GEMSTONE_DEEPSLATE_ORE)
                .add(ModBlocks.MAGIC_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAW_GEMSTONE_BLOCK)
                .add(ModBlocks.PINK_GEM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.GEMSTONE_DEEPSLATE_ORE)
                .add(ModBlocks.GEMSTONE_ORE);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.PINK_GEM_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.RAW_GEMSTONE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.PINK_GEM_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.RAW_GEMSTONE_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.PINK_GEM_WALL);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.RAW_GEMSTONE_WALL);

        getOrCreateTagBuilder(BlockTags.DOORS).add(ModBlocks.PINK_GEM_DOOR);
        getOrCreateTagBuilder(BlockTags.DOORS).add(ModBlocks.RAW_GEMSTONE_DOOR);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS).add(ModBlocks.PINK_GEM_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS).add(ModBlocks.RAW_GEMSTONE_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.STAIRS).add(ModBlocks.PINK_GEM_STAIRS);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(ModBlocks.RAW_GEMSTONE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS).add(ModBlocks.PINK_GEM_SLAB);
        getOrCreateTagBuilder(BlockTags.SLABS).add(ModBlocks.RAW_GEMSTONE_SLAB);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.MAGIC_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_PINK_GEM_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MAGIC_BLOCK);


    }
}
