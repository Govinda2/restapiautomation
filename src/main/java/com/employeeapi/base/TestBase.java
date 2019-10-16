package com.employeeapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public String empID="719"; //Hard coded as of now get to get details of single employee and update employee
    public Logger logger;

    @BeforeClass
    public void setup(){

        logger = Logger.getLogger("EmployeeRestApi"); // added logger
        PropertyConfigurator.configure("Log4j.properties");
        logger.setLevel(Level.DEBUG);
    }
}
