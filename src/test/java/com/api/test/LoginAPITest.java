package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.utility.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginAPITest {

    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setupReport() {
        extent = ExtentReportManager.getInstance(); // Create report manager
    }

    @Test(description = "verify if Login API is working or not")
    public void loginTest() {
        test = extent.createTest("Login API Test"); // Start logging a test

        try {
            LoginRequest loginRequest = new LoginRequest("Rahul Shrimali", "Rahul$1234");
            AuthService authService = new AuthService();

            test.info("Sending login request with username and password");
            Response response = authService.login(loginRequest);  // Serialization
            test.info("Received response: " + response.asPrettyString());

            LoginResponse loginResponse = response.as(LoginResponse.class); // De-Serialization

            test.info("Extracted token: " + loginResponse.getToken());
            test.info("Extracted email: " + loginResponse.getEmail());
            test.info("Extracted ID: " + loginResponse.getId());


            Assert.assertNotNull(loginResponse.getToken());
            Assert.assertEquals(loginResponse.getEmail(), "rshrimali268@gmail.com");
            Assert.assertEquals(loginResponse.getUsername(), "Rahul Shrimali"); // use it end point

            test.pass("Login API test passed successfully");
            System.out.println(response.asPrettyString());

        } catch (AssertionError | Exception e) {
            test.fail("Login API test failed: " + e.getMessage());
            throw e;  // rethrow to make sure TestNG marks it as failed
        }
    }


    @AfterTest
    public void tearDownReport() {
        extent.flush();  // Save the report
    }
}
