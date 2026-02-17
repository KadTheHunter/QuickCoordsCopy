package io.github.simplexdev.quickcoordscopy.config;

import io.github.simplexdev.quickcoordscopy.config.QuickCoordsCopyConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class QuickCoordsCopyConfigScreen {
    public static Screen createConfigScreen(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Component.translatable("text.autoconfig.quickcoordscopy.title"));
        builder.setSavingRunnable(QuickCoordsCopyConfig::save);
        ConfigCategory general = builder
                .getOrCreateCategory(Component.translatable("text.autoconfig.quickcoordscopy.title"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        // Copy Format
        general.addEntry(entryBuilder
                        .startStrField(
                                Component.translatable("text.autoconfig.quickcoordscopy.option.copyFormat"),
                        QuickCoordsCopyConfig.copyFormat)
                .setDefaultValue(QuickCoordsCopyConfig.DEFAULT_COPY_FORMAT)
                .setSaveConsumer((replace) -> QuickCoordsCopyConfig.copyFormat = replace).build());
        // Secondary Copy Format
        general.addEntry(entryBuilder
                        .startStrField(
                                Component.translatable("text.autoconfig.quickcoordscopy.option.secondaryCopyFormat"),
                        QuickCoordsCopyConfig.secondaryCopyFormat)
                .setDefaultValue(QuickCoordsCopyConfig.DEFAULT_SECONDARY_COPY_FORMAT)
                .setSaveConsumer((replace) -> QuickCoordsCopyConfig.secondaryCopyFormat = replace).build());
        // Copy Format Description
        general.addEntry(entryBuilder
                .startTextDescription(
                        Component.translatable("text.autoconfig.quickcoordscopy.option.copyFormatDescription"))
                .build());
        // Confirmation
        general.addEntry(entryBuilder
                .startBooleanToggle(
                        Component.translatable("text.autoconfig.quickcoordscopy.option.confirmation"),
                        QuickCoordsCopyConfig.confirmation)
                .setDefaultValue(QuickCoordsCopyConfig.DEFAULT_CONFIRMATION)
                .setSaveConsumer((replace) -> QuickCoordsCopyConfig.confirmation = replace)
                .build());
        // Confirmation Type
        enum ConfirmTypeLabel {
            CHAT,
            HUD
        }
        general.addEntry(entryBuilder
                .startEnumSelector(Component.translatable("text.autoconfig.quickcoordscopy.option.confirmationType"),
                        ConfirmTypeLabel.class,
                        !QuickCoordsCopyConfig.confirmationType ? ConfirmTypeLabel.CHAT : ConfirmTypeLabel.HUD)
                .setDefaultValue(ConfirmTypeLabel.HUD)
                .setSaveConsumer((replace) -> QuickCoordsCopyConfig.confirmationType = replace == ConfirmTypeLabel.HUD)
                .build());
        return builder.build();
    }
}
