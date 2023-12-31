package net.fritz.magicka.datagen;

import net.fritz.magicka.MagickaThaumicReforged;
import net.fritz.magicka.block.ModBlocks;
import net.fritz.magicka.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MagickaThaumicReforged.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //this.tag(ModTags.Blocks.).add(ModBlocks.ZINC_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                ModBlocks.ZINC_ORE.get(),
                ModBlocks.MAGICKA_INFUSED_STONE.get(),
                ModBlocks.MAGICKA_STONE_BRICKS.get(),
                ModBlocks.ELDRITCH_STONE.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(
                        ModBlocks.SILVERWOOD_LOG.get(),
                        ModBlocks.STRIPPED_SILVERWOOD_LOG.get(),
                        ModBlocks.STRIPPED_SILVERWOOD_WOOD.get(),
                        ModBlocks.SILVERWOOD_WOOD.get()
                );


      this.tag(BlockTags.NEEDS_IRON_TOOL)
                    .add(
                    ModBlocks.ZINC_ORE.get(),
                    ModBlocks.MAGICKA_INFUSED_STONE.get(),
                    ModBlocks.MAGICKA_STONE_BRICKS.get()
            );

      this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
              .add (
                 ModBlocks.ELDRITCH_STONE.get()
              );


      this.tag(BlockTags.LOGS_THAT_BURN)
              .add(
                      ModBlocks.SILVERWOOD_LOG.get(),
                      ModBlocks.STRIPPED_SILVERWOOD_LOG.get(),
                      ModBlocks.STRIPPED_SILVERWOOD_WOOD.get(),
                      ModBlocks.SILVERWOOD_WOOD.get()
              );


        this.tag(BlockTags.PLANKS)
                .add(
                        ModBlocks.SILVERWOOD_PLANKS.get()
                );

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
