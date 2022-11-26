package com.bsu.test_automation_framework_github;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
    public static Properties readProperties() {
        try (InputStream input = Util.class.getClassLoader().getResourceAsStream("config.properties")) {

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
}
