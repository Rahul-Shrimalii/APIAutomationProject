package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import com.api.utility.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpAPITest {

    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setupReport() {
        extent = ExtentReportManager.getInstance();
    }

    @Test(priority = 1, description = "Sign Up with a new user - should succeed")
    public void signUpWithNewUser() {
        test = extent.createTest("Sign Up API Test - New User");

        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .username("NewUser") // Ensure this username is unique
                .email("newuserr1@example.com")
                .firstName("Rahul")
                .password("Test@123")
                .lastName("Shrimali")
                .mobileNumber("9876543210")
                .build();

        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);

        test.info("Response:\n" + response.asPrettyString());

        int statusCode = response.getStatusCode();
        if (statusCode == 200 || statusCode == 201) {
            test.pass("Sign up successful. Status Code: " + statusCode);
        } else {
            test.fail("Sign up failed. Status Code: " + statusCode);
        }
    }

    @Test(priority = 2, description = "Sign Up with existing user - should fail")
    public void signUpWithExistingUser() {
        test = extent.createTest("Sign Up API Test - Existing User");

        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .username("Rahul_NewUser") // Same username as above
                .email("rahul.user@example.com")
                .firstName("Rahul")
                .password("Test@123")
                .lastName("Shrimali")
                .mobileNumber("9876543210")
                .build();

        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);

        test.info("Response:\n" + response.asPrettyString());

        int statusCode = response.getStatusCode();
        if (statusCode == 409 || statusCode == 400) {
            test.pass("Sign up failed as expected for existing user. Status Code: " + statusCode);
        } else {
            test.fail("Unexpected success for existing user. Status Code: " + statusCode);
        }
    }

    @AfterTest
    public void tearDownReport() {
        extent.flush();
    }
}
