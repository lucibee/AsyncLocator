package brightspark.asynclocator.mixins;

import brightspark.asynclocator.ALConstants;
import brightspark.asynclocator.logic.CommonLogic;
import brightspark.asynclocator.logic.ExplorationMapFunctionLogic;
import brightspark.asynclocator.platform.Services;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.SetNameFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SetNameFunction.class)
public class SetNameFunctionMixin {
    @Inject(
        method = "run",
        at = @At("RETURN")
    )
    private void afterRun(ItemStack stack, LootContext context, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack result = cir.getReturnValue();
        if (Services.CONFIG.explorationMapEnabled() && CommonLogic.isEmptyPendingMap(result)) {
            ALConstants.logDebug("Intercepted SetNameFunction#run at RETURN");
            // Try to get the custom name component from the ItemStack
            Component name = result.get(DataComponents.CUSTOM_NAME);
            if (name != null) {
                ExplorationMapFunctionLogic.cacheName(result, name);
            }
        }
    }
}
