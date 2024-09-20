package net.libraum.platypus.block.entity.client;

import net.libraum.platypus.PlatypusMod;
import net.libraum.platypus.block.entity.BloopPlatyplushieBlockEntity;
import net.libraum.platypus.block.entity.BluePlatyplushieBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BloopPlatyplushieBlockModel extends GeoModel<BloopPlatyplushieBlockEntity> {
    @Override
    public Identifier getModelResource(BloopPlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "geo/platyplushie_block.geo.json");
    }

    @Override
    public Identifier getTextureResource(BloopPlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "textures//block/platyplushie/bloop_platyplushie_block.png");
    }

    @Override
    public Identifier getAnimationResource(BloopPlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "animations/platyplushie_block.animation.json");
    }
}
