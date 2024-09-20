package net.libraum.platypus.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.libraum.platypus.items.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier FISHING_ID =
            new Identifier("minecraft", "gameplay/fishing/fish");
    private static final Identifier Village_Fisher_Chest_ID =
            new Identifier("minecraft", "chests/village/village_fisher");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(FISHING_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModItems.YABBY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(Village_Fisher_Chest_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.33f))
                        .with(ItemEntry.builder(ModItems.YABBY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
