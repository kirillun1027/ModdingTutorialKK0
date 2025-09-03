package net.kirillun1027.tutorialmod.item;

import net.kirillun1027.tutorialmod.TutorialMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.*;
import java.util.function.Supplier;

public class ModArmorMaterials extends ArmorMaterials {

    public enum ArmorStats{
        ENCHANTABILITY, TOUGHNESS, KNOCKBACK_RESISTANCE, BOOTS, LEGGINGS, CHESTPLATE, HELMET, BODY
    }

    public static final Map<ArmorStats, Integer> PINK_GEM_DATA = Map.of(
            ArmorStats.ENCHANTABILITY, 20,
            ArmorStats.TOUGHNESS, 0,
            ArmorStats.KNOCKBACK_RESISTANCE, 0,
            ArmorStats.BOOTS, 2,
            ArmorStats.LEGGINGS, 5,
            ArmorStats.CHESTPLATE,6,
            ArmorStats.HELMET,2,
            ArmorStats.BODY, 5
    );

    public static final RegistryEntry<ArmorMaterial> PINK_GEM_ARMOR_MATERIAL = registerArmorMaterial("pink_gem",
            () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, PINK_GEM_DATA.get(ArmorStats.BOOTS));
                        map.put(ArmorItem.Type.LEGGINGS, PINK_GEM_DATA.get(ArmorStats.LEGGINGS));
                        map.put(ArmorItem.Type.CHESTPLATE, PINK_GEM_DATA.get(ArmorStats.CHESTPLATE));
                        map.put(ArmorItem.Type.HELMET, PINK_GEM_DATA.get(ArmorStats.HELMET));
                        map.put(ArmorItem.Type.BODY, PINK_GEM_DATA.get(ArmorStats.BOOTS));}
                    ),
                    PINK_GEM_DATA.get(ArmorStats.ENCHANTABILITY), SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.PINK_GEM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(TutorialMod.MOD_ID, "pink_gem"))), PINK_GEM_DATA.get(ArmorStats.TOUGHNESS), PINK_GEM_DATA.get(ArmorStats.KNOCKBACK_RESISTANCE)
            ));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material){
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(TutorialMod.MOD_ID, name), material.get());
    }
}
