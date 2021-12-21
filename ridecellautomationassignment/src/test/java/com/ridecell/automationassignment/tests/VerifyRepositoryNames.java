package com.ridecell.automationassignment.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ridecell.browserutils.BrowserUtils;
import com.ridecell.page.ApiGetCall;
import com.ridecell.page.HomePage;
import com.ridecell.page.RepoPage;
import com.ridecell.webutils.WebUtils;

public class VerifyRepositoryNames extends BaseTest{
	
	HomePage gitHubPage;
	RepoPage repoPage;
	
	@BeforeTest
	public void initializePage() {
		gitHubPage = new HomePage(BrowserUtils.driver);
		repoPage = new RepoPage(BrowserUtils.driver);
		WebUtils.launchApp(BaseTest.properties.getProperty("url"));
	}
	
	@Test
	public void verifyWebAndRepositoryNames() throws Exception {
		gitHubPage.clickOnRepository();
		logger.pass("Clicked on Repository", MediaEntityBuilder.createScreenCaptureFromPath(WebUtils.getScreenshot(BrowserUtils.getDriver(), "GitRepoPage")).build());
		List<String> webRepoList = repoPage.getListOfRepoName(BrowserUtils.driver);
		logger.pass("Extracting Repository List", MediaEntityBuilder.createScreenCaptureFromPath(WebUtils.getScreenshot(BrowserUtils.getDriver(), "Repository Page")).build());
		List<String> apiRepoList = ApiGetCall.getCall(BaseTest.properties.getProperty("apiUrl"));
		logger.pass("Extracting Repository List using API GET call");
		Collections.sort(webRepoList);
		Collections.sort(apiRepoList);
		assertEquals(webRepoList, apiRepoList);
		logger.pass("Comparison Successful");
	}

}
