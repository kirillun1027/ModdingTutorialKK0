package net.kirillun1027.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PinkGemLamp extends Block {

    public static final BooleanProperty IS_CLICKED = BooleanProperty.of("is_clicked");

    public PinkGemLamp(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(IS_CLICKED, false));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient){
            if (world.setBlockState(pos, state.cycle(IS_CLICKED))) {

            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(IS_CLICKED);
    }
}
