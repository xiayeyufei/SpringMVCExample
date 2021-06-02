package com.example.springmvcexample.mybatis.mapper;

import com.example.springmvcexample.mybatis.entity.Location;
import com.example.springmvcexample.mybatis.mapper.RegionMapper;
import com.example.springmvcexample.mybatis.entity.Country;
import com.example.springmvcexample.mybatis.entity.Region;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class RegionMapperTests {
 @Autowired
 private RegionMapper regionMapper;
 private LocationMapper locationMapper;
 // TRACE、DEBUG、INFO、WARN、ERROR
 private static final Logger logger = LoggerFactory.getLogger(RegionMapperTests.class);
 @Test
 public void testRegionResultMap() throws Exception {
 
  for (Region r : regionMapper.getAllRegions()) {
	  logger.debug("{}", r);
  }
 }
 @Test
	public void testGetAllRegionsAsMapList()throws Exception {
		for (Map<String,Object> r : regionMapper.getAllRegionsAsMapList()) {
			logger.debug("{}", r);
		}
	}
 @Test
 public void testGetRowCount() throws Exception {
  logger.debug("{}", regionMapper.getRowCount("regions", "region_id"));
 }
 @Test
 public void testAddRegion() throws Exception {
		Region region = new Region();
		region.setName("AAAAAAmmmasasddA");
		int count = regionMapper.addRegion(region);
		logger.debug("{}", count);
		logger.debug("{}", region);
	}
 @Test
	public void testGetRegion() throws Exception {
		logger.debug("{}", regionMapper.getRegion(10));
	}
 @Test
	public void testChgRegion() throws Exception {
		Region region =regionMapper.getRegion(10);
		region.setName("新疆乌鲁木齐");
		regionMapper.chgRegion(region);
		logger.debug("{}", region);
	}
	@Test
	public void testGetAllRegionsAsRegionList()throws Exception {
		for (Region r : regionMapper.getAllRegions()) {
			logger.debug("{}", r);
			for(Country c : r.getCountries()) {
				logger.debug("\t{}", c);
				for (Location l:c.getLocations()){
					logger.debug("\t\t{}",l);
				}
			}
		}
	}
	@Test
	public void findCountry() throws Exception{
 	Region region=regionMapper.getRegion(2);
 	for (Country c: region.getCountries()){
		logger.debug("{}",c.getId());
 		for (Location l:locationMapper.getLocations(c.getId())){
			logger.debug("{}",l);
		}

	}
	}
	
}
