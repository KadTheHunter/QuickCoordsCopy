package io.github.simplexdev.quickcoordscopy.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import io.github.simplexdev.quickcoordscopy.config.QuickCoordsCopyConfigScreen;
import net.fabricmc.loader.api.FabricLoader;

public class ModMenuPlugin implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        if (FabricLoader.getInstance().isModLoaded("cloth-config")) {
            return QuickCoordsCopyConfigScreen::createConfigScreen;
        } else {
            return null;
        }
    }
}
