package com.functions.util;


import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.*;

public class ConfigReader {

    public static Properties prop;

    public static Map<String, Object> scenarioContext = new HashMap<>();
    public static Map<String, Object> driver_name = new HashMap<>();
    public static Map<String, Object> configValue = new HashMap<>();
    public static Map<String, Object> config = new HashMap<>();


    private static ConfigReader configReader = null;

    public ConfigReader() {
    }

    public static ConfigReader getInstance() {

        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }


    public static ThreadLocal<HashMap<String, Object>> dynamicConfigs = new ThreadLocal<HashMap<String, Object>>() {
        @Override
        protected HashMap<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }
    };

    public static ThreadLocal<HashMap<String, Object>> dynamicdriver = new ThreadLocal<HashMap<String, Object>>() {
        @Override
        protected HashMap<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }
    };

    public static ThreadLocal<HashMap<String, Object>> cofigget = new ThreadLocal<HashMap<String, Object>>() {
        @Override
        protected HashMap<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }
    };

    public static Properties init_prop() {

        Properties prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;

    }

    public  String getValue(String key) {
        String get = init_prop().get(key).toString();
        return get;
    }

    public void setValue(String key, String value) {
        configValue.put(key, value);
    }




//    public static void setDriver(String key, WebDriver value) {
//
//        driver_name.put(key, value);
//
//    }
//
//    public static WebDriver getDriver(String key) {
//        return (WebDriver) driver_name.get(key);
//    }


    public static void setConfigValue(String key, String value) {
        config.put(key, value);
    }

    public static String getConfigValue(String key) {
        return (String) config.get(key);
    }


//    public static void setScenarioContext(String key, Object value) {
//        scenarioContext.put(key, value);
//    }


    public static void setScenarioContext(String key, Object value) {
        dynamicConfigs.get().put(key, value);

    }

    public static Object getScenarioContext(String key) {
        return dynamicConfigs.get().get(key);

    }

    public static boolean isContains(String key) {

        return dynamicConfigs.get().containsKey(key);
    }


    public static void setDriver(String key, WebDriver value) {

        dynamicdriver.get().put(key, value);

    }

    public static WebDriver getDriver(String key) {
        return (WebDriver) dynamicdriver.get().get(key);
    }

}
