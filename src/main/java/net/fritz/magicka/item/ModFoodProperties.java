package net.fritz.magicka.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties ZOMBIE_BRAIN = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.15f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200), 0.75f).meat().build();

    public static final FoodProperties EXTRA_MEAT_TREAT = new FoodProperties.Builder().nutrition(3)
            .saturationMod(1f)
            .meat().build();
}
