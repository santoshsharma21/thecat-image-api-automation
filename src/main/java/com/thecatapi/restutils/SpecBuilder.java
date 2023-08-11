/**
 * 
 */
package com.thecatapi.restutils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * @author Santosh Sharma
 *
 */
public class SpecBuilder {
	
	public static RequestSpecification reqSpecBuilder(String url, boolean key) {
		RequestSpecBuilder spec = new RequestSpecBuilder();
		
		if(key == false) {
			spec.setBaseUri(url)
				.log(LogDetail.ALL);
		} else {
			spec.setBaseUri(url)
				.addHeader("x-api-key", "live_8HIFggSSZnGVuSHWbHYz7f3eN7CJEMPJccpPMyhd9PgfGRkyFrRtGiseDQ4ioJmu")
				.log(LogDetail.ALL);
		}
		RequestSpecification reqSpec = spec.build();
		return reqSpec;
	}
	
//	public static RequestSpecification reqSpecBuilder(String url) {
//		RequestSpecBuilder spec = new RequestSpecBuilder();
//		spec.setBaseUri(url)
//			.addHeader("x-api-key", "live_8HIFggSSZnGVuSHWbHYz7f3eN7CJEMPJccpPMyhd9PgfGRkyFrRtGiseDQ4ioJmu")
//			.log(LogDetail.ALL);
//		
//		RequestSpecification reqSpec = spec.build();
//		return reqSpec;
//	}
	
	public static ResponseSpecification resSpecBuilder() {
		ResponseSpecBuilder spec = new ResponseSpecBuilder();
		spec.log(LogDetail.ALL);
		
		ResponseSpecification resSpec = spec.build();
		return resSpec;
	}
}
