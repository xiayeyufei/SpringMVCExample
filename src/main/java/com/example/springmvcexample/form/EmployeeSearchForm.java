package com.example.springmvcexample.form;

import com.example.springmvcexample.mybatis.entity.Department;
import com.example.springmvcexample.mybatis.entity.Job;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.sql.Date;
import java.time.LocalDate;

public class EmployeeSearchForm {
    @Size(min = 0, max = 6)
    private String first_name;
    @Size(min = 0, max = 6)
    private String last_name;
    @Size(min = 0, max = 6)
    private String email;
    private String phoneNumber;
    @Past(message = "{userSearchForm.startBirthday.error}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate starthiredate;
    @PastOrPresent(message = "{userSearchForm.endBirthday.error}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endhiredate;
    @Max(30000)
    @Min(0)
    @Digits(integer = 5, fraction = 2)
    private Double minSalary;

    public Double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(Double commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
    private Double commissionPct;
    private Integer managerId;
    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Max(30000)
    @Min(0)
    @Digits(integer = 5, fraction = 2)
    private Double maxSalary;
    public LocalDate getStarthiredate() {
        return starthiredate;
    }

    public void setStarthiredate(LocalDate starthiredate) {
        this.starthiredate = starthiredate;
    }

    public LocalDate getEndhiredate() {
        return endhiredate;
    }

    public void setEndhiredate(LocalDate endhiredate) {
        this.endhiredate = endhiredate;
    }

    private String job;
    private String departmentname;

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    private Paging paging=new Paging();

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
