package com.ridecell.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ridecell.webutils.WebUtils;

public class HomePage {	
	 
	@FindBy(xpath="//*[@*='org-header-repositories-tab']/a[@class='UnderlineNav-item ']")
	WebElement repository;
		
	public static String txtbox_searchbox="//*[@name='%replaceable%']";

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Click on Repository Button.
	 */
	public void clickOnRepository() {
		WebUtils.click(repository);
	}
	
}