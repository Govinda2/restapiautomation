package com.employeeapi.testcases;

import com.employeeapi.base.TestBase;
import com.employeeapi.model.Employee;
import com.employeeapi.utilities.Constants;
import com.sun.org.glassfish.gmbal.Description;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TC001_API_Get_All_Employees extends TestBase {
    private   Response response;
    private RequestSpecification httpRequest;

    @BeforeClass
    void getAllEmployees()  {
        logger.info("************  Strated TC001_Get_All_Employees  ****************");
        RestAssured.baseURI = Constants.BASE_URL;
        httpRequest = RestAssured.given().contentType("text/html");
        response = httpRequest.request(Method.GET,Constants.GET_URL);

        Employee[] employees = response.getBody().as(Employee[].class);
        Assert.assertTrue(employees.length > 0);
        for(Employee emp : employees){
            logger.info(emp.getEmployee_name());
        }
    }
    @Description("verify response body is not null")
    @Test
    void checkResponseBody() {
        logger.info("************  Checking response body ****************");
        ResponseBody responseBody = response.getBody();
        logger.info("Response Body ==> " + responseBody);
        Assert.assertTrue(responseBody != null);
    }

    @Description("Verify status code")
    @Test
    void checkStatusCode() {
        logger.info("************  Checking status code  ****************");
        Assert.assertEquals(response.getStatusCode(), Constants.HTTP_SUCCESS_CODE);
    }

    @Description("Verify response time")
    @Test
    void checkResponseTime() {
        logger.info("************  Check response time  ****************");
        Assert.assertTrue(response.getTime() < Constants.MAX_RESPONSE_TIME);
    }

    @Description("Negative Scneario - Checking for no response")
    @Test
    void checkForNoResponse() {
        Response NegResponse;
        logger.info("************  Checking no response ****************");
        NegResponse = httpRequest.request(Method.GET, "/IncorrectValue");
        String responseBody = NegResponse.getBody().asString();
        logger.info("NegResponse Body ==> " + responseBody);
        //Check for internal error
        Assert.assertTrue(responseBody.contains("FAULT_INTERNAL"));
    }
    @AfterClass
    void tearDown(){
        logger.info("************ End of TC001_Get_All_Employees  ****************");
    }
}


