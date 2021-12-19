package com.ridecell.automationassignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class HomePage {	

	@FindBy(xpath="//*[@*='org-header-repositories-tab']/a[@class='UnderlineNav-item ']")
	WebElement repository;
		
	public static String txtbox_searchbox="//*[@name='%replaceable%']";

	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Click on Repository link")
	public void clickOnRepository() {
		repository.click();
	}
	
}