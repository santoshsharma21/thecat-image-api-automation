/**
 * 
 */
package com.thecatapi.routes;

/**
 * @author Santosh Sharma
 *
 */
public class Endpoints {
	
	public static final String BASE_URL = "https://api.thecatapi.com/v1/";
	public static final String SEARCH_IMG = "images/search"; 
	public static final String SEARCH_SINGLE_IMG = "images/{img_id}";
	public static final String SEARCH_MY_UPLOAD_IMG = "images/";
	public static final String UPLOAD_IMG = "images/upload";
	public static final String UPLOAD_IMG_ANALYSIS = "images/{img_id}/analysis";
	public static final String DELETE_IMG = "images/{img_id}";
	
	// image paths
	public static final String CAT_IMAGE = System.getProperty("user.dir") + "/src/test/resources/images/cat.jpg";
	public static final String DOG_IMAGE = System.getProperty("user.dir") + "/src/test/resources/images/dog.jpg";
}
