package net.libraum.platypus.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.libraum.platypus.PlatypusMod;
import net.libraum.platypus.block.custom.PlatyplushieBlock;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block PLATYPLUSHIE_BLOCK = Registry.register(Registries.BLOCK, new Identifier(PlatypusMod.MOD_ID, "platyplushie_block"),
            new PlatyplushieBlock(FabricBlockSettings.create().strength(1.0f).pistonBehavior(PistonBehavior.DESTROY).nonOpaque()));

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(PlatypusMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(PlatypusMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }

    public static void  registerModBlocks() {
        PlatypusMod.LOGGER.info("Registering ModBlocks for " + PlatypusMod.MOD_ID);
    }
}
