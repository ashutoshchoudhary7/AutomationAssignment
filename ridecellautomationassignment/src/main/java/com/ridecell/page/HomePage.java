package com.ridecell.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.ridecell.resources.Log;

import io.qameta.allure.Step;

public class HomePage {	

	 private static final Logger Log =  LogManager.getLogger(HomePage.class);
	 
	@FindBy(xpath="//*[@*='org-header-repositories-tab']/a[@class='UnderlineNav-item ']")
	WebElement repository;
		
	public static String txtbox_searchbox="//*[@name='%replaceable%']";

	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Click on Repository link")
	public void clickOnRepository() {
		Log.info("Trying to navigate to repositories tab.");
		repository.click();
	}
	
}