package net.kirillun1027.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kirillun1027.tutorialmod.TutorialMod;
import net.kirillun1027.tutorialmod.block.ModBlocks;
import net.kirillun1027.tutorialmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(
                ModBlocks.GEMSTONE_ORE,
                ModBlocks.GEMSTONE_DEEPSLATE_ORE,
                ModItems.RAW_GEMSTONE
        );

        offerSmelting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GEM, 0.2f, 200, "pink_gem_from_smelting_raw_gemstone");
        offerSmelting(exporter, List.of(ModBlocks.RAW_GEMSTONE_BLOCK), RecipeCategory.MISC, ModBlocks.PINK_GEM_BLOCK, 1.8f, 1600, "pink_gem_block_from_smelting_raw_gemstone_block");
        offerSmelting(exporter, List.of(Items.EGG), RecipeCategory.MISC, ModItems.FRIED_EGG, 0.2f, 200, "fried_egg_from_smelting_egg");

        offerBlasting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GEM, 0.2f, 100, "pink_gem_from_blasting_raw_gemstone");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GEM, RecipeCategory.DECORATIONS, ModBlocks.PINK_GEM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_GEMSTONE, RecipeCategory.DECORATIONS, ModBlocks.RAW_GEMSTONE_BLOCK);

        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GEM_SLAB, ModBlocks.PINK_GEM_BLOCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_GEMSTONE_SLAB, ModBlocks.RAW_GEMSTONE_BLOCK);

        offerStairsRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GEM_STAIRS, ModBlocks.PINK_GEM_BLOCK);
        offerStairsRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_GEMSTONE_STAIRS, ModBlocks.RAW_GEMSTONE_BLOCK);

        offerDoorRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GEM_DOOR, ModItems.PINK_GEM);
        offerDoorRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_GEMSTONE_DOOR, ModItems.RAW_GEMSTONE);

        offerTrapdoorRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GEM_TRAPDOOR, ModItems.PINK_GEM);
        offerTrapdoorRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_GEMSTONE_TRAPDOOR, ModItems.RAW_GEMSTONE);

        offerButtonRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GEM_BUTTON, ModItems.PINK_GEM);
        offerButtonRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_GEMSTONE_BUTTON, ModItems.RAW_GEMSTONE);



        offerSwordRecipe(exporter, RecipeCategory.COMBAT, ModItems.PINK_GEM_SWORD, ModItems.PINK_GEM, Items.STICK);
        offerAxeRecipe(exporter, RecipeCategory.COMBAT, ModItems.PINK_GEM_AXE, ModItems.PINK_GEM, Items.STICK);
        offerPickaxeRecipe(exporter, RecipeCategory.COMBAT, ModItems.PINK_GEM_PICKAXE, ModItems.PINK_GEM, Items.STICK);
        offerShovelRecipe(exporter, RecipeCategory.COMBAT, ModItems.PINK_GEM_SHOVEL, ModItems.PINK_GEM, Items.STICK);
        offerHoeRecipe(exporter, RecipeCategory.COMBAT, ModItems.PINK_GEM_HOE, ModItems.PINK_GEM, Items.STICK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PINK_GEM_HAMMER)
                .pattern("MMM")
                .pattern("MSM")
                .pattern(" S ")
                .input('M', ModBlocks.PINK_GEM_BLOCK)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PINK_GEM), conditionsFromItem(ModItems.PINK_GEM))
                .offerTo(exporter, "pink_gem_hammer");


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHISEL)
                .pattern("  M")
                .pattern(" S ")
                .pattern("S  ")
                .input('M', Items.IRON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, "chisel");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.REVERSER)
                .input(ModItems.PINK_GEM)
                .input(ModItems.MORTAR_AND_PESTLE)
                .input(ModItems.CHISEL)
                .criterion(hasItem(ModItems.PINK_GEM), conditionsFromItem(ModItems.PINK_GEM))
                .offerTo(exporter, "reverser");



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK)
                .pattern("OGO")
                .pattern("GEG")
                .pattern("OGO")
                .input('O', Blocks.OBSIDIAN)
                .input('G', ModBlocks.PINK_GEM_BLOCK)
                .input('E', Items.EMERALD)
                .criterion(hasItem(ModBlocks.PINK_GEM_BLOCK), conditionsFromItem(ModBlocks.PINK_GEM_BLOCK))
                .offerTo(exporter, "magic_block");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GEM_LAMP)
                .pattern("GGG")
                .pattern("GLG")
                .pattern("GGG")
                .input('L', Blocks.REDSTONE_LAMP)
                .input('G', ModItems.PINK_GEM)
                .criterion(hasItem(ModItems.PINK_GEM), conditionsFromItem(ModItems.PINK_GEM))
                .offerTo(exporter, "pink_gem_lamp");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FRIED_EGGS)
                .input(ModItems.FRIED_EGG)
                .input(ModItems.FRIED_EGG)
                .input(ModItems.FRIED_EGG)
                .input(ModItems.FRIED_EGG)
                .criterion(hasItem(ModItems.FRIED_EGG), conditionsFromItem(ModItems.FRIED_EGG))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "fried_eggs"));








    }
    private static void offerButtonRecipe(RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible input){
        ShapelessRecipeJsonBuilder.create(recipeCategory, output)
                .input(input)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    private static void offerStairsRecipe(RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible input){
        ShapedRecipeJsonBuilder.create(recipeCategory, output)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', input)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    private static void offerDoorRecipe(RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible input){
        ShapedRecipeJsonBuilder.create(recipeCategory, output)
                .pattern("## ")
                .pattern("## ")
                .pattern("## ")
                .input('#', input)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    private static void offerTrapdoorRecipe(RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible input){
        ShapedRecipeJsonBuilder.create(recipeCategory, output)
                .pattern("   ")
                .pattern("###")
                .pattern("###")
                .input('#', input)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    private static void offerSwordRecipe(RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible inputMetal, ItemConvertible inputStick){
        ShapedRecipeJsonBuilder.create(recipeCategory, output)
                .pattern(" M ")
                .pattern(" M ")
                .pattern(" S ")
                .input('M', inputMetal)
                .input('S', inputStick)
                .criterion(hasItem(inputMetal), conditionsFromItem(inputMetal))
                .offerTo(exporter);
    }

    private static void offerAxeRecipe(RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible inputMetal, ItemConvertible inputStick){
        ShapedRecipeJsonBuilder.create(recipeCategory, output)
                .pattern("MM ")
                .pattern("MS ")
                .pattern(" S ")
                .input('M', inputMetal)
                .input('S', inputStick)
                .criterion(hasItem(inputMetal), conditionsFromItem(inputMetal))
                .offerTo(exporter);
    }

    private static void offerPickaxeRecipe(RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible inputMetal, ItemConvertible inputStick){
        ShapedRecipeJsonBuilder.create(recipeCategory, output)
                .pattern("MMM")
                .pattern(" S ")
                .pattern(" S ")
                .input('M', inputMetal)
                .input('S', inputStick)
                .criterion(hasItem(inputMetal), conditionsFromItem(inputMetal))
                .offerTo(exporter);
    }

    private static void offerShovelRecipe(RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible inputMetal, ItemConvertible inputStick){
        ShapedRecipeJsonBuilder.create(recipeCategory, output)
                .pattern(" M ")
                .pattern(" S ")
                .pattern(" S ")
                .input('M', inputMetal)
                .input('S', inputStick)
                .criterion(hasItem(inputMetal), conditionsFromItem(inputMetal))
                .offerTo(exporter);
    }

    private static void offerHoeRecipe(RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible inputMetal, ItemConvertible inputStick){
        ShapedRecipeJsonBuilder.create(recipeCategory, output)
                .pattern("MM ")
                .pattern(" S ")
                .pattern(" S ")
                .input('M', inputMetal)
                .input('S', inputStick)
                .criterion(hasItem(inputMetal), conditionsFromItem(inputMetal))
                .offerTo(exporter);
    }



}
