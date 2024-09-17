package net.libraum.platypus.block.entity.client;

import net.libraum.platypus.block.entity.PlatyplushieBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PlatyplushieBlockRenderer extends GeoBlockRenderer<PlatyplushieBlockEntity> {
    public PlatyplushieBlockRenderer(BlockEntityRendererFactory.Context context) {
        super(new PlatyplushieBlockModel());
    }
}
