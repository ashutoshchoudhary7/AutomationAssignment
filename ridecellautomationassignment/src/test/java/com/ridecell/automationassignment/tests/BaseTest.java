package com.ridecell.automationassignment.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ridecell.browserutils.BrowserUtils;
import com.ridecell.page.HomePage;
import com.ridecell.page.RepoPage;

public class BaseTest {
	
	public static ExtentTest logger;
	public static ExtentReports extent;
	public static Properties properties;

	@BeforeSuite
	public static WebDriver startTest() throws IOException  {
		ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir") + "/extent-reports");
	    extent = new ExtentReports();
	    extent.attachReporter(reporter);
	    logger = extent.createTest("GithubTest");
		properties = new Properties();
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Configuration.properties/"));
		properties.load(reader);
		reader.close();
		return BrowserUtils.launchBrowser(properties.getProperty("browser"));
	}

	@AfterClass
	public void wrapUp() {
		BrowserUtils.getDriver().quit();
		extent.flush();
	}

}
