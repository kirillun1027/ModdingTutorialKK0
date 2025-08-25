package net.kirillun1027.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kirillun1027.tutorialmod.TutorialMod;
import net.kirillun1027.tutorialmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup GEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "gems"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GEM))
                    .displayName(Text.translatable("itemgroup.tutorialmod.gems"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PINK_GEM);
                        entries.add(ModItems.RAW_GEMSTONE);

                        entries.add(ModItems.CHISEL);
                    })
                    .build());

    public static final ItemGroup GEM_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "gem_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GEM_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.gem_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_GEM_BLOCK);
                        entries.add(ModBlocks.RAW_GEMSTONE_BLOCK);

                        entries.add(ModBlocks.GEMSTONE_ORE);
                        entries.add(ModBlocks.GEMSTONE_DEEPSLATE_ORE);

                        entries.add(ModBlocks.MAGIC_BLOCK);

                        entries.add(ModBlocks.PINK_GEM_STAIRS);
                        entries.add(ModBlocks.PINK_GEM_SLAB);

                        entries.add(ModBlocks.PINK_GEM_FENCE);
                        entries.add(ModBlocks.PINK_GEM_FENCE_GATE);
                        entries.add(ModBlocks.PINK_GEM_WALL);

                        entries.add(ModBlocks.PINK_GEM_BUTTON);
                        entries.add(ModBlocks.PINK_GEM_PRESSURE_PLATE);

                        entries.add(ModBlocks.PINK_GEM_TRAPDOOR);
                        entries.add(ModBlocks.PINK_GEM_DOOR);

                        entries.add(ModBlocks.RAW_GEMSTONE_STAIRS);
                        entries.add(ModBlocks.RAW_GEMSTONE_SLAB);

                        entries.add(ModBlocks.RAW_GEMSTONE_FENCE);
                        entries.add(ModBlocks.RAW_GEMSTONE_FENCE_GATE);
                        entries.add(ModBlocks.RAW_GEMSTONE_WALL);

                        entries.add(ModBlocks.RAW_GEMSTONE_BUTTON);
                        entries.add(ModBlocks.RAW_GEMSTONE_PRESSURE_PLATE);

                        entries.add(ModBlocks.RAW_GEMSTONE_TRAPDOOR);
                        entries.add(ModBlocks.RAW_GEMSTONE_DOOR);

                        entries.add(ModBlocks.PINK_GEM_LAMP);


                    })
                    .build());

    public static final ItemGroup MISC = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "misc"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.FRIED_EGG))
                    .displayName(Text.translatable("itemgroup.tutorialmod.misc"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.FRIED_EGG);
                        entries.add(ModItems.FRIED_EGGS);

                        entries.add(ModItems.BIOFUEL_POWDER);

                        entries.add(ModItems.PINK_GEM_SHOVEL);
                        entries.add(ModItems.PINK_GEM_SWORD);
                        entries.add(ModItems.PINK_GEM_AXE);
                        entries.add(ModItems.PINK_GEM_PICKAXE);
                        entries.add(ModItems.PINK_GEM_HOE);

                    })
                    .build());

    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
