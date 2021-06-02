package com.example.springmvcexample.mybatis.mapper;

import com.example.springmvcexample.mybatis.entity.Country;
import com.example.springmvcexample.mybatis.entity.Employee;
import com.example.springmvcexample.mybatis.entity.Job;
import com.example.springmvcexample.mybatis.entity.Region;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JobMapperTests {
    @Autowired
    private JobMapper jobMapper;
    // TRACE、DEBUG、INFO、WARN、ERROR
    private static final Logger logger = LoggerFactory.getLogger(JobMapperTests.class);
    @Test
    public void testGetAllJobs() throws Exception {

        for (Job j: jobMapper.getAllJobs()
             ) {
            logger.debug("{}",j);
            for (Employee e: j.getEmployees()
                 ) {
                logger.debug("\t{}\t",e);
            }
        }
    }
    @Test
    public void testGetJob() throws Exception{
        logger.debug("{}",jobMapper.getJob("AC_MGR"));
    }
    @Test
    public void testAddJob() throws Exception{
        Job job = new Job();
        job.setId("Test");
        job.setTitle("TestTitle");
        job.setMaxSalary(20000.0);
        job.setMinSalary(10000.0);
        int count = jobMapper.addJob(job);
        logger.debug("{}",count);
        logger.debug("{}",job);

    }
    @Test
    public void testChgJob() throws Exception{
        Job job = jobMapper.getJob("Test");
        job.setTitle("changeTest");
        int count = jobMapper.chgJob(job);
        logger.debug("{}",count);
        logger.debug("{}",job);
    }
    @Test
    public void testDelJob() throws Exception{
        int count = jobMapper.delJob("Test");
        logger.debug("{}",count);

    }





}
