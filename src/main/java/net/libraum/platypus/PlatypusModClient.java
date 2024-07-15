package net.libraum.platypus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.libraum.platypus.entity.ModEntities;
import net.libraum.platypus.entity.client.PlatypusRenderer;

public class PlatypusModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.PLATYPUS, PlatypusRenderer::new);

    }
}
