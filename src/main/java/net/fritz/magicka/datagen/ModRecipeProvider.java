package net.fritz.magicka.datagen;

import net.fritz.magicka.MagickaThaumicReforged;
import net.fritz.magicka.block.ModBlocks;
import net.fritz.magicka.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public static final List<ItemLike> zincSmeltables = List.of(ModBlocks.ZINC_ORE.get());


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_WAND_CAP.get())
                .pattern("X X X")
                .pattern("X Y X")
                .define('X', ModItems.COPPER_NUGGET.get())
                .define('Y', Items.AIR)
                .unlockedBy("has_copper_nugget", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.COPPER_NUGGET.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_WAND_CAP.get())
                .pattern("X X X")
                .pattern("X Y X")
                .define('X', Items.IRON_NUGGET)
                .define('Y', Items.AIR)
                .unlockedBy("has_iron_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(Items.IRON_NUGGET).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLD_WAND_CAP.get())
                .pattern("X X X")
                .pattern("X Y X")
                .define('X', Items.GOLD_NUGGET)
                .define('Y', Items.AIR)
                .unlockedBy("has_gold_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(Items.GOLD_NUGGET).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_WAND_CAP.get())
                .pattern("X X X")
                .pattern("X Y X")
                .define('X', ModItems.DIAMOND_NUGGET.get())
                .define('Y', Items.AIR)
                .unlockedBy("has_diamond_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.DIAMOND_NUGGET.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NETHERITE_WAND_CAP.get())
                .pattern("X X X")
                .pattern("X Y X")
                .define('X', ModItems.NETHERITE_NUGGET.get())
                .define('Y', Items.AIR)
                .unlockedBy("has_netherite_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.NETHERITE_NUGGET.get()).build()))
                .save(pWriter);



        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_NUGGET.get(), 9)
                .requires(Items.COPPER_INGOT).unlockedBy("has_copper_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(Items.COPPER_INGOT).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DIAMOND_NUGGET.get(), 9)
                .requires(Items.COPPER_INGOT).unlockedBy("has_diamond", inventoryTrigger(ItemPredicate.Builder.item().of(Items.DIAMOND).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NETHERITE_NUGGET.get(), 9)
                .requires(Items.COPPER_INGOT).unlockedBy("has_netherite_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(Items.NETHERITE_INGOT).build()))
                .save(pWriter);


        oreSmelting(pWriter, zincSmeltables, RecipeCategory.MISC, ModItems.ZINC.get(), 0.25f,250, "zinc");
        oreBlasting(pWriter, zincSmeltables, RecipeCategory.MISC, ModItems.ZINC.get(), 0.25f,175, "zinc");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients,
                pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients,
                pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe>
            pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, MagickaThaumicReforged.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

}
