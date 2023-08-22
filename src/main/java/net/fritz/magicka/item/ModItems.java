package net.fritz.magicka.item;

import net.fritz.magicka.MagickaThaumicReforged;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MagickaThaumicReforged.MODID);



    public static final RegistryObject<Item> IRON_WAND_CAP = ITEMS.register("iron_wand_cap",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLD_WAND_CAP = ITEMS.register("gold_wand_cap",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_WAND_CAP = ITEMS.register("diamond_wand_cap",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_WAND_CAP = ITEMS.register("netherite_wand_cap",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COPPER_WAND_CAP = ITEMS.register("copper_wand_cap",
            () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
