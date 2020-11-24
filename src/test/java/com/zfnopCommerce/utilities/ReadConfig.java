package com.zfnopCommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	
	public ReadConfig() {
		File src = new File("./src/test/java/com/zfnopCommerce/conf/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);
		}
		catch(Exception e) {
			System.out.println("exception" + e);
		}
	}
	
	
	public String getAppURL() {
		String url = properties.getProperty("URL");
		return url;
	}
}
