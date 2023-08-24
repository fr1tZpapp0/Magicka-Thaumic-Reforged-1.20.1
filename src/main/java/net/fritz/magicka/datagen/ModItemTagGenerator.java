package net.fritz.magicka.datagen;

import net.fritz.magicka.MagickaThaumicReforged;
import net.fritz.magicka.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
                               CompletableFuture<TagLookup<Block>> completableFuture,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, MagickaThaumicReforged.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(ItemTags.LOGS_THAT_BURN).add(

                ModBlocks.SILVERWOOD_LOG.get().asItem(),
                ModBlocks.STRIPPED_SILVERWOOD_LOG.get().asItem(),
                ModBlocks.STRIPPED_SILVERWOOD_WOOD.get().asItem(),
                ModBlocks.SILVERWOOD_WOOD.get().asItem()
        );


        this.tag(ItemTags.PLANKS)
                .add(
                        ModBlocks.SILVERWOOD_PLANKS.get().asItem()
                );
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
