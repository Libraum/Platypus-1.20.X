package net.libraum.platypus.block.custom;

import net.libraum.platypus.block.entity.PlatyplushieBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PlatyplushieBlock extends BlockWithEntity {
    public static final int MAX_ROTATION_INDEX = RotationPropertyHelper.getMax();
    private static final int MAX_ROTATIONS = MAX_ROTATION_INDEX + 1;
    public static final IntProperty ROTATION = Properties.ROTATION;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 3.5,12.0);

    public PlatyplushieBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(ROTATION, Integer.valueOf(0)));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(ROTATION, Integer.valueOf(RotationPropertyHelper.fromYaw(ctx.getPlayerYaw())));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if (hand == Hand.MAIN_HAND) {
                PlatyplushieBlockEntity platyplushieBlockEntity = (PlatyplushieBlockEntity) world.getBlockEntity(pos);
                platyplushieBlockEntity.triggerAnim("bounce_controller", "bounce");
                world.playSound(null, pos, SoundEvents.ENTITY_AXOLOTL_IDLE_AIR, SoundCategory.BLOCKS, 1f, 1.5f);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ROTATION);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PlatyplushieBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }
}
