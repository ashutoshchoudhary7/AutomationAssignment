package com.ridecell.automationassignment.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.ridecell.automationassignment.ApiGetCall;
import com.ridecell.automationassignment.HomePage;
import com.ridecell.automationassignment.RepoPage;
import com.ridecell.automationassignment.BrowserUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

public class VerifyRepositoryNames extends BaseTest{
	
	@Test
	@Feature("Verify repository names coming from web application and API response")
	@Epic("Smoke Test")
	@Description("Test description: Match repo names")
	public void verifyWebAndRepositoryNames() {
		HomePage gitHubPage = new HomePage(BrowserUtils.driver);
		RepoPage repoPage = new RepoPage(BrowserUtils.driver);
		BrowserUtils.launchApp("https://github.com/orgs/django");
		gitHubPage.clickOnRepository();
		List<String> webRepoList = repoPage.getListOfRepoName(BrowserUtils.driver);
		List<String> apiRepoList = ApiGetCall.getCall("https://api.github.com/orgs/django");
		Collections.sort(webRepoList);
		Collections.sort(apiRepoList);
		assertEquals(webRepoList, apiRepoList);
	}

}
