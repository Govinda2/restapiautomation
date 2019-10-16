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

public class TC004_API_Put_Employee_Record extends TestBase {

    private RequestSpecification httpRequest;
    private Response response;

    String empName = EmployeeDataUtils.empName();
    Double empSalary = EmployeeDataUtils.empSal() ;
    Float empAge = EmployeeDataUtils.empAge();

    @BeforeClass
    void createEmployee()  {
        logger.info("************  Strated TC003_Post_Employee_Record  ****************");
        RestAssured.baseURI = Constants.BASE_URL;
        httpRequest = RestAssured.given();
        Employee newEmployee = new Employee(empName,empSalary,empAge);
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(newEmployee);

        response = httpRequest.request(Method.PUT, "/update/"+empID);
    }
    @Test
    void checkResponseBody() {
        Employee newEmployee = null;
        logger.info("************  Checking response body ****************");
        if (response.getBody() != null){
            newEmployee = response.getBody().as(Employee.class);
            String responseBody = response.getBody().asString();
            logger.info("Response Body ==> " + newEmployee.toString());
            Assert.assertEquals(newEmployee.getEmployee_name(),EmployeeDataUtils.empName());
            Assert.assertEquals(newEmployee.getEmployee_salary(),EmployeeDataUtils.empSal());
            Assert.assertEquals(newEmployee.getEmployee_age(),EmployeeDataUtils.empAge());
        }else{
            Assert.assertNotNull(response.getBody());
        }
    }

    @Test
    void checkStatusCode() {
        logger.info("************  Checking status code  ****************");
        Assert.assertEquals(response.statusCode(), Constants.HTTP_SUCCESS_CODE);
    }

    @Test
    void checkResponseTime() {
        logger.info("************  Check response time  ****************");
        Assert.assertTrue(response.getTime() < Constants.MAX_RESPONSE_TIME);
    }

    @Test
    void checkContentType() {
        logger.info("************  Check for Content Type    ****************");
        Assert.assertEquals(response.header("Content-Type"), "text/html");
    }

    @AfterClass
    void tearDown(){
        logger.info("************ End of TC003_Post_Employee_Record  ****************");
    }

}
