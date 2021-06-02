package com.example.springmvcexample.mybatis.mapper;

import com.example.springmvcexample.mybatis.entity.Department;
import com.example.springmvcexample.mybatis.entity.Location;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentMapperTests {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private LocationMapper locationMapper;

    // TRACE、DEBUG、INFO、WARN、ERROR
    private static final Logger logger = LoggerFactory.getLogger(DepartmentMapperTests.class);

    @Test
    public void testGetDepartment() throws Exception{
        logger.debug("{}",departmentMapper.getDepartment(130));
    }
    @Test
    public void testGetDepartments() throws Exception{
        for (Department d: departmentMapper.getDepartments(1700)
             ) {
            logger.debug("{}",d);
        }
    }@Test
    public void testGetAllDepartments() throws Exception{
        for (Department d: departmentMapper.getAllDepartments()
             ) {
            logger.debug("{}",d);
        }
    }
    @Test
    public void testAddDepartment() throws Exception{
        Department department = new Department();

        department.setName("Test");
        department.setManager(100);
        Location location = locationMapper.getLocation(1700);
        department.setLocation(location);
        int count = departmentMapper.addDepartment(department);
        logger.debug("{}",count);
        logger.debug("{}",department);
    }
    @Test
    public void testChgDepartment() throws Exception{
        Department department = departmentMapper.getDepartment(271);
        department.setName("TestChg");
        int count = departmentMapper.chgDepartment(department);
        logger.debug("{}",count);
        logger.debug("{}",department);
    }
    @Test
    public void testDelDepartment() throws Exception{
        int count = departmentMapper.delDepartment(271);
        logger.debug("{}",count);
    }

}
