package com.thecatapi.imagesapitests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.thecatapi.api.ImagesApi;
import com.thecatapi.routes.Endpoints;

import io.restassured.response.Response;

public class TC_GetImageById {
	
	String imgid;
	
	@Test(description = "Test with correct image ID")
	void TC04_shouldReturnImg(ITestContext context) {
		imgid = (String) context.getAttribute("imageId");
		Response response = ImagesApi.getImageById(Endpoints.SEARCH_SINGLE_IMG, imgid);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("id"), imgid);
		Assert.assertEquals(response.jsonPath().getString("url").isBlank(), false);
	}
	
	@Test(description = "Test with incorrect image ID")
	void TC05_shouldNotReturnImg() {
		String incorrectId = imgid + "Abc";
		Response response = ImagesApi.getImageById(Endpoints.SEARCH_SINGLE_IMG, incorrectId);
		
		Assert.assertEquals(response.getStatusCode(), 400);
	}
}
