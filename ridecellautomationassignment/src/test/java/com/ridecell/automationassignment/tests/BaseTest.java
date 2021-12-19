package com.ridecell.automationassignment.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.ridecell.automationassignment.BrowserUtils;

public class BaseTest {
	
	@BeforeMethod
	public WebDriver setUp() {
		return BrowserUtils.launchBrowser("chrome");
	}

	@AfterTest
	public void wrapUp() {
		WebDriver driver = BrowserUtils.getDriver();
		driver.close();
	}

}
