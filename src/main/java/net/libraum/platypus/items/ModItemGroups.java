package net.libraum.platypus.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.libraum.platypus.PlatypusMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {
    public static final ItemGroup PLATYPUS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PlatypusMod.MOD_ID,"platypus"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.platypus"))
                    .icon(() -> new ItemStack(ModItems.PLATYPLUSHIE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.PLATYPUS_SPAWN_EGG);
                        entries.add(ModItems.PLATYPUS_BUCKET);
                        entries.add(ModItems.YABBY);
                        entries.add(ModItems.PLATYPLUSHIE);
                        entries.add(ModItems.PLATYPLUSHIE_BLUE);
                        entries.add(ModItems.PLATYPLUSHIE_DARK);
                        entries.add(ModItems.PLATYPLUSHIE_GOLD);
                        entries.add(ModItems.PLATYPLUSHIE_BLOOP);
                    }).build());
    
    public static void registerItemGroups() {
        PlatypusMod.LOGGER.info("Registering Item Groups for " + PlatypusMod.MOD_ID);
    }
}
