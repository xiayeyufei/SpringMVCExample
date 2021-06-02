package com.example.springmvcexample.mybatis.mapper;

import com.example.springmvcexample.mybatis.entity.Country;
import com.example.springmvcexample.mybatis.entity.Location;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LocationMapperTest {
    @Autowired
    private LocationMapper locationMapper;
    private static final Logger logger = LoggerFactory.getLogger(LocationMapperTest.class);
@Test
    public void testLocationResultMap() throws Exception {
    for (Location l : locationMapper.getAllLocations()) {
        logger.debug("{}", l);
        logger.debug("{}", l.getCountry());
        logger.debug("{}", l.getCountry().getRegion());
    }
}
    @Test
    public void testfindalllocation() throws Exception {
        for (Location l : locationMapper.getAllLocations()) {
            logger.debug("{}", l);
            logger.debug("{}", l.getCountry());
            logger.debug("{}", l.getCountry().getRegion());
        }
    }
    @Test
    public void testfindbycountyid() throws Exception {
        for (Location l : locationMapper.getLocations("CN")) {
            logger.debug("{}", l);
            logger.debug("{}", l.getCountry());
            logger.debug("{}", l.getCountry().getRegion());
        }
    }
    @Test
    public void testfindbylid() throws Exception {
        Location l=locationMapper.getLocation(1000);
        logger.debug("{}", l);
        logger.debug("{}", l.getCountry());
        logger.debug("{}", l.getCountry().getRegion());
    }
    @Test
    public void testaddlocation() throws Exception {
        Location l=new Location();
        l.setStreetAddress("testadd");
        l.setStateProvince("BeiJing");
        l.setPostalCode("190519");
        l.setCity("BeiJing");
        Country c=new Country();
        c.setId("CN");
        l.setCountry(c);
        int a=locationMapper.addLocation(l);
        logger.debug("{}", l);
    }
    @Test
    public void testchglocation() throws Exception {
        Location l=locationMapper.getLocation(3203);
        if(l!=null){
            l.setStreetAddress("testchg");
            int a=locationMapper.chgLocation(l);
            logger.debug("{}", l);
        }
        else{
            logger.debug("{}", "查询不到该数据");
        }
    }
    @Test
    public void testdellocation() throws Exception {
        int a=locationMapper.delLocation(3203);
        if(a>=1){
            logger.debug("{}", "删除了"+a+"条数据");
        }
    }
    @Test
    public void testFindLocations() throws Exception {
        List<Location> ls=locationMapper.findLocations(new String[]{"STREET_ADDRESS"},1,10);
        for (Location l: ls
        ) {
            logger.debug("{}",l);
        }
    }
}

