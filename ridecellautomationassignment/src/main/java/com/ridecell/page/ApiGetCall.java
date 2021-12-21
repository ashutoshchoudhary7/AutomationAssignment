package com.ridecell.page;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiGetCall {
	
	/**
	 * To make GET call.
	 * @param uri.
	 * @param resource.
	 * @return response.
	 */
	public static String get(String uri, String resource) {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(resource);
		String body = response.getBody().asString();
		return body;
	}
	
	/**
	 * To make a post call.
	 * @param uri
	 * @param requestParams
	 * @param insertionPoint
	 */
	public static void post(String uri, JSONObject requestParams, String insertionPoint) {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.body(requestParams.toString());
		Response response = httpRequest.post(insertionPoint);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "201");
	}
	
	/**
	 * To make a put call.
	 * @param uri
	 * @param requestParams
	 * @param insertionPoint
	 */
	public static void put(String uri, JSONObject requestParams, String insertionPoint) {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.body(requestParams.toString());
		Response response = httpRequest.post(insertionPoint);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "200");
	}

		
	/**
	 * Extract a given attribute.
	 * from the GET call.
	 * @param uri
	 * @return list of attribute values.
	 */
	public static List<String> getCall(String uri) {
		String response = get(uri, "/repos");	
		List<String> repoName = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(response);
		for (int i = 0; i < jsonArray.length(); i++) {
			if (jsonArray.get(i) instanceof JSONObject) {
				JSONObject jsnObj = (JSONObject) jsonArray.get(i);
				String finalValue = (String) jsnObj.get("name");
				repoName.add(finalValue);
			}
		}	
		return repoName;
	}

}
