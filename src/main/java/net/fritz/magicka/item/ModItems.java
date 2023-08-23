package net.fritz.magicka.item;

import net.fritz.magicka.MagickaThaumicReforged;
import net.fritz.magicka.item.custom.FuelItem;
import net.fritz.magicka.item.custom.MagickaTabletItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
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


    public static final RegistryObject<Item> DIAMOND_NUGGET = ITEMS.register("diamond_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZINC = ITEMS.register("zinc",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> CRIMSON_BLADE = ITEMS.register("crimson_blade",
            () -> new SwordItem(ModTiers.CRIMSON, 3, 3, new Item.Properties()));


    public static final RegistryObject<Item> MAGICKA_TABLET = ITEMS.register("magicka_tablet",
            () -> new MagickaTabletItem(new Item.Properties().stacksTo(1)));



    public static final RegistryObject<Item> ZOMBIE_BRAIN = ITEMS.register("zombie_brain",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ZOMBIE_BRAIN)));

    public static final RegistryObject<Item> ZIRCONIUM = ITEMS.register("zirconium",
            () -> new FuelItem(new Item.Properties(), 200));

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
