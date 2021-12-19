package com.ridecell.automationassignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;

public class BrowserUtils {

	public static WebDriver driver = null;
	public static int defaultBrowserTimeOut = 30;

	public static WebDriver launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	@Step("Lauch given application URL")
	public static void launchApp(String url) {
		BrowserUtils.getDriver().get(url);		
	}

}
