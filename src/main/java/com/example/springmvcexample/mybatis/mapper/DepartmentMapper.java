package com.example.springmvcexample.mybatis.mapper;

import java.util.List;

import com.example.springmvcexample.mybatis.entity.Department;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface DepartmentMapper {
	public Department getDepartment(Integer id);

	public List<Department> getDepartments(Integer locationId);

	public List<Department> getAllDepartments();

	public int addDepartment(Department department);

	public int chgDepartment(Department department);

	public int delDepartment(Integer id);
}
