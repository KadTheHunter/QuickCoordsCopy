package io.github.simplexdev.quickcoordscopy;

import io.github.simplexdev.quickcoordscopy.config.QuickCoordsCopyConfig;
import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;

public class QuickCoordsCopyClient implements ClientModInitializer {

    private static final KeyBinding copyCoordsKey = KeyBindingHelper
            .registerKeyBinding(
                    new KeyBinding(
                            "key.quickcoordscopy.copy",
                            InputUtil.Type.KEYSYM,
                            GLFW.GLFW_KEY_GRAVE_ACCENT,
                            "category.quickcoordscopy.main"));

    @Override
    public void onInitializeClient() {

        QuickCoordsCopyConfig.load();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (copyCoordsKey.wasPressed()) {
                if (client.player != null) {
                    final var copyFormat = QuickCoordsCopyConfig.copyFormat;

                    final var coords = copyFormat
                            .replace("$x", String.valueOf((int) (client.player.getX())))
                            .replace("$y", String.valueOf((int) (client.player.getY())))
                            .replace("$z", String.valueOf((int) (client.player.getZ())))
                            .replace("$h", String.valueOf((int) (client.player.getHeadYaw())))
                            .replace("$v", String.valueOf((int) (client.player.getPitch())))
                            .replace("$LRSnap", String.valueOf((int) (client.player.getYaw() / 90.0) * 90))
                            .replace("$UDSnap", String.valueOf((int) (client.player.getPitch() / 90.0) * 90));

                    client.keyboard.setClipboard(coords);
                    client.player.sendMessage(Text.literal("Copied coordinates to keyboard!"), false);
                }
            }
        });
    }
}
