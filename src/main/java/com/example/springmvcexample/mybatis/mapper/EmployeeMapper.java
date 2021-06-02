package com.example.springmvcexample.mybatis.mapper;

import java.util.List;

import com.example.springmvcexample.mybatis.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface EmployeeMapper {
	public Employee getEmployee(Integer id);

	public List<Employee> getEmployees(Integer departmentId);

	public List<Employee> getAllEmployees();

	public int addEmployee(Employee employee);

	public int chgEmployee(Employee employee);

	public int delEmployee(Integer id);
	public List<Employee> findEmployees(@Param("orderBy") String[] orderBy,
										@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
}
