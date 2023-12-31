package net.fritz.magicka.datagen;

import net.fritz.magicka.MagickaThaumicReforged;
import net.fritz.magicka.block.ModBlocks;
import net.fritz.magicka.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MagickaThaumicReforged.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.COPPER_NUGGET);
        simpleItem(ModItems.DIAMOND_NUGGET);
        simpleItem(ModItems.NETHERITE_NUGGET);
        simpleItem(ModItems.MAGICKA_INGOT);

        simpleItem(ModItems.COPPER_WAND_CAP);
        simpleItem(ModItems.IRON_WAND_CAP);
        simpleItem(ModItems.GOLD_WAND_CAP);
        simpleItem(ModItems.DIAMOND_WAND_CAP);
        simpleItem(ModItems.NETHERITE_WAND_CAP);

        simpleItem(ModItems.COPPER_SCHMECKLE);
        simpleItem(ModItems.GOLD_SCHMECKLE);
        simpleItem(ModItems.IRON_SCHMECKLE);

        simpleItem(ModItems.ZINC);
        simpleHandheldItem(ModItems.CRIMSON_BLADE);
        simpleItem(ModItems.ZOMBIE_BRAIN);
        simpleItem(ModItems.EXTRA_MEAT_TREAT);
        simpleItem(ModItems.MAGICKA_TABLET);
        simpleItem(ModItems.ZIRCONIUM);
        simpleItem(ModItems.MAGICKA_SHARD);

        saplingItem(ModBlocks.SILVERWOOD_SAPLING);


    }


    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MagickaThaumicReforged.MODID, "block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MagickaThaumicReforged.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleHandheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(MagickaThaumicReforged.MODID, "item/" + item.getId().getPath()));
    }

}
