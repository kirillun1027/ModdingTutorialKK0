package net.kirillun1027.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kirillun1027.tutorialmod.TutorialMod;
import net.kirillun1027.tutorialmod.block.custom.MagicBlock;
import net.kirillun1027.tutorialmod.block.custom.PinkGemLamp;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block PINK_GEM_BLOCK = registerBlock("pink_gem_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_GEMSTONE_BLOCK = registerBlock("raw_gemstone_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block GEMSTONE_ORE = registerBlock("gemstone_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
                        .sounds(BlockSoundGroup.STONE)));

    public static final Block GEMSTONE_DEEPSLATE_ORE = registerBlock("gemstone_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,6),
                    AbstractBlock.Settings.create()
                            .strength(3f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(2f).sounds(BlockSoundGroup.STONE)));


    public static final Block RAW_GEMSTONE_STAIRS = registerBlock("raw_gemstone_stairs",
            new StairsBlock(ModBlocks.RAW_GEMSTONE_BLOCK.getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f).requiresTool()));

    public static final Block PINK_GEM_STAIRS = registerBlock("pink_gem_stairs",
            new StairsBlock(ModBlocks.PINK_GEM_BLOCK.getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f).requiresTool()));

    public static final Block RAW_GEMSTONE_SLAB = registerBlock("raw_gemstone_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PINK_GEM_SLAB = registerBlock("pink_gem_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block RAW_GEMSTONE_BUTTON = registerBlock("raw_gemstone_button",
            new ButtonBlock(BlockSetType.IRON, 3, AbstractBlock.Settings.create()
                    .strength(2f).requiresTool().noCollision()));

    public static final Block PINK_GEM_BUTTON = registerBlock("pink_gem_button",
            new ButtonBlock(BlockSetType.IRON, 3, AbstractBlock.Settings.create()
                    .strength(2f).requiresTool().noCollision()));

    public static final Block RAW_GEMSTONE_PRESSURE_PLATE = registerBlock("raw_gemstone_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .strength(2f).requiresTool()));

    public static final Block PINK_GEM_PRESSURE_PLATE = registerBlock("pink_gem_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .strength(2f).requiresTool()));

    public static final Block RAW_GEMSTONE_FENCE = registerBlock("raw_gemstone_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PINK_GEM_FENCE = registerBlock("pink_gem_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block RAW_GEMSTONE_FENCE_GATE = registerBlock("raw_gemstone_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block PINK_GEM_FENCE_GATE = registerBlock("pink_gem_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block RAW_GEMSTONE_WALL = registerBlock("raw_gemstone_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PINK_GEM_WALL = registerBlock("pink_gem_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block RAW_GEMSTONE_DOOR = registerBlock("raw_gemstone_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .strength(2f).requiresTool().nonOpaque()));

    public static final Block PINK_GEM_DOOR = registerBlock("pink_gem_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .strength(2f).requiresTool().nonOpaque()));

    public static final Block RAW_GEMSTONE_TRAPDOOR = registerBlock("raw_gemstone_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .strength(2f).requiresTool().nonOpaque()));

    public static final Block PINK_GEM_TRAPDOOR = registerBlock("pink_gem_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .strength(2f).requiresTool().nonOpaque()));

    public static final Block PINK_GEM_LAMP = registerBlock("pink_gem_lamp",
            new PinkGemLamp(AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.GLASS).requiresTool().luminance(
                    state -> state.get(PinkGemLamp.IS_CLICKED) ? 15 : 0
            )));



    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block)
    {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering mod blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(PINK_GEM_BLOCK);
            entries.add(RAW_GEMSTONE_BLOCK);
        });
    }
}
