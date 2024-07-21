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

    public static void registerAllBlockEntities() {
        PLATYPLUSHIE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(PlatypusMod.MOD_ID, "platyplushie_block_entity"),
                FabricBlockEntityTypeBuilder.create(PlatyplushieBlockEntity::new,
                        ModBlocks.PLATYPLUSHIE_BLOCK).build());
    }
}
