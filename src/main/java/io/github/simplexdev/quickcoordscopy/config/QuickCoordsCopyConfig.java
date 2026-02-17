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
    
    private static final String SECONDARY_FORMATTING_KEY = "secondaryFormatting";
    final public static String DEFAULT_SECONDARY_COPY_FORMAT = "/tp @s $x $y $z $yaw $pitch";
    public static String secondaryCopyFormat;

    private static final String CONFIRMATION = "confirmation";
    final public static boolean DEFAULT_CONFIRMATION = true;
    public static boolean confirmation;

    private static final String CONFIRMATION_TYPE = "confirmationType";
    final public static boolean DEFAULT_CONFIRMATION_TYPE = false;
    public static boolean confirmationType;

    public static void save() {
        File configFile = FabricLoader.getInstance().getConfigDir().resolve("quickcoordscopy.properties").toFile();

        try (Writer writer = new FileWriter(configFile)) {
            Properties properties = new Properties();
            properties.setProperty(FORMATTING_KEY, copyFormat);
            properties.setProperty(SECONDARY_FORMATTING_KEY, secondaryCopyFormat);
            properties.setProperty(CONFIRMATION, String.valueOf(confirmation));
            properties.setProperty(CONFIRMATION_TYPE, String.valueOf(confirmationType));
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
                properties.setProperty(SECONDARY_FORMATTING_KEY, DEFAULT_SECONDARY_COPY_FORMAT);
                properties.setProperty(CONFIRMATION, String.valueOf(DEFAULT_CONFIRMATION));
                properties.setProperty(CONFIRMATION_TYPE, String.valueOf(DEFAULT_CONFIRMATION_TYPE));
                properties.store(writer, null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (Reader reader = new FileReader(configFile)) {
            Properties properties = new Properties();
            properties.load(reader);
            copyFormat = properties.getProperty(FORMATTING_KEY, DEFAULT_COPY_FORMAT);
            secondaryCopyFormat = properties.getProperty(SECONDARY_FORMATTING_KEY, DEFAULT_SECONDARY_COPY_FORMAT);
            confirmation = Boolean.parseBoolean(properties.getProperty(CONFIRMATION, String.valueOf(DEFAULT_CONFIRMATION)));
            confirmationType = Boolean.parseBoolean(properties.getProperty(CONFIRMATION_TYPE, String.valueOf(DEFAULT_CONFIRMATION_TYPE)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IllegalStateException e) {
            save();
        }
    }
}
