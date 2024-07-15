package net.libraum.platypus.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.libraum.platypus.PlatypusMod;
import net.libraum.platypus.entity.custom.PlatypusEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<PlatypusEntity> PLATYPUS = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(PlatypusMod.MOD_ID, "platypus"),
            FabricEntityTypeBuilder.create(SpawnGroup.AXOLOTLS, PlatypusEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 0.4f)).build());
}
