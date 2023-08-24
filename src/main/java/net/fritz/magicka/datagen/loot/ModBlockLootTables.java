package net.fritz.magicka.datagen.loot;

import net.fritz.magicka.block.ModBlocks;
import net.fritz.magicka.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.MAGICKA_STONE_BRICKS.get());
        this.dropSelf(ModBlocks.ELDRITCH_STONE.get());

        this.dropSelf(ModBlocks.SILVERWOOD_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_SILVERWOOD_LOG.get());
        this.dropSelf(ModBlocks.SILVERWOOD_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_SILVERWOOD_WOOD.get());
        this.dropSelf(ModBlocks.SILVERWOOD_PLANKS.get());
        this.dropSelf(ModBlocks.SILVERWOOD_SAPLING.get());

        this.add(ModBlocks.SILVERWOOD_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.SILVERWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));


        this.add(ModBlocks.ZINC_ORE.get(), block ->
                createOreDrop(ModBlocks.ZINC_ORE.get(), ModItems.ZINC.get()));

        this.add(ModBlocks.MAGICKA_INFUSED_STONE.get(), block ->
                createOreDrop(ModBlocks.MAGICKA_INFUSED_STONE.get(), ModItems.MAGICKA_SHARD.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
