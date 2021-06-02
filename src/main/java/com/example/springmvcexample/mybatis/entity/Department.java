package com.example.springmvcexample.mybatis.entity;

public class Department {
    Integer id;
    String name;
    Integer manager;
    Location location = new Location();

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

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + ", manager=" + manager + "]";
    }
}
