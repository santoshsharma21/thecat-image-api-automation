package com.thecatapi.imagesapitests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.thecatapi.api.ImagesApi;
import com.thecatapi.routes.Endpoints;

import io.restassured.response.Response;

public class TC_UploadImage {

	@Test(description = "Test with vaild cat image")
	public void TC06_shouldAbleToUploadImage(ITestContext context) {
		Response response = ImagesApi.postImage(Endpoints.UPLOAD_IMG, Endpoints.CAT_IMAGE, "my_cat_upload");
		
		// get and store image id
		String myUploadImgId = response.jsonPath().getString("id");
		context.setAttribute("myUploadedImgId", myUploadImgId);
		
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(response.jsonPath().getString("original_filename"), "cat.jpg");
		Assert.assertEquals(response.jsonPath().getString("sub_id"), "my_cat_upload");
	}
	
	@Test(description = "Test with invalid image")
	public void TC07_shouldNotAbleToUploadImage() {
		Response response = ImagesApi.postImage(Endpoints.UPLOAD_IMG, Endpoints.DOG_IMAGE, "my_dog_upload");
		
		Assert.assertEquals(response.getStatusCode(), 400);
	}
}
