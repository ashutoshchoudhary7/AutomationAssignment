package com.ridecell.automationassignment.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ridecell.browserutils.BrowserUtils;
import com.ridecell.page.HomePage;
import com.ridecell.page.RepoPage;
import com.ridecell.resources.ExtentManager;

public class BaseTest {
	
	public static ExtentTest test;
	public static ExtentReports report;
	public static Properties properties;
	
	@BeforeClass
	public static WebDriver startTest() throws IOException  {
		report = ExtentManager.getExtentReports();
		test = report.createTest("Verify Repository Name");
		properties = new Properties();
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Configuration.properties/"));
		properties.load(reader);
		reader.close();
		return BrowserUtils.launchBrowser(properties.getProperty("browser"));
	}

	@AfterClass
	public void wrapUp() {
		WebDriver driver = BrowserUtils.getDriver();
		driver.quit();
		report.flush();
	}

}
