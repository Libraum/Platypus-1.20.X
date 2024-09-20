package net.libraum.platypus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.libraum.platypus.block.custom.PlatyplushieBlock;
import net.libraum.platypus.block.entity.ModBlockEntities;
import net.libraum.platypus.block.entity.client.*;
import net.libraum.platypus.entity.ModEntities;
import net.libraum.platypus.entity.client.PlatypusRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class PlatypusModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.PLATYPUS, PlatypusRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntities.PLATYPLUSHIE_BLOCK_ENTITY, PlatyplushieBlockRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.BLUE_PLATYPLUSHIE_BLOCK_ENTITY, BluePlatyplushieBlockRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.DARK_PLATYPLUSHIE_BLOCK_ENTITY, DarkPlatyplushieBlockRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.GOLD_PLATYPLUSHIE_BLOCK_ENTITY, GoldPlatyplushieBlockRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.BLOOP_PLATYPLUSHIE_BLOCK_ENTITY, BloopPlatyplushieBlockRenderer::new);

    }
}
