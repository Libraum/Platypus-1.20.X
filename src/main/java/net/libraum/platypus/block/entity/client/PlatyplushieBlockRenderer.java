package net.libraum.platypus.block.entity.client;

import net.libraum.platypus.block.custom.PlatyplushieBlock;
import net.libraum.platypus.block.entity.PlatyplushieBlockEntity;
import net.minecraft.block.BannerBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.RotationPropertyHelper;
import org.apache.http.pool.PoolEntry;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PlatyplushieBlockRenderer extends GeoBlockRenderer<PlatyplushieBlockEntity> {
    public PlatyplushieBlockRenderer(BlockEntityRendererFactory.Context context) {
        super(new PlatyplushieBlockModel());
    }

    @Override
    public void preRender(MatrixStack poseStack, PlatyplushieBlockEntity animatable, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);

        BlockState blockState = animatable.getCachedState();
        float rot = -RotationPropertyHelper.toDegrees(blockState.get(PlatyplushieBlock.ROTATION));
        poseStack.translate(.5, 0, .5);
        poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rot));
        poseStack.translate(-.5, 0, -.5);
    }
}
