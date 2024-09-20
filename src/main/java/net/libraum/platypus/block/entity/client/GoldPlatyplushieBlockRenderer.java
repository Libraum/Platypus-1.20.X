package net.libraum.platypus.block.entity.client;

import net.libraum.platypus.block.custom.BluePlatyplushieBlock;
import net.libraum.platypus.block.custom.GoldPlatyplushieBlock;
import net.libraum.platypus.block.entity.BluePlatyplushieBlockEntity;
import net.libraum.platypus.block.entity.GoldPlatyplushieBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.RotationPropertyHelper;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GoldPlatyplushieBlockRenderer extends GeoBlockRenderer<GoldPlatyplushieBlockEntity> {
    public GoldPlatyplushieBlockRenderer(BlockEntityRendererFactory.Context context) {
        super(new GoldPlatyplushieBlockModel());
    }

    @Override
    public void preRender(MatrixStack poseStack, GoldPlatyplushieBlockEntity animatable, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);

        BlockState blockState = animatable.getCachedState();
        float rot = -RotationPropertyHelper.toDegrees(blockState.get(GoldPlatyplushieBlock.ROTATION));
        poseStack.translate(.5, 0, .5);
        poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rot));
        poseStack.translate(-.5, 0, -.5);
    }
}
