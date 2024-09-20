package net.libraum.platypus.datagen;

import com.eliotlash.mclib.math.functions.classic.Mod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.libraum.platypus.items.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) { super(output); }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PLATYPUS_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.PLATYPUS_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.YABBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATYPLUSHIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATYPLUSHIE_BLUE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATYPLUSHIE_DARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATYPLUSHIE_GOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATYPLUSHIE_BLOOP, Models.GENERATED);
    }
}
