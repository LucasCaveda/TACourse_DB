package com.solvd.dao.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBProperties {
    private final static Logger LOGGER = LogManager.getLogger(DBProperties.class);

    private static Properties properties = new Properties();
    private static DBProperties dbProperties = new DBProperties();

    private DBProperties() {
        try {
            properties.load(new FileReader("src/main/resources/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getString(String key){
        return properties.getProperty(key);
    }

    public static int getInt(String key){
        return Integer.parseInt(properties.getProperty(key));
    }
}
