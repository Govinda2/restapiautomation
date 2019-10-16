package com.employeeapi.testcases;

import com.employeeapi.base.TestBase;
import com.employeeapi.model.Employee;
import com.employeeapi.utilities.Constants;
import com.employeeapi.utilities.EmployeeDataUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC005_API_Delete_Employee_Record extends TestBase {
   private RequestSpecification httpRequest;
    private Response response;

    @BeforeClass
    void createEmployee()  {
        logger.info("************  TC005_Put_Employee_Record  ****************");

        RestAssured.baseURI = Constants.BASE_URL;
        httpRequest = RestAssured.given();
        Employee newEmployee = new Employee(EmployeeDataUtils.empName(),EmployeeDataUtils.empSal(),EmployeeDataUtils.empAge());
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(newEmployee);

        response = httpRequest.request(Method.DELETE,"/delete/"+empID);
    }

    @Test
    void checkResponseBody() {
        logger.info("************  Checking response body ****************");
        String responseBody = response.getBody().asString();
        logger.info("Response Body ==> " + responseBody);
        Assert.assertEquals(responseBody.contains("successfully deleted records"),true);
    }

    @Test
    void checkStatusCode() {
        logger.info("************  Checking status code  ****************");
        int statusCode = response.getStatusCode();
        logger.info("Status Code  is  ==> " + statusCode);
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void checkResponseTime() {
        logger.info("************  Check response time  ****************");
        long responseTime = response.getTime();
        logger.info("Response time is  ==> " + responseTime);
        Assert.assertTrue(responseTime < 3000);
    }

    @AfterClass
    void tearDown(){
        logger.info("************ End of TC005_Post_Employee_Record  ****************");
    }
}
