package com.thecatapi.imagesapitests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.thecatapi.api.ImagesApi;
import com.thecatapi.routes.Endpoints;

import io.restassured.response.Response;

public class TC_DeleteImage {

	@Test(description = "Test should delete image")
	public void TC09_deleteImageById(ITestContext context) {
		String imageToDel = (String) context.getAttribute("myUploadedImgId");
		Response response = ImagesApi.deleteImage(Endpoints.DELETE_IMG, imageToDel);
		
		Assert.assertEquals(response.getStatusCode(), 204);
	}
}
