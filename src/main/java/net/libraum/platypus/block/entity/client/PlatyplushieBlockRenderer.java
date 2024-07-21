package net.libraum.platypus.block.entity.client;

import net.libraum.platypus.block.entity.PlatyplushieBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PlatyplushieBlockRenderer extends GeoBlockRenderer<PlatyplushieBlockEntity> {
    public PlatyplushieBlockRenderer(BlockEntityRendererFactory.Context context) {
        super(new PlatyplushieBlockModel());
    }
}
