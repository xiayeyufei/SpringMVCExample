package com.example.springmvcexample.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springmvcexample.mybatis.entity.SalGrade;

@Mapper
public interface SalGradeMapper {
	public SalGrade getSalGrade(String gradeLevel);

	public List<SalGrade> getAllSalGrades();

	public int addSalGrade(@Param("gradeLevel") String gradeLevel, @Param("lowestSalary") Double lowestSalary,
			@Param("highestSalary") Double highestSalary);

	public int chgSalGrade(@Param("gradeLevel") String gradeLevel, @Param("lowestSalary") Double lowestSalary,
			@Param("highestSalary") Double highestSalary);

	public int delSalGrade(String gradeLevel);
}
