/**
 * 
 */
package com.thecatapi.utilities;

import org.json.JSONArray;

import io.restassured.response.Response;

/**
 * @author Santosh Sharma
 *
 */
public class TestUtils {
	
	public static int getTotalImages(Response response) {
		JSONArray jArray = new JSONArray(response.asString());
		return jArray.length();
	}
	
	public static boolean isResponseObjEmpty(Response response) {
		JSONArray jArray = new JSONArray(response.asString());
		boolean status = false;
		for(int i=0; i<jArray.length(); i++) {
			if(jArray.getJSONObject(i).isEmpty()) {
				status = true;
				break;
			}
		}
		return status;
	}
	
	public static String getImageIdFromRes(Response response) {
		JSONArray jArray = new JSONArray(response.asString());
		String imgId = jArray.getJSONObject(0).getString("id");
		return imgId;
	}

}
