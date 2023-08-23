package net.fritz.magicka.item;

import net.fritz.magicka.MagickaThaumicReforged;
import net.fritz.magicka.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MagickaThaumicReforged.MODID);

    public static final RegistryObject<CreativeModeTab> MAGICKA_TAB = CREATIVE_MODE_TABS.register("magicka_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.IRON_WAND_CAP.get()))
                    .title(Component.translatable("creativetab.magicka_tab")).displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.DIAMOND_NUGGET.get());
                        pOutput.accept(ModItems.COPPER_NUGGET.get());
                        pOutput.accept(ModItems.NETHERITE_NUGGET.get());

                        pOutput.accept(ModItems.IRON_WAND_CAP.get());
                        pOutput.accept(ModItems.GOLD_WAND_CAP.get());
                        pOutput.accept(ModItems.DIAMOND_WAND_CAP.get());
                        pOutput.accept(ModItems.NETHERITE_WAND_CAP.get());
                        pOutput.accept(ModItems.COPPER_WAND_CAP.get());

                        pOutput.accept(ModBlocks.MAGICKA_INFUSED_STONE.get());
                        pOutput.accept(ModBlocks.MAGICKA_STONE_BRICKS.get());

                    }).build());


    public static void register (IEventBus eventBus) { CREATIVE_MODE_TABS.register(eventBus); }
}
