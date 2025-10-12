package io.github.simplexdev.quickcoordscopy;

import io.github.simplexdev.quickcoordscopy.config.QuickCoordsCopyConfig;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.KeyBinding.Category;

import net.minecraft.client.util.InputUtil;

import net.minecraft.util.Identifier;

import net.minecraft.text.Text;

import java.text.DecimalFormat;

import org.lwjgl.glfw.GLFW;

public class QuickCoordsCopyClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        QuickCoordsCopyConfig.load();

        Category keybindCategory = KeyBinding.Category.create(Identifier.of("quickcoordscopy", "category"));

        KeyBinding copyCoordsKey = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.quickcoordscopy.copy", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_GRAVE_ACCENT, keybindCategory));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (copyCoordsKey.wasPressed()) {
                if (client.player != null) {
                    final var copyFormat = QuickCoordsCopyConfig.copyFormat;

                    DecimalFormat df = new DecimalFormat("0.00");

                    final var coords = copyFormat
                            .replace("$xFull", String.valueOf(df.format(client.player.getX())))
                            .replace("$yFull", String.valueOf(df.format(client.player.getY())))
                            .replace("$zFull", String.valueOf(df.format(client.player.getZ())))
                            .replace("$yawSnap", String.valueOf(client.player.getFacing().getHorizontalQuarterTurns() == 3 ? -90 : client.player.getFacing().getHorizontalQuarterTurns() * 90))
                            .replace("$yawFull", String.valueOf(df.format(client.player.getHeadYaw())))
                            .replace("$yaw", String.valueOf((int) (client.player.getHeadYaw())))
                            .replace("$pitchFull", String.valueOf(df.format(client.player.getPitch())))
                            .replace("$pitch", String.valueOf((int) (client.player.getPitch())))
                            .replace("$x", String.valueOf((int) (client.player.getX())))
                            .replace("$y", String.valueOf((int) (client.player.getY())))
                            .replace("$z", String.valueOf((int) (client.player.getZ())));

                    client.keyboard.setClipboard(coords);
                    if (QuickCoordsCopyConfig.confirmation) {
                        client.player.sendMessage(Text.translatable("text.quickcoordscopy.copied"), QuickCoordsCopyConfig.confirmationType);
                    }
                }
            }
        });
    }
}
