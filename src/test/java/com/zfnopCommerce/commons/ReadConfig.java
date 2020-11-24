package com.zfnopCommerce.commons;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	private static Properties properties;  
	
	public ReadConfig() {
		File src = new File("./src/test/java/com/zfnopCommerce/conf/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getUrl() {
		return properties.getProperty("URL");
	}
}
