package com.example.springmvcexample.mybatis.mapper;

import com.example.springmvcexample.mybatis.entity.Department;
import com.example.springmvcexample.mybatis.entity.Employee;
import com.example.springmvcexample.mybatis.entity.Job;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
public class EmployeeMapperTests {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private JobMapper jobMapper;
    // TRACE、DEBUG、INFO、WARN、ERROR
    private static final Logger logger = LoggerFactory.getLogger(EmployeeMapperTests.class);

    @Test
    public void testGetEmployee() throws Exception{
        logger.debug("{}",employeeMapper.getEmployee(170));
    }
    @Test
    public void testGetEmployees() throws Exception{
        for (Employee e: employeeMapper.getEmployees(80)
        ) {
            logger.debug("{}",e);
        }
    }@Test
    public void testGetAllEmployees() throws Exception{
        for (Employee e: employeeMapper.getAllEmployees()
             ) {
            logger.debug("{}",e);
        }
    }
    @Test
    public void testAddEmployee() throws Exception{
        Employee employee = new Employee();

        employee.setEmail("Test");
        employee.setSalary(2333.0);
        employee.setFirstName("Test");
        employee.setLastName("TestLastName");
        employee.setHireDate(Date.valueOf(LocalDate.now()));
        Department department = departmentMapper.getDepartment(40);
        employee.setDepartment(department);
        Job job = jobMapper.getJob("AD_VP");
        employee.setJob(job);
        int count = employeeMapper.addEmployee(employee);
        logger.debug("{}",count);
        logger.debug("{}",employee);


    }@Test
    public void testChgEmployee() throws Exception{
        Employee employee = employeeMapper.getEmployee(207);
        employee.setEmail("TestChg");
        int count = employeeMapper.chgEmployee(employee);
        logger.debug("{}",count);
        logger.debug("{}",employee);
    }
    @Test
    public void testDelEmployee() throws Exception{
        int count = employeeMapper.delEmployee(207);
        logger.debug("{}",count);
    }




}
