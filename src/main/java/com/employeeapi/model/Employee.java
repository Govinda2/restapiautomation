package com.employeeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Employee {

    public Employee() {
    }

    public Employee(long id, String employee_name, Double employee_salary, Float employee_age) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
    }

    private long id;
    @JsonProperty("employee_name")
    private String employee_name;

    @JsonProperty("employee_salary")
    private Double employee_salary;

    @JsonProperty("employee_age")
    private Float employee_age;

    public Employee(String employee_name, Double employee_salary, Float employee_age) {
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Float getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(Float employee_age) {
        this.employee_age = employee_age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + employee_name + '\'' +
                ", salary=" + employee_salary +
                ", age=" + employee_age +
                '}';
    }
}
