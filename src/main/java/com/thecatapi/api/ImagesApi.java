/**
 * 
 */
package com.thecatapi.api;

import com.thecatapi.restutils.RestRequest;

import io.restassured.response.Response;

/**
 * @author Santosh Sharma
 *
 */
public class ImagesApi {

	public static Response getImages(String endpoint, int limit, boolean key) {
		return RestRequest.get(endpoint, limit, key);
	}

	public static Response getImageById(String endpoint, String imgId) {
		return RestRequest.get(endpoint, imgId);
	}

	public static Response postImage(String endpoint, String imgPath, String imgSubId) {
		return RestRequest.post(endpoint, imgPath, imgSubId);
	}

	public static Response getMyUploadImage(String endpoint, int limit, boolean key) {
		return RestRequest.get(endpoint, limit, key);
	}
	
	public static Response deleteImage(String endpoint, String imageId) {
		return RestRequest.delete(endpoint, imageId);
	}
}
