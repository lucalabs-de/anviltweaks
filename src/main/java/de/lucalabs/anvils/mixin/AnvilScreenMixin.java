package de.lucalabs.anvils.mixin;

import de.lucalabs.anvils.util.EnchantmentHelper;
import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(AnvilScreen.class)
public class AnvilScreenMixin {
    @ModifyConstant(method = "drawForeground", constant = @Constant(intValue = 40))
    private int getLevelCap(int value) {
        return EnchantmentHelper.ANVIL_LEVEL_CAP;
    }
}
