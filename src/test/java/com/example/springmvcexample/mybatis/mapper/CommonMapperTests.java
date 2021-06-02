package com.example.springmvcexample.mybatis.mapper;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommonMapperTests {
    @Autowired
    private CommonMapper commonMapper;
    // TRACE、DEBUG、INFO、WARN、ERROR
    private static final Logger logger = LoggerFactory.getLogger(CommonMapperTests.class);
    @Test
    public void testGetRowCount() throws Exception{
        logger.debug("{}",commonMapper.getRowCount("regions","region_name"));
    }

}
