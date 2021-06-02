package com.example.springmvcexample.contrller;

import com.example.springmvcexample.mybatis.entity.Employee;
import com.example.springmvcexample.mybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/example")
public class ExampleController_03 {

	@Autowired
	private EmployeeMapper employeeMapper;

	@GetMapping(path = "/test19RestController/{id}")
	public Employee test19RestController(@PathVariable Integer id) {
		return employeeMapper.getEmployee(id);
	}
}
