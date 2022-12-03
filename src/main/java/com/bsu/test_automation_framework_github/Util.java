package com.bsu.test_automation_framework_github;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

public class Util {
    public static Properties readProperties() {
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {

            Properties properties = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return null;
            }
            properties.load(input);
            return properties;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String generateRandomName() {
        return UUID.randomUUID().toString();
    }

    public static String generateRandomNameOfLength(int length) {
        return generateRandomName().substring(0, length);
    }
}

