package io.github.simplexdev.quickcoordscopy.config;

import io.github.simplexdev.quickcoordscopy.config.QuickCoordsCopyConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class QuickCoordsCopyConfigScreen {
    public static Screen createConfigScreen(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.translatable("text.autoconfig.accurateblockplacement.title"));
        builder.setSavingRunnable(QuickCoordsCopyConfig::save);
        ConfigCategory general = builder
                .getOrCreateCategory(Text.translatable("text.autoconfig.accurateblockplacement.title"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        // Copy Format
        general.addEntry(entryBuilder
                        .startStrField(
                                Text.translatable("text.autoconfig.quickcoordscopy.option.copyFormat"),
                        QuickCoordsCopyConfig.copyFormat)
                .setDefaultValue(QuickCoordsCopyConfig.DEFAULT_COPY_FORMAT)
                .setSaveConsumer((replace) -> QuickCoordsCopyConfig.copyFormat = replace).build());
        return builder.build();
    }
}
