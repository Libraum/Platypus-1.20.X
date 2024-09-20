package net.libraum.platypus.block.entity.client;

import net.libraum.platypus.PlatypusMod;
import net.libraum.platypus.block.entity.BluePlatyplushieBlockEntity;
import net.libraum.platypus.block.entity.DarkPlatyplushieBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class DarkPlatyplushieBlockModel extends GeoModel<DarkPlatyplushieBlockEntity> {
    @Override
    public Identifier getModelResource(DarkPlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "geo/platyplushie_block.geo.json");
    }

    @Override
    public Identifier getTextureResource(DarkPlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "textures//block/platyplushie/dark_platyplushie_block.png");
    }

    @Override
    public Identifier getAnimationResource(DarkPlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "animations/platyplushie_block.animation.json");
    }
}
