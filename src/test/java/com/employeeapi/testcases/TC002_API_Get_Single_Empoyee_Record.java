package com.employeeapi.testcases;

import com.employeeapi.base.TestBase;
import com.employeeapi.model.Employee;
import com.employeeapi.utilities.Constants;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC002_API_Get_Single_Empoyee_Record extends TestBase {
    Employee employee = null;
    private   Response response;
    private RequestSpecification httpRequest;

    @BeforeClass
    void getAllEmployeeData() {
        logger.info("************  Strated TC002_Get_Single_Empoyee_Record  ****************");
        RestAssured.baseURI = Constants.BASE_URL;
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/employee/" + empID);
        employee = response.getBody().as(Employee.class);
    }

    @Test
    void getAllEmployeeDataToTest() {
        logger.info("************  Strated TC002_Get_Single_Empoyee_Record  ****************");
        RestAssured.baseURI = Constants.BASE_URL;
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, Constants.BASE_URL);
        employee = response.getBody().as(Employee.class);
    }

    @Test
    void verifyEmployee(){
       Assert.assertNotNull(employee);
       Assert.assertEquals(employee.getEmployee_name(),"Govinda");
    }

    @Test
    void checkResponseBody() {
        logger.info("************  Checking response body ****************");
        ResponseBody responseBody = response.getBody();
        logger.info("Response Body ==> " + responseBody.asString());
        Assert.assertTrue(responseBody != null);
    }

    @Test
    void checkStatusCode() {
        logger.info("************  Checking status code  ****************");
        Assert.assertEquals(response.getStatusCode(), Constants.HTTP_SUCCESS_CODE);
    }

    @Test
    void checkResponseTime() {
        logger.info("************  Check response time  ****************");
        Assert.assertTrue(response.getTime() < Constants.MAX_RESPONSE_TIME);
    }

    @AfterClass
    void tearDown(){
        logger.info("************ End of TC002_Get_All_Employees  ****************");
    }

}
