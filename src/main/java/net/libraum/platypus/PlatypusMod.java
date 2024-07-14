package net.libraum.platypus;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.libraum.platypus.entity.ModEntities;
import net.libraum.platypus.entity.custom.PlatypusEntity;
import net.libraum.platypus.items.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlatypusMod implements ModInitializer {
	public static final String MOD_ID = "platypusmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(ModEntities.PLATYPUS, PlatypusEntity.setAttributes());
		ModItems.registerModItems();
	}
}