/**
 * 
 */
package com.thecatapi.restutils;

import java.io.File;

import com.thecatapi.routes.Endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * @author Santosh Sharma
 *
 */
public class RestRequest {
	
	// GET request
	public static Response get(String endpoint, int limit, boolean key) {
		RequestSpecification reqSpec = SpecBuilder.reqSpecBuilder(Endpoints.BASE_URL, key);
		ResponseSpecification resSpec = SpecBuilder.resSpecBuilder();
		
		Response response = null;
		if(limit > 0) {
			response = RestAssured.given().spec(reqSpec).contentType(ContentType.JSON).queryParam("limit", limit)
						.when().get(endpoint)
						.then().spec(resSpec).log().all().extract().response();
			
		} else if(limit == 0) {
			response = RestAssured.given().spec(reqSpec).contentType(ContentType.JSON)
					.when().get(endpoint)
					.then().spec(resSpec).log().all().extract().response();
		}
		return response;	
	}
	
	public static Response get(String endpoint, String imgId) {
		RequestSpecification reqSpec = SpecBuilder.reqSpecBuilder(Endpoints.BASE_URL, true);
		ResponseSpecification resSpec = SpecBuilder.resSpecBuilder();
		
		Response response = RestAssured.given().spec(reqSpec)
			.contentType(ContentType.JSON)
			.pathParam("img_id", imgId)
		
		.when()
			.get(endpoint)
		
		.then().spec(resSpec)
			.log().all().extract().response();
		
		return response;	
	}
	
	// POST Request
	public static Response post(String endpoint, String filePath, String subId) {
		RequestSpecification reqSpec = SpecBuilder.reqSpecBuilder(Endpoints.BASE_URL, true);
		ResponseSpecification resSpec = SpecBuilder.resSpecBuilder();
		
		File upload = new File(filePath);
		
		Response response = RestAssured.given().spec(reqSpec)
			.contentType(ContentType.MULTIPART)
			.multiPart("file", upload, "image/png")
			.formParam("sub_id", subId)
		
		.when()
			.post(endpoint)
		
		.then().spec(resSpec)
			.log().all().extract().response();
		
		return response;	
	}
	
	
	// DELETE Request
	public static Response delete(String endpoint, String imgId) {
		RequestSpecification reqSpec = SpecBuilder.reqSpecBuilder(Endpoints.BASE_URL, true);
		ResponseSpecification resSpec = SpecBuilder.resSpecBuilder();
		
		Response response = RestAssured.given().spec(reqSpec)
					.contentType(ContentType.JSON)
					.pathParam("img_id", imgId)
		
				.when()
					.delete(endpoint)
		
				.then().spec(resSpec)
					.log().all().extract().response();
		
		return response;	
	}
}
