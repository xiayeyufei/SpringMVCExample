package com.example.springmvcexample.mybatis.entity;

import java.util.List;

public class Region {
	 Integer id;
	 String name;
	 List<Country> countries;
	 public Integer getId() {
	  return id;
	 }

	 public void setId(Integer id) {
	  this.id = id;
	 }

	 public String getName() {
	  return name;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }
	 public List<Country> getCountries() {
		  return countries;
		 }

	public void setCountries(List<Country> countries) {
		  this.countries = countries;
	}
	 @Override
	 public String toString() {
	  return "Region [id=" + id + ", name=" + name + "]";
	 }
	}