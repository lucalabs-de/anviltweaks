package de.lucalabs.anvils.mixin;

import de.lucalabs.anvils.util.EnchantmentHelper;
import net.minecraft.screen.AnvilScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AnvilScreenHandler.class)
public class AnvilScreenHandlerMixin {

    @ModifyConstant(method = "updateResult", constant = @Constant(intValue = 39))
    private int getRenamingCost(int value) {
        return EnchantmentHelper.ANVIL_RENAMING_COST;
    }

    @ModifyConstant(method = "updateResult", constant = @Constant(intValue = 40))
    private int getLevelCap(int value) {
        return EnchantmentHelper.ANVIL_LEVEL_CAP;
    }

    @Redirect(method = "updateResult",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/screen/AnvilScreenHandler;getNextCost(I)I"
            )
    )
    private int getCappedNextRepairCost(int cost) {
        if (cost >= EnchantmentHelper.ANVIL_REPAIR_COST_CAP) {
            return EnchantmentHelper.ANVIL_REPAIR_COST_CAP;
        } else {
            return AnvilScreenHandler.getNextCost(cost);
        }
    }
}
