package net.libraum.platypus.entity.client;

import net.libraum.platypus.PlatypusMod;
import net.libraum.platypus.entity.custom.PlatypusEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PlatypusRenderer extends GeoEntityRenderer<PlatypusEntity> {
    private static final Identifier BASE_TEXTURE = new Identifier(PlatypusMod.MOD_ID,"textures/entity/platypus/platypus.png");
    private static final Identifier BLUE_TEXTURE = new Identifier(PlatypusMod.MOD_ID,"textures/entity/platypus/platypus_blue.png");
    private static final Identifier DARK_TEXTURE = new Identifier(PlatypusMod.MOD_ID,"textures/entity/platypus/platypus_dark.png");
    private static final Identifier GOLD_TEXTURE = new Identifier(PlatypusMod.MOD_ID,"textures/entity/platypus/platypus_gold.png");
    private static final Identifier BLOOP_TEXTURE = new Identifier(PlatypusMod.MOD_ID,"textures/entity/platypus/platypus_bloop.png");

    public PlatypusRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new PlatypusModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTexture(PlatypusEntity animatable) {
        String string = Formatting.strip(animatable.getName().getString());
        if ("Blue".equals(string)) {
            return BLUE_TEXTURE;
        } else if ("Dark".equals(string)) {
            return DARK_TEXTURE;
        }else if ("Gold".equals(string)) {
            return GOLD_TEXTURE;
        }else if ("Bloop".equals(string)) {
            return BLOOP_TEXTURE;
        } else {
            return BASE_TEXTURE;
        }
    }

    @Override
    public void render(PlatypusEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public float getMotionAnimThreshold(PlatypusEntity animatable) {
        return 0.0001f;
    }
}
