package com.zfnopCommerce.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {
	
	private static WebDriver driver = null;
	
	public static void getDriver(String browerName) {
		
		try {
			switch (browerName) {
			case "chrome":
				//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources/chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", "D://Drivers/chromedriver_win32/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//resources/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case "ie":
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//resources/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			default:
				break;		
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void openURL(String url){
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	
	public static WebDriver getDriverReference() {
		
		return driver;
	}
	
	/*
	 * This method used to close the current open window
	 */
	public static void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
	
	/*
	 * This method closes all Browser Windows associated with that driver and safely ends the session
	 */
	public static void closeAllBrowser() {
		driver.quit();
	}

	
}
