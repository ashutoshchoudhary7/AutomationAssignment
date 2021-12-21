package com.ridecell.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepoPage {
	
	@FindBy(xpath="//*[@*='name codeRepository']")
	List<WebElement> repositoryList;
	
	public RepoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Get list of repository names.
	 * @param driver.
	 * @return list of repository name.
	 */
	public List<String> getListOfRepoName(WebDriver driver) {
		List<String> webRepoName = new ArrayList<>();
		repositoryList.forEach(element -> webRepoName.add(element.getText()));
		webRepoName.forEach(repo -> System.out.println(repo));
		return webRepoName;
	}
	
}
