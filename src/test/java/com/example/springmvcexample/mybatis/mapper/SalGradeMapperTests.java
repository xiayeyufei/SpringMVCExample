package com.example.springmvcexample.mybatis.mapper;

import com.example.springmvcexample.mybatis.entity.SalGrade;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SalGradeMapperTests {
    @Autowired
    private SalGradeMapper salGradeMapper;
    // TRACE、DEBUG、INFO、WARN、ERROR
    private static final Logger logger = LoggerFactory.getLogger(RegionMapperTests.class);
    @Test
    public void testGetSalGrade() throws Exception {
        logger.debug("{}", salGradeMapper.getSalGrade("L1"));
    }
    @Test
    public void testAddSalGrade() throws Exception{

        int count = salGradeMapper.addSalGrade("L8",10000.0,20000.0);
        logger.debug("{}",count);
    }
    @Test
    public void testChgSalGrade() throws Exception{
        int count = salGradeMapper.chgSalGrade("L8",12000.0,21000.0);
        logger.debug("{}",salGradeMapper.getSalGrade("L8"));
    }
    @Test
    public void testDelSalGrade() throws Exception{
        int count = salGradeMapper.delSalGrade("L8");
        logger.debug("{}",count);
    }

}
