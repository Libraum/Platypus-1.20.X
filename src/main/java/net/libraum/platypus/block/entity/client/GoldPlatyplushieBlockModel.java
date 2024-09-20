package net.libraum.platypus.block.entity.client;

import net.libraum.platypus.PlatypusMod;
import net.libraum.platypus.block.entity.GoldPlatyplushieBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class GoldPlatyplushieBlockModel extends GeoModel<GoldPlatyplushieBlockEntity> {
    @Override
    public Identifier getModelResource(GoldPlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "geo/platyplushie_block.geo.json");
    }

    @Override
    public Identifier getTextureResource(GoldPlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "textures//block/platyplushie/gold_platyplushie_block.png");
    }

    @Override
    public Identifier getAnimationResource(GoldPlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "animations/platyplushie_block.animation.json");
    }
}
