package net.libraum.platypus.entity.custom;

import net.libraum.platypus.entity.ModEntities;
import net.minecraft.entity.Bucketable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class PlatypusEntity extends AxolotlEntity implements GeoEntity, Bucketable {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public PlatypusEntity(EntityType<? extends AxolotlEntity> entityType, World world) {
        super(entityType, world);
    }

    //Attributes
    public static DefaultAttributeContainer.Builder setAttributes() {
        return AxolotlEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 14.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8f);
    }

    //Goals
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(1, new AnimalMateGoal(this, 0.850));
        this.goalSelector.add(2, new TemptGoal(this, 1.150, Ingredient.ofItems(Items.SPIDER_EYE), false));

        this.goalSelector.add(3, new FollowParentGoal(this, 1.150));

        this.goalSelector.add(4, new MoveIntoWaterGoal(this));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(7, new LookAroundGoal(this));
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
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <P extends GeoAnimatable> PlayState predicate(AnimationState<P> pAnimationState) {
        if(pAnimationState.isMoving()) {
            pAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.platypus.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        pAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.platypus.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    //Sounds
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_AXOLOTL_IDLE_AIR;
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
}
