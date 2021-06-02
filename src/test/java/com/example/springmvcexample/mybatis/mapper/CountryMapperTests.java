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
public class CountryMapperTests {
 @Autowired
 private CountryMapper countrymapper;
 private LocationMapper locationMapper;
 // TRACE、DEBUG、INFO、WARN、ERROR
 private static final Logger logger = LoggerFactory.getLogger(CountryMapperTests.class);
 @Test
 public void testRegionResultMap() throws Exception {
 
  for (Country c : countrymapper.getAllCountries()) {
	  logger.debug("{}", c);
	  logger.debug("{}", c.getRegion());
  }
 }
 @Test
 public void getlocations() throws  Exception{
  List<Location> locationList=locationMapper.getLocations("CN");
  for (Location l: locationList){
   logger.debug("{}",l);
  }

 }
 @Test
 public void testfindlocation() throws Exception {

  for (Country c : countrymapper.getAllCountries()) {
   logger.debug("{}", c);
   for(Location l :c.getLocations()) {
    logger.debug("\t{}\t{}",c.getLocations());

   }
  }
 }


}
