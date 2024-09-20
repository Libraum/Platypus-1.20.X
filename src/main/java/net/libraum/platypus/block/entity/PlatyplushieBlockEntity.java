package net.libraum.platypus.block.entity;

import net.libraum.platypus.block.custom.PlatyplushieBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.util.RenderUtils;

public class PlatyplushieBlockEntity extends BlockEntity implements GeoBlockEntity {
    private static final RawAnimation BOUNCE = RawAnimation.begin().thenPlay("animation.platyplushie_block.bounce");
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public PlatyplushieBlockEntity( BlockPos pos, BlockState state) {
        super(ModBlockEntities.PLATYPLUSHIE_BLOCK_ENTITY, pos, state);

        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "bounce_controller", 0, state -> PlayState.STOP)
                .triggerableAnim("bounce", BOUNCE));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object blockEntity) {
        return RenderUtils.getCurrentTick();
    }
}
