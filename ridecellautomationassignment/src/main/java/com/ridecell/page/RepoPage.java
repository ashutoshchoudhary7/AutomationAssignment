package com.ridecell.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ridecell.resources.Log;


public class RepoPage {

	private static final Logger Log =  LogManager.getLogger(RepoPage.class);
	
	@FindBy(xpath="//*[@*='name codeRepository']")
	List<WebElement> repositoryList;
	
	public RepoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public List<String> getListOfRepoName(WebDriver driver) {
		Log.info("Capturing the list of repository names");
		List<String> webRepoName = new ArrayList<>();
		repositoryList.forEach(element -> webRepoName.add(element.getText()));
		webRepoName.forEach(repo -> System.out.println(repo));
		return webRepoName;
	}
	
}
