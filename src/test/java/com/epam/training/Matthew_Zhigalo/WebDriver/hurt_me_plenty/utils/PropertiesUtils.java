package com.epam.training.Matthew_Zhigalo.WebDriver.hurt_me_plenty.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    private static final String PROPERTY_PATH = "src/test/resources/model.properties";

    private static Properties properties;

    static {
        try (FileInputStream fileInputStream = new FileInputStream(String.format(PROPERTY_PATH))){
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getData(String key) {
        return properties.getProperty(key);
    }
}