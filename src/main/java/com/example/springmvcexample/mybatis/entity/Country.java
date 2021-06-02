package com.example.springmvcexample.mybatis.entity;

import java.util.List;

public class Country {
	String id;
	 String name;
	 Region region = new Region();

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	List<Location> locations;

	 public String getId() {
	  return id;
	 }

	 public void setId(String id) {
	  this.id = id;
	 }

	 public String getName() {
	  return name;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }

	 public Region getRegion() {
	  return region;
	 }

	 public void setRegion(Region region) {
	  this.region = region;
	 }
	public List<Location> getLocations() {
		return locations;
	}

	 @Override
	 public String toString() {
	  return "Country [id=" + id + ", name=" + name + "]";
	 }


}
