package com.ridecell.browserutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtils {
	
	private static Logger tesLogger = 	(Logger) LogManager.getLogger(BrowserUtils.class);

	public static WebDriver driver = null;

	/**
	 * To launch a browser.
	 * @param browserName
	 * @return webdriver instance.
	 */
	public static WebDriver launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tesLogger.info("Launching Chrome Browser");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			tesLogger.info("Launching firefox Browser");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			tesLogger.info("Launching edge Browser");
			driver = new EdgeDriver();
		} 
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}
	
	/**
	 * @return instance of webdriver.
	 */
	public static WebDriver getDriver() {
		return driver;
	}

}
