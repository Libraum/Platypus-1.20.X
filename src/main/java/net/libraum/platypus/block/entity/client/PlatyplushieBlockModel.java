package net.libraum.platypus.block.entity.client;

import net.libraum.platypus.PlatypusMod;
import net.libraum.platypus.block.entity.PlatyplushieBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class PlatyplushieBlockModel extends GeoModel<PlatyplushieBlockEntity> {
    @Override
    public Identifier getModelResource(PlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "geo/platyplushie_block.geo.json");
    }

    @Override
    public Identifier getTextureResource(PlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "textures//block/platyplushie/platyplushie_block.png");
    }

    @Override
    public Identifier getAnimationResource(PlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "animations/platyplushie_block.animation.json");
    }
}
