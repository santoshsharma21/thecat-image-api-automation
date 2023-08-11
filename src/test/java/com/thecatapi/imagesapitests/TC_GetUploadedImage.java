package com.thecatapi.imagesapitests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.thecatapi.api.ImagesApi;
import com.thecatapi.routes.Endpoints;
import com.thecatapi.utilities.TestUtils;

import io.restassured.response.Response;

public class TC_GetUploadedImage {

	@Test(description = "Test should return uploaded image")
	public void TC08_getUploadedImage(ITestContext context) {
		Response response  = ImagesApi.getMyUploadImage(Endpoints.SEARCH_MY_UPLOAD_IMG, 0, true);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		String expectedId = (String) context.getAttribute("myUploadedImgId");
		Assert.assertEquals(TestUtils.getImageIdFromRes(response), expectedId);
	}
}
