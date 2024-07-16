package net.libraum.platypus.entity.client;

import net.libraum.platypus.PlatypusMod;
import net.libraum.platypus.entity.custom.PlatypusEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PlatypusModel extends GeoModel<PlatypusEntity> {
    @Override
    public Identifier getModelResource(PlatypusEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "geo/platypus.geo.json");
    }

    @Override
    public Identifier getTextureResource(PlatypusEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "textures/entity/platypus.png");
    }

    @Override
    public Identifier getAnimationResource(PlatypusEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "animations/platypus.animation.json");
    }

    @Override
    public void setCustomAnimations(PlatypusEntity animatable, long instanceId, AnimationState<PlatypusEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
