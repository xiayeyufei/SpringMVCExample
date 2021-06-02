package com.example.springmvcexample.mybatis.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class User {
	 private long id;
	 private String account = "";
	 private String password;
	 private String confirmPassword;
	 private String name;
	 private String sex = "男";
	 private LocalDate birthday = LocalDate.now();
	 private double salary;
	 private String[] authorities;

	 public long getId() {
	  return id;
	 }

	 public void setId(long id) {
	  this.id = id;
	 }

	 public String getAccount() {
	  return account;
	 }

	 public void setAccount(String account) {
	  this.account = account;
	 }

	 public String getPassword() {
	  return password;
	 }

	 public void setPassword(String password) {
	  this.password = password;
	 }

	 public String getConfirmPassword() {
	  return confirmPassword;
	 }

	 public void setConfirmPassword(String confirmPassword) {
	  this.confirmPassword = confirmPassword;
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

	 public LocalDate getBirthday() {
	  return birthday;
	 }

	 public void setBirthday(LocalDate birthday) {
	  this.birthday = birthday;
	 }

	 public double getSalary() {
	  return salary;
	 }

	 public void setSalary(double salary) {
	  this.salary = salary;
	 }

	 public String[] getAuthorities() {
	  return authorities;
	 }

	 public void setAuthorities(String[] hobbies) {
	  this.authorities = hobbies;
	 }

	 @Override
	 public String toString() {
	  return "User [id=" + id + ", account=" + account + ", password=" + password + ", confirmPassword="
	    + confirmPassword + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", salary=" + salary
	    + ", authorities=" + Arrays.toString(authorities) + "]";
	 }
}
