package net.vulkanmod.mixin.screen;

import net.minecraft.client.Options;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.OptionsScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.vulkanmod.config.OptionScreenV;
import net.vulkanmod.config.VideoSettingsScreen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OptionsScreen.class)
public class OptionsScreenM extends Screen {

    @Shadow @Final private Screen lastScreen;

    @Shadow @Final private Options options;

    protected OptionsScreenM(Component title) {
        super(title);
    }

    @Inject(method = "method_19828", at = @At("HEAD"), cancellable = true)
    private void injectVideoOptionScreen(Button button, CallbackInfo ci) {
//        this.minecraft.setScreen(new VideoSettingsScreen(this, this.options));
        this.minecraft.setScreen(new OptionScreenV(Component.literal("Video Setting"), this));
        ci.cancel();
    }
}
