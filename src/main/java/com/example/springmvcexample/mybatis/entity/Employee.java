package com.example.springmvcexample.mybatis.entity;

import java.sql.Date;

import com.example.springmvcexample.constraint.PhoneNumber;
import com.fasterxml.jackson.annotation.JsonView;

public class Employee {
    public interface EmployeeDetail {
    }

    Integer id;
    String firstName;
    String lastName;
    String email;
    @PhoneNumber
    String phoneNumber;
    Date hireDate;
    Job job = new Job();
    Double salary;
    Double commissionPct;
    Integer manager;
    Department department = new Department();

    @JsonView(EmployeeDetail.class)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonView(EmployeeDetail.class)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonView(EmployeeDetail.class)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonView(EmployeeDetail.class)
    public String getName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @JsonView(EmployeeDetail.class)
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(Double commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", job=" + job.getTitle() + ", salary="
                + salary + ", commissionPct=" + commissionPct + ", manager=" + manager + ", department="
                + (department != null ? department.getName() : null) + "]";
    }
}
