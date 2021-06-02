package com.example.springmvcexample.mybatis.entity;

import java.sql.Date;

public class JobHistory {
	Integer id;
	Employee employee = new Employee();
	Date startDate;
	Date endDate;
	Job job = new Job();
	Department department = new Department();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "JobHistory [id=" + id + ", employee=" + employee.getName() + ", startDate=" + startDate + ", endDate="
				+ endDate + ", job=" + job.getTitle() + ", department=" + department.getName() + "]";
	}

}
