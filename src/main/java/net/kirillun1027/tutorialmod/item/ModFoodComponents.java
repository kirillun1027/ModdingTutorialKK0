package net.kirillun1027.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent FRIED_EGG = new FoodComponent.Builder().snack().nutrition(2).saturationModifier(0.6f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5), 0.2f).build();

    public static final FoodComponent FRIED_EGGS = new FoodComponent.Builder().nutrition(8).saturationModifier(0.6f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5), 0.2f).build();
}
