package com.ridecell.automationassignment.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.ridecell.browserutils.BrowserUtils;
import com.ridecell.page.ApiGetCall;
import com.ridecell.page.HomePage;
import com.ridecell.page.RepoPage;
import com.ridecell.resources.ExtentManager;
import com.ridecell.resources.ExtentTestManager;
import com.ridecell.webutils.WebUtils;

//@Listeners({TestListener.class})
public class VerifyRepositoryNames extends BaseTest{
	
	@Test
	public void verifyWebAndRepositoryNames() throws Exception {
		HomePage gitHubPage = new HomePage(BrowserUtils.driver);
		RepoPage repoPage = new RepoPage(BrowserUtils.driver);
		BaseTest.test.log(Status.INFO, "Launching App");
		BrowserUtils.launchApp(BaseTest.properties.getProperty("url"));
		gitHubPage.clickOnRepository();
		BaseTest.test.log(Status.INFO, WebUtils.getScreenshot(BrowserUtils.getDriver(), "Extract Repositories name from web"));
		BaseTest.test.log(Status.INFO, "Extract Repositories name from web");
		List<String> webRepoList = repoPage.getListOfRepoName(BrowserUtils.driver);
		BaseTest.test.log(Status.INFO, "Extract Repositories name through API call");
		List<String> apiRepoList = ApiGetCall.getCall(BaseTest.properties.getProperty("apiUrl"));
		Collections.sort(webRepoList);
		Collections.sort(apiRepoList);
		BaseTest.test.log(Status.INFO, "Verify the repository names coming from web and API");
		assertEquals(webRepoList, apiRepoList);
	}

}
