package com.example.springmvcexample.mybatis.mapper;

import com.example.springmvcexample.mybatis.entity.Department;
import com.example.springmvcexample.mybatis.entity.Employee;
import com.example.springmvcexample.mybatis.entity.Job;
import com.example.springmvcexample.mybatis.entity.JobHistory;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Action;
import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
public class JobHistoryMapperTests {
    @Autowired
    private JobHistoryMapper jobHistoryMapper;

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    // TRACE、DEBUG、INFO、WARN、ERROR
    private static final Logger logger = LoggerFactory.getLogger(JobHistoryMapperTests.class);

    @Test
    public void testGetJobHistory() throws Exception{
        logger.debug("{}",jobHistoryMapper.getJobHistory(3));
    }
    @Test
    public void testGetAllJobHistories() throws Exception{
        for (JobHistory jh: jobHistoryMapper.getAllJobHistories()
             ) {
            logger.debug("{}",jh);
        }
    }@Test
    public void testAddJobHistory() throws Exception{
        JobHistory jobHistory = new JobHistory();

        Employee employee = employeeMapper.getEmployee(178);
        Job job = jobMapper.getJob("AD_PRES");
        Department department = departmentMapper.getDepartment(110);
        jobHistory.setJob(job);
        jobHistory.setDepartment(department);
        jobHistory.setEmployee(employee);
        jobHistory.setEndDate(Date.valueOf(LocalDate.now()));
        jobHistory.setStartDate(Date.valueOf(LocalDate.now()));
        int count = jobHistoryMapper.addJobHistory(jobHistory);
        logger.debug("{}",count);
        logger.debug("{}",jobHistory);
    }@Test
    public void testChgJobHistory() throws Exception{
        JobHistory jobHistory = jobHistoryMapper.getJobHistory(10);
        jobHistory.setEndDate(Date.valueOf(LocalDate.now()));
        int count = jobHistoryMapper.chgJobHistory(jobHistory);
        logger.debug("{}",count);
        logger.debug("{}",jobHistory);
    }
    @Test
    public void testDelJobHistory() throws Exception{
        int count = jobHistoryMapper.delJobHistory(11);
        logger.debug("{}",count);

    }


}
