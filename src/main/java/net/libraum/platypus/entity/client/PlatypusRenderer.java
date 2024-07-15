package net.libraum.platypus.entity.client;

import net.libraum.platypus.PlatypusMod;
import net.libraum.platypus.entity.custom.PlatypusEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PlatypusRenderer extends GeoEntityRenderer<PlatypusEntity> {
    public PlatypusRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new PlatypusModel());
    }

    @Override
    public Identifier getTextureLocation(PlatypusEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "textures/entity/platypus.png");
    }

    @Override
    public void render(PlatypusEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
