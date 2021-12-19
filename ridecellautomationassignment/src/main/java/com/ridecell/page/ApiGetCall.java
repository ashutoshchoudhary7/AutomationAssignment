package com.ridecell.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiGetCall {
	
	private static final Logger Log =  LogManager.getLogger(ApiGetCall.class);
	
	public static List<String> getCall(String URL) {
		RestAssured.baseURI = URL;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/repos");
		String body = response.getBody().asString();
		System.out.println(body);
		List<String> repoName = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(body);
		for (int i = 0; i < jsonArray.length(); i++) {
			if (jsonArray.get(i) instanceof JSONObject) {
				JSONObject jsnObj = (JSONObject) jsonArray.get(i);
				String finalValue = (String) jsnObj.get("name");
				repoName.add(finalValue);
			}
		}	
		Log.info("Repository Size: " + repoName.size());
		repoName.forEach(repo -> Log.info(repo));
		return repoName;
	}

}
