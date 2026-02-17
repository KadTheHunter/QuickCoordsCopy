package io.github.simplexdev.quickcoordscopy;

import io.github.simplexdev.quickcoordscopy.config.QuickCoordsCopyConfig;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.KeyMapping.Category;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.resources.Identifier;

import net.minecraft.network.chat.Component;

import java.text.DecimalFormat;

import org.lwjgl.glfw.GLFW;

public class QuickCoordsCopyClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        QuickCoordsCopyConfig.load();

        Category keybindCategory = KeyMapping.Category.register(Identifier.fromNamespaceAndPath("quickcoordscopy", "category"));

        KeyMapping copyCoordsKey = KeyBindingHelper.registerKeyBinding(new KeyMapping("key.quickcoordscopy.copy", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_GRAVE_ACCENT, keybindCategory));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (copyCoordsKey.consumeClick()) {
                if (client.player != null) {
                    final var copyFormat = QuickCoordsCopyConfig.copyFormat;

                    DecimalFormat df = new DecimalFormat("0.00");

                    final var coords = copyFormat
                            .replace("$xFull", String.valueOf(df.format(client.player.getX())))
                            .replace("$yFull", String.valueOf(df.format(client.player.getY())))
                            .replace("$zFull", String.valueOf(df.format(client.player.getZ())))
                            .replace("$yawSnap", String.valueOf(client.player.getNearestViewDirection().get2DDataValue() == 3 ? -90 : client.player.getNearestViewDirection().get2DDataValue() * 90))
                            .replace("$yawFull", String.valueOf(df.format(client.player.getYHeadRot())))
                            .replace("$yaw", String.valueOf((int) (client.player.getYHeadRot())))
                            .replace("$pitchFull", String.valueOf(df.format(client.player.getXRot())))
                            .replace("$pitchSnap", String.valueOf(client.player.getXRot() < -45 ? -90 : client.player.getXRot() > 45 ? 90 : 0))
                            .replace("$pitch", String.valueOf((int) (client.player.getXRot())))
                            .replace("$x", String.valueOf((int) (client.player.getX())))
                            .replace("$y", String.valueOf((int) (client.player.getY())))
                            .replace("$z", String.valueOf((int) (client.player.getZ())));

                    client.keyboardHandler.setClipboard(coords);
                    if (QuickCoordsCopyConfig.confirmation) {
                        client.player.displayClientMessage(Component.translatable("text.quickcoordscopy.copied"), QuickCoordsCopyConfig.confirmationType);
                    }
                }
            }
        });
    }
}
