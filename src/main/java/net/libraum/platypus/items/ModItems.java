package net.libraum.platypus.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.libraum.platypus.PlatypusMod;
import net.libraum.platypus.block.ModBlocks;
import net.libraum.platypus.entity.ModEntities;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModItems {
    //New Items
    public static final Item PLATYPUS_SPAWN_EGG = registerItem("platypus_spawn_egg",
            new SpawnEggItem(ModEntities.PLATYPUS, 0x4a2e1b, 0x31373e, new FabricItemSettings()));

    public static final Item PLATYPUS_BUCKET = registerItem("platypus_bucket",
            new EntityBucketItem(ModEntities.PLATYPUS, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_AXOLOTL, new Item.Settings().maxCount(1)));

    public static final Item YABBY = registerItem("yabby",
            new Item(new FabricItemSettings()));

    public static final Item PLATYPLUSHIE = registerItem("platyplushie",
            new BlockItem(ModBlocks.PLATYPLUSHIE_BLOCK, new FabricItemSettings().maxCount(16)));
    public static final Item PLATYPLUSHIE_BLUE = registerItem("platyplushie_blue",
            new BlockItem(ModBlocks.BLUE_PLATYPLUSHIE_BLOCK, new FabricItemSettings().maxCount(16)));
    public static final Item PLATYPLUSHIE_DARK = registerItem("platyplushie_dark",
            new BlockItem(ModBlocks.DARK_PLATYPLUSHIE_BLOCK, new FabricItemSettings().maxCount(16)));
    public static final Item PLATYPLUSHIE_GOLD = registerItem("platyplushie_gold",
            new BlockItem(ModBlocks.GOLD_PLATYPLUSHIE_BLOCK, new FabricItemSettings().maxCount(16)));
    public static final Item PLATYPLUSHIE_BLOOP = registerItem("platyplushie_bloop",
            new BlockItem(ModBlocks.BLOOP_PLATYPLUSHIE_BLOCK, new FabricItemSettings().maxCount(16)));

    //Item Groups
    private static void addItemsToSpawnEggItemGroup(FabricItemGroupEntries entries) {
        entries.add(PLATYPUS_SPAWN_EGG);
    }

    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
        entries.add(PLATYPUS_BUCKET);
    }

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(YABBY);
    }

    private static void addItemsToFunctionalItemGroup(FabricItemGroupEntries entries) {
        entries.add(PLATYPLUSHIE);
        entries.add(PLATYPLUSHIE_BLUE);
        entries.add(PLATYPLUSHIE_DARK);
        entries.add(PLATYPLUSHIE_GOLD);
        entries.add(PLATYPLUSHIE_BLOOP);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PlatypusMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PlatypusMod.LOGGER.info("Registering Mod Items for" + PlatypusMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemsToSpawnEggItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModItems::addItemsToFunctionalItemGroup);
    }
}