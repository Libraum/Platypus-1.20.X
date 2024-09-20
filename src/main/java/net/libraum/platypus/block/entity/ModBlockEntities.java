package net.libraum.platypus.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.libraum.platypus.PlatypusMod;
import net.libraum.platypus.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<PlatyplushieBlockEntity> PLATYPLUSHIE_BLOCK_ENTITY;
    public static BlockEntityType<BluePlatyplushieBlockEntity> BLUE_PLATYPLUSHIE_BLOCK_ENTITY;
    public static BlockEntityType<DarkPlatyplushieBlockEntity> DARK_PLATYPLUSHIE_BLOCK_ENTITY;
    public static BlockEntityType<GoldPlatyplushieBlockEntity> GOLD_PLATYPLUSHIE_BLOCK_ENTITY;
    public static BlockEntityType<BloopPlatyplushieBlockEntity> BLOOP_PLATYPLUSHIE_BLOCK_ENTITY;

    public static void registerAllBlockEntities() {
        PLATYPLUSHIE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(PlatypusMod.MOD_ID, "platyplushie_block_entity"),
                FabricBlockEntityTypeBuilder.create(PlatyplushieBlockEntity::new,
                        ModBlocks.PLATYPLUSHIE_BLOCK).build());
        BLUE_PLATYPLUSHIE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(PlatypusMod.MOD_ID, "blue_platyplushie_block_entity"),
                FabricBlockEntityTypeBuilder.create(BluePlatyplushieBlockEntity::new,
                        ModBlocks.BLUE_PLATYPLUSHIE_BLOCK).build());
        DARK_PLATYPLUSHIE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(PlatypusMod.MOD_ID, "dark_platyplushie_block_entity"),
                FabricBlockEntityTypeBuilder.create(DarkPlatyplushieBlockEntity::new,
                        ModBlocks.DARK_PLATYPLUSHIE_BLOCK).build());
        GOLD_PLATYPLUSHIE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(PlatypusMod.MOD_ID, "gold_platyplushie_block_entity"),
                FabricBlockEntityTypeBuilder.create(GoldPlatyplushieBlockEntity::new,
                        ModBlocks.GOLD_PLATYPLUSHIE_BLOCK).build());
        BLOOP_PLATYPLUSHIE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(PlatypusMod.MOD_ID, "bloop_platyplushie_block_entity"),
                FabricBlockEntityTypeBuilder.create(BloopPlatyplushieBlockEntity::new,
                        ModBlocks.BLOOP_PLATYPLUSHIE_BLOCK).build());
    }
}
