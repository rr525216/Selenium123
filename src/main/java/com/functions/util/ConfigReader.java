package com.functions.util;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {

	public static Properties prop;

public static Map<String,Object> scenarioContext = new HashMap<>();
public static Map<String,Object> driver_name = new HashMap<>();
public static Map<String,Object> configValue = new HashMap<>();

	public static Properties init_prop() {

		prop = new Properties();
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

	public static void setValue(String key,String value){
		configValue.put(key,value);
	}

	public static String getValue(String key){
		return init_prop().get(key).toString();
	}

	public static void setScenarioContext(String key,Object value){
		scenarioContext.put(key,value);
	}

	public static Object getScenarioContext(String key){
		return scenarioContext.get(key);
	}

	public static boolean isContains(String key){
		return scenarioContext.containsKey(key);
	}

	public static void setDriver(String key, WebDriver value){

		driver_name.put(key,value);

	}
	public static WebDriver getDriver(String key){
		return (WebDriver) driver_name.get(key);
	}

}
