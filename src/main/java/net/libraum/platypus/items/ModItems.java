package net.libraum.platypus.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.libraum.platypus.PlatypusMod;
import net.libraum.platypus.entity.ModEntities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static software.bernie.example.registry.ItemRegistry.registerItem;

public class ModItems {
    public static final Item PLATYPUS_SPAWN_EGG = registerItem("platypus_spawn_egg",
            new SpawnEggItem(ModEntities.PLATYPUS, 0x4a2e1b, 0x31373e, new FabricItemSettings()));

    public static final Item PLATYPUS_BUCKET = registerItem("platypus_bucket",
            new Item(new FabricItemSettings()));

    private static void addItemsToSpawnEggItemGroup(FabricItemGroupEntries entries) {
        entries.add(PLATYPUS_SPAWN_EGG);
    }

    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
        entries.add(PLATYPUS_BUCKET);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PlatypusMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PlatypusMod.LOGGER.info("Registering Mod Items for" + PlatypusMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemsToSpawnEggItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
    }
}