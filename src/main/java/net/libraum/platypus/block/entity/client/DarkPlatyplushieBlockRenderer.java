package net.libraum.platypus.block.entity.client;

import net.libraum.platypus.block.custom.BluePlatyplushieBlock;
import net.libraum.platypus.block.custom.DarkPlatyplushieBlock;
import net.libraum.platypus.block.entity.BluePlatyplushieBlockEntity;
import net.libraum.platypus.block.entity.DarkPlatyplushieBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.RotationPropertyHelper;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class DarkPlatyplushieBlockRenderer extends GeoBlockRenderer<DarkPlatyplushieBlockEntity> {
    public DarkPlatyplushieBlockRenderer(BlockEntityRendererFactory.Context context) {
        super(new DarkPlatyplushieBlockModel());
    }

    @Override
    public void preRender(MatrixStack poseStack, DarkPlatyplushieBlockEntity animatable, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);

        BlockState blockState = animatable.getCachedState();
        float rot = -RotationPropertyHelper.toDegrees(blockState.get(DarkPlatyplushieBlock.ROTATION));
        poseStack.translate(.5, 0, .5);
        poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rot));
        poseStack.translate(-.5, 0, -.5);
    }
}
