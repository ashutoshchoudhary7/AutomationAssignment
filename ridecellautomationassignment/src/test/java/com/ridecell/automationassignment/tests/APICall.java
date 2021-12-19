package com.ridecell.automationassignment.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APICall {
//	private static Logger logger = LogManager.getLogger(APICall.class);

	public static List<String> getCall(String URL) {
		RestAssured.baseURI = URL;
		// Getting the RequestSpecification of the request
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/repos");
		String body = response.getBody().asString();
		System.out.println(body);
//		JSONObject obj = new JSONObject(body);
//		int repoLength = obj.length();
//		System.out.println(repoLength);
		List<String> repoName = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(body);
		for (int i = 0; i < jsonArray.length(); i++) {
			if (jsonArray.get(i) instanceof JSONObject) {
				JSONObject jsnObj = (JSONObject) jsonArray.get(i);
				String finalValue = (String) jsnObj.get("name");
//                System.out.println("NAME: "+ finalValue);
				repoName.add(finalValue);
			}
		}	
		System.out.println(repoName.size());
		repoName.forEach(repo -> System.out.println(repo));
		return repoName;
	}

	public static List<String> webCall() {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		// Navigate to the demoqa website
		driver.get("https://github.com/orgs/django");
		driver.findElement(By.xpath("//*[@*='org-header-repositories-tab']/a[@class='UnderlineNav-item ']")).click();
		List<WebElement> repoElement = driver.findElements(By.xpath("//*[@*='name codeRepository']"));
		List<String> webRepoName = new ArrayList<>();
		for (WebElement ele : repoElement) {
			webRepoName.add(ele.getText());
		}
		webRepoName.forEach(repo -> System.out.println(repo));
		driver.quit();
		return webRepoName;
	}

	public static void verifyResponse(List<String> apiRepoName, List<String> webRepoName) {
//		Assert.assertEquals(apiRepoName, webRepoName);
		Collections.sort(apiRepoName);
		Collections.sort(webRepoName);
		boolean isEqual = apiRepoName.equals(webRepoName); // false
		System.out.println("Verification: "+isEqual);
	}

	@Test
	public void verifyWepAndAPIResponse() {
		// TODO Auto-generated method stub
//		logger.trace("This is trace messages");
//		logger.info("This is information message");
//		logger.error("This is an error message");
//		logger.warn("This is a warning message");
//		logger.fatal("This is a fatal message");
		List<String> apiRepoName = APICall.getCall("https://api.github.com/orgs/django");
		List<String> webRepoName = APICall.webCall();
		APICall.verifyResponse(apiRepoName, webRepoName);

	}

}
