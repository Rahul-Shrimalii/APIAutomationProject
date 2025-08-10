package com.api.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    // Set Base URI
    // Create the request Specification
    // Handling the response

    public static final String BASE_URI = "http://64.227.160.186:8080";
    private RequestSpecification requestSpecification;

    public BaseService() {
        // it will initialize the instance variable
        requestSpecification = RestAssured.given().baseUri(BASE_URI); // given() we can remove it using static import
    }

    protected Response postRequest(Object payload, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint); // post method will return response


        // hardcoded part
//        RestAssured.given().baseUri("http://64.227.160.186:8080")
//                .contentType(ContentType.JSON)
//                .body("{\"username\":\"Rahul Shrimali\",\"password\":\"Rahul$1234\"}")
//                .when()
//                .post("/login");

    }

}
