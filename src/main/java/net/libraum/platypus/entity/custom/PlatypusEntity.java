package net.libraum.platypus.entity.custom;

import net.libraum.platypus.entity.ModEntities;
import net.minecraft.entity.Bucketable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.VariantHolder;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import net.libraum.platypus.items.ModItems;

import java.util.Arrays;
import java.util.function.IntFunction;

public class PlatypusEntity extends AxolotlEntity implements GeoEntity, Bucketable{
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public PlatypusEntity(EntityType<? extends AxolotlEntity> entityType, World world) {
        super(entityType, world);
    }

    //Attributes
    public static DefaultAttributeContainer.Builder setAttributes() {
        return AxolotlEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 14.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0);
    }

    //Goals
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new EscapeDangerGoal(this, 1.25));

        this.goalSelector.add(1, new AnimalMateGoal(this, 0.5));
        this.goalSelector.add(2, new TemptGoal(this, 0.75, Ingredient.ofItems(Items.SPIDER_EYE), false));
        this.goalSelector.add(3, new FollowParentGoal(this, 0.75));

        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8f));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    //Breeding
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.SPIDER_EYE);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.PLATYPUS.create(world);
    }

    //Animation Controller
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(movementController(this));
    }

    public <T extends GeoAnimatable> AnimationController<PlatypusEntity> movementController(PlatypusEntity PlatypusEntity) {
        return new AnimationController<PlatypusEntity>(this, "movement", 10, state -> {
            boolean isSwimming = this.isTouchingWater();

            //Swimming
            if (isSwimming) {
                if (state.isMoving() && getVelocity().getY() > 0.05) {
                    state.getController().setAnimation(RawAnimation.begin().then("animation.platypus.swim_up", Animation.LoopType.LOOP));
                } else if (state.isMoving() && getVelocity().getY() < -0.05) {
                    state.getController().setAnimation(RawAnimation.begin().then("animation.platypus.swim_down", Animation.LoopType.LOOP));
                } else if (state.isMoving() && getVelocity().getY() < 0.05 && getVelocity().getY() > -0.05) {
                    state.getController().setAnimation(RawAnimation.begin().then("animation.platypus.swim", Animation.LoopType.LOOP));
                } else {
                    state.getController().setAnimation(RawAnimation.begin().then("animation.platypus.float", Animation.LoopType.LOOP));
                }
            //Grounded
            } else if (state.isMoving()) {
                state.getController().setAnimation(RawAnimation.begin().then("animation.platypus.walk", Animation.LoopType.LOOP));
            } else {
                state.getController().setAnimation(RawAnimation.begin().then("animation.platypus.idle", Animation.LoopType.LOOP));
            }
            return PlayState.CONTINUE;
        });
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    //Bucket
    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(ModItems.PLATYPUS_BUCKET);
    }

    //Sounds
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return this.isTouchingWater() ? SoundEvents.ENTITY_AXOLOTL_IDLE_WATER : SoundEvents.ENTITY_AXOLOTL_IDLE_AIR;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_AXOLOTL_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_AXOLOTL_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getSplashSound() {
        return SoundEvents.ENTITY_AXOLOTL_SPLASH;
    }

    @Nullable
    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_AXOLOTL_SWIM;
    }

    @Nullable
    @Override
    public SoundEvent getBucketFillSound() {
        return SoundEvents.ITEM_BUCKET_FILL_AXOLOTL;
    }
}
