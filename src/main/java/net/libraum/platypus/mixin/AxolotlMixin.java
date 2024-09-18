package net.libraum.platypus.mixin;

import net.libraum.platypus.entity.ai.PlatypusBrain;
import net.libraum.platypus.entity.custom.PlatypusEntity;
import net.minecraft.entity.passive.AxolotlBrain;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AxolotlEntity.class)
public class AxolotlMixin {
	@Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/AxolotlBrain;updateActivities(Lnet/minecraft/entity/passive/AxolotlEntity;)V"), method = "mobTick")
	private void platypusAICheck(AxolotlEntity axolotl) {
		if (axolotl instanceof PlatypusEntity platypus)
			PlatypusBrain.updateActivities(platypus);
		else
			AxolotlBrain.updateActivities(axolotl);
	}
}