package net.fritz.magicka.datagen;

import net.fritz.magicka.MagickaThaumicReforged;
import net.fritz.magicka.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MagickaThaumicReforged.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MAGICKA_INFUSED_STONE);
        blockWithItem(ModBlocks.MAGICKA_STONE_BRICKS);
        blockWithItem(ModBlocks.ZINC_ORE);
        blockWithItem(ModBlocks.ELDRITCH_STONE);


        logBlock(((RotatedPillarBlock) ModBlocks.SILVERWOOD_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.SILVERWOOD_WOOD.get()),
                blockTexture(ModBlocks.SILVERWOOD_LOG.get()),
                blockTexture(ModBlocks.SILVERWOOD_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SILVERWOOD_LOG.get()),
                new ResourceLocation(MagickaThaumicReforged.MODID, "block/stripped_silverwood_log"),
                new ResourceLocation(MagickaThaumicReforged.MODID, "block/stripped_silverwood_log_top"));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SILVERWOOD_WOOD.get()),
                new ResourceLocation(MagickaThaumicReforged.MODID, "block/stripped_silverwood_log"),
                new ResourceLocation(MagickaThaumicReforged.MODID, "block/stripped_silverwood_log"));


        blockItem(ModBlocks.SILVERWOOD_LOG);
        blockItem(ModBlocks.SILVERWOOD_WOOD);
        blockItem(ModBlocks.STRIPPED_SILVERWOOD_LOG);
        blockItem(ModBlocks.STRIPPED_SILVERWOOD_WOOD);

        blockWithItem(ModBlocks.SILVERWOOD_PLANKS);
        leavesBlock(ModBlocks.SILVERWOOD_LEAVES);
        saplingBlock(ModBlocks.SILVERWOOD_SAPLING);

    }


    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }


    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("magicka:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("magicka:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
