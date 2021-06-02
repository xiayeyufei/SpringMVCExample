package com.example.springmvcexample.mybatis.entity;

public class SalGrade {
	String gradeLevel;
	Double lowestSalary;
	Double highestSalary;

	public String getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public Double getLowestSalary() {
		return lowestSalary;
	}

	public void setLowestSalary(Double lowestSalary) {
		this.lowestSalary = lowestSalary;
	}

	public Double getHighestSalary() {
		return highestSalary;
	}

	public void setHighestSalary(Double highestSalary) {
		this.highestSalary = highestSalary;
	}

	@Override
	public String toString() {
		return "SalGrade [gradeLevel=" + gradeLevel + ", lowestSalary=" + lowestSalary + ", highestSalary="
				+ highestSalary + "]";
	}
}
