package net.kirillun1027.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kirillun1027.tutorialmod.TutorialMod;
import net.kirillun1027.tutorialmod.item.custom.ChiselItem;
import net.kirillun1027.tutorialmod.item.custom.ReverserItem;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item PINK_GEM = registerItem("pink_gem", new Item(new Item.Settings()));
    public static final Item RAW_GEMSTONE = registerItem("raw_gemstone", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));
    public static final Item REVERSER = registerItem("reverser", new ReverserItem(new Item.Settings().maxDamage(32)));
    public static final Item MORTAR_AND_PESTLE = registerItem("mortar_and_pestle", new Item(new Item.Settings().maxDamage(32)));



    public static final Item FRIED_EGG = registerItem("fried_egg", new Item(new Item.Settings().food(ModFoodComponents.FRIED_EGG)));
    public static final Item FRIED_EGGS = registerItem("fried_eggs", new Item(new Item.Settings().food(ModFoodComponents.FRIED_EGGS)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.fried_eggs.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item BIOFUEL_POWDER = registerItem("biofuel_powder", new Item(new Item.Settings()));

    public static final Item PINK_GEM_SWORD = registerItem("pink_gem_sword",
            new SwordItem(ModToolMaterials.PINK_GEM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.PINK_GEM, 3, -2.4f))));
    public static final Item PINK_GEM_AXE = registerItem("pink_gem_axe",
            new AxeItem(ModToolMaterials.PINK_GEM, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.PINK_GEM, 6, -3.2f))));
    public static final Item PINK_GEM_PICKAXE = registerItem("pink_gem_pickaxe",
            new PickaxeItem(ModToolMaterials.PINK_GEM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.PINK_GEM, 1, -2.0f))));
    public static final Item PINK_GEM_SHOVEL = registerItem("pink_gem_shovel",
            new ShovelItem(ModToolMaterials.PINK_GEM, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.PINK_GEM, 1.5f, -3.0f))));
    public static final Item PINK_GEM_HOE = registerItem("pink_gem_hoe",
            new HoeItem(ModToolMaterials.PINK_GEM, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.PINK_GEM, 0, -3f))));



    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering mod items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GEM);
            entries.add(RAW_GEMSTONE);
        });
    }




}
