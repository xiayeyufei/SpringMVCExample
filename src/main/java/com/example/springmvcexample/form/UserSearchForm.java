package com.example.springmvcexample.form;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Arrays;

public class UserSearchForm {
    @Size(min = 0, max = 6)
    private String account;
    @Size(min = 0, max = 6)
    private String name;
    private String sex="男";
    @Past(message = "{userSearchForm.startBirthday.error}")
    @DateTimeFormat(pattern = "yyyy-M-d")
    private LocalDate startBirthday;
    @PastOrPresent(message = "{userSearchForm.endBirthday.error}")
    @DateTimeFormat(pattern = "yyyy-M-d")
    private LocalDate endBirthday;
    @Max(30000)
    @Min(0)
    @Digits(integer = 5, fraction = 2)
    private Double minSalary;
    @Max(30000)
    @Min(0)
    @Digits(integer = 5, fraction = 2)
    private Double maxSalary;
    private String[] authorities;
    private Paging paging = new Paging();

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    @Override
    public String toString() {
        return "UserSearchForm{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", startBirthday=" + startBirthday +
                ", endBirthday=" + endBirthday +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                ", authorities=" + Arrays.toString(authorities) +
                ", paging=" + paging +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getStartBirthday() {
        return startBirthday;
    }

    public void setStartBirthday(LocalDate startBirthday) {
        this.startBirthday = startBirthday;
    }

    public LocalDate getEndBirthday() {
        return endBirthday;
    }

    public void setEndBirthday(LocalDate endBirthday) {
        this.endBirthday = endBirthday;
    }

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

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }

}
