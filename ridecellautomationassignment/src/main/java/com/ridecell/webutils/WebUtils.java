package com.ridecell.webutils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ridecell.browserutils.BrowserUtils;

public class WebUtils {

	/**
	 * To take screenshot.
	 * 
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws Exception
	 */
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	/**
	 * To launch given URL in browser.
	 * 
	 * @param url.
	 */
	public static void launchApp(String url) {
		BrowserUtils.getDriver().get(url);
	}

	/**
	 * To highlight the given webelement.
	 * 
	 * @param element
	 */
	private static void highlightElement(WebElement element) {
		((JavascriptExecutor) BrowserUtils.getDriver()).executeScript("arguments[0].style.border='3px solid red'",
				element);
	}

	/**
	 * To click on the element.
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		highlightElement(element);
		element.click();
	}

	/**
	 * To pass value to input field using webelement
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendkeys(WebElement element, String text) {
		highlightElement(element);
		element.sendKeys(text);
	}

	/**
	 * To pass value to input field using By locator.
	 * 
	 * @param by
	 * @param text
	 */
	public static void sendkeys(By by, String text) {
		sendkeys(BrowserUtils.getDriver().findElement(by), text);
	}

	/**
	 * To move to given. web element.
	 * 
	 * @param element
	 */
	public static void moveToElement(WebElement element) {
		Actions actions = new Actions(BrowserUtils.getDriver());
		actions.moveToElement(element).build().perform();
	}

	public static void moveToElement(By by) {
		moveToElement(BrowserUtils.getDriver().findElement(by));
	}

	/**
	 * To switch to new window.
	 */
	public static void switchToNewWindow() {
		String parentWinHandle = BrowserUtils.getDriver().getWindowHandle();
		Set<String> winHandles = BrowserUtils.getDriver().getWindowHandles();
		for (String temp : winHandles) {
			if (!temp.equalsIgnoreCase(parentWinHandle)) {
				BrowserUtils.getDriver().switchTo().window(temp);
			}
		}
	}

	/**
	 * To select value from. dropdown using value.
	 * 
	 * @param element
	 * @param text
	 */
	public static void selectByValue(WebElement element, String text) {
		new Select(element).selectByValue(text);
	}

	/**
	 * To select value from. dropdown using text.
	 * 
	 * @param element
	 * @param text
	 */
	public static void selectByVisibleText(WebElement element, String text) {
		new Select(element).selectByVisibleText(text);
	}

	/**
	 * To select value from. drop down using index.
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}
}
