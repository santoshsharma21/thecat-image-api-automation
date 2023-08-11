/**
 * 
 */
package com.thecatapi.imagesapitests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.thecatapi.api.ImagesApi;
import com.thecatapi.routes.Endpoints;
import com.thecatapi.utilities.TestUtils;

import io.restassured.response.Response;

/**
 * @author Santosh Sharma
 *
 */
public class TC_GetImages {
	
	@Test(description = "Test without api-key, should return image")
	void TC01_getImages(ITestContext context) {
		
		Response response = ImagesApi.getImages(Endpoints.SEARCH_IMG, 0, false);
		
		// get and store image id from response object
		String id = TestUtils.getImageIdFromRes(response);
		context.setAttribute("imageId", id);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(TestUtils.isResponseObjEmpty(response), false);
	}
	
	@Test(description = "Test with limit parameter and without api-key parameter, should not return more than 10 images")
	void TC02_shouldNotReturnMoreThan10Images() {
		Response response = ImagesApi.getImages(Endpoints.SEARCH_IMG, 11, false);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(TestUtils.getTotalImages(response) <= 10);
	}
	
	@Test(description = "Test with limit and api-key parameter, should return more than 10 images")
	void TC03_shouldReturnMoreThan10Images() {
		Response response = ImagesApi.getImages(Endpoints.SEARCH_IMG, 15, true);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(TestUtils.getTotalImages(response) > 10);
	}

}
