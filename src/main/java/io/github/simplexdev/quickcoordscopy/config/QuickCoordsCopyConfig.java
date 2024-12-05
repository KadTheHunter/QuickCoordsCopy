package io.github.simplexdev.quickcoordscopy.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

import net.fabricmc.loader.api.FabricLoader;

public class QuickCoordsCopyConfig {

    private static final String FORMATTING_KEY = "formatting";

    final public static String DEFAULT_COPY_FORMAT = "$x $y $z";

    public static String copyFormat;

    public static void save() {
        File configFile = FabricLoader.getInstance().getConfigDir().resolve("quickcoordscopy.properties").toFile();

        try (Writer writer = new FileWriter(configFile)) {
            Properties properties = new Properties();
            properties.setProperty(FORMATTING_KEY, copyFormat);
            properties.store(writer, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void load() {
        File configFile = FabricLoader.getInstance().getConfigDir().resolve("quickcoordscopy.properties").toFile();
        if (!configFile.exists()) {
            try (Writer writer = new FileWriter(configFile)) {
                Properties properties = new Properties();
                properties.setProperty(FORMATTING_KEY, DEFAULT_COPY_FORMAT);
                properties.store(writer, null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (Reader reader = new FileReader(configFile)) {
            Properties properties = new Properties();
            properties.load(reader);
            copyFormat = properties.getProperty(FORMATTING_KEY, DEFAULT_COPY_FORMAT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IllegalStateException e) {
            save();
        }
    }
}
