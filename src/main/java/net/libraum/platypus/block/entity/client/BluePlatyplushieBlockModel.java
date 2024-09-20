package net.libraum.platypus.block.entity.client;

import net.libraum.platypus.PlatypusMod;
import net.libraum.platypus.block.entity.BluePlatyplushieBlockEntity;
import net.libraum.platypus.block.entity.PlatyplushieBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BluePlatyplushieBlockModel extends GeoModel<BluePlatyplushieBlockEntity> {
    @Override
    public Identifier getModelResource(BluePlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "geo/platyplushie_block.geo.json");
    }

    @Override
    public Identifier getTextureResource(BluePlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "textures//block/platyplushie/blue_platyplushie_block.png");
    }

    @Override
    public Identifier getAnimationResource(BluePlatyplushieBlockEntity animatable) {
        return new Identifier(PlatypusMod.MOD_ID, "animations/platyplushie_block.animation.json");
    }
}
