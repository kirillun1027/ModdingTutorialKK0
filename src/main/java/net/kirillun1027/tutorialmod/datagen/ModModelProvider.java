package net.kirillun1027.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kirillun1027.tutorialmod.block.ModBlocks;
import net.kirillun1027.tutorialmod.block.custom.PinkGemLamp;
import net.kirillun1027.tutorialmod.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool pink_garnet_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_GEM_BLOCK);
        BlockStateModelGenerator.BlockTexturePool raw_gemstone_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RAW_GEMSTONE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GEMSTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GEMSTONE_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        pink_garnet_pool.stairs(ModBlocks.PINK_GEM_STAIRS);
        pink_garnet_pool.slab(ModBlocks.PINK_GEM_SLAB);

        pink_garnet_pool.fence(ModBlocks.PINK_GEM_FENCE);
        pink_garnet_pool.fenceGate(ModBlocks.PINK_GEM_FENCE_GATE);
        pink_garnet_pool.wall(ModBlocks.PINK_GEM_WALL);

        pink_garnet_pool.button(ModBlocks.PINK_GEM_BUTTON);
        pink_garnet_pool.pressurePlate(ModBlocks.PINK_GEM_PRESSURE_PLATE);

        raw_gemstone_pool.stairs(ModBlocks.RAW_GEMSTONE_STAIRS);
        raw_gemstone_pool.slab(ModBlocks.RAW_GEMSTONE_SLAB);

        raw_gemstone_pool.fence(ModBlocks.RAW_GEMSTONE_FENCE);
        raw_gemstone_pool.fenceGate(ModBlocks.RAW_GEMSTONE_FENCE_GATE);
        raw_gemstone_pool.wall(ModBlocks.RAW_GEMSTONE_WALL);

        raw_gemstone_pool.button(ModBlocks.RAW_GEMSTONE_BUTTON);
        raw_gemstone_pool.pressurePlate(ModBlocks.RAW_GEMSTONE_PRESSURE_PLATE);

        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GEM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PINK_GEM_TRAPDOOR);
        
        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.PINK_GEM_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.PINK_GEM_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.PINK_GEM_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(PinkGemLamp.IS_CLICKED, lampOnIdentifier, lampOffIdentifier)));

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_GEMSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIOFUEL_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRIED_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRIED_EGGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.REVERSER, Models.GENERATED);

        itemModelGenerator.register(ModItems.PINK_GEM_SWORD,Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GEM_AXE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GEM_PICKAXE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GEM_SHOVEL,Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GEM_HOE,Models.HANDHELD);
    }
}
