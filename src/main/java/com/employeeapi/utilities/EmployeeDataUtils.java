package com.employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class EmployeeDataUtils {

//    public static final String NAME = "Govinda";
//    public static final Double SALARY = 100000D;
//    public static final Float AGE = 31f;

    public static  String empName(){
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return ("Test_" + generatedString);
    }

    public  static  Double empSal(){
        Double generatedSal = Double.valueOf(RandomStringUtils.randomNumeric(3));
        return (generatedSal);
    }
    public  static  Float empAge(){
        Float generatedAge = Float.valueOf(RandomStringUtils.randomNumeric(2));
        return (generatedAge);
    }
}
