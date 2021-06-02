package com.example.springmvcexample.mybatis.mapper;

import com.example.springmvcexample.mybatis.entity.Region;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RegionMapper {
	public List<Region> getAllRegions();
	public int addRegion(Region region);
	public Region getRegion(int id);
	public int chgRegion(Region region);
	public int delRegion(Integer id);
	public List<Map<String,Object>> getAllRegionsAsMapList();
	public List<Region> getAllRegionsAsRegionList();
	 public Long getRowCount(@Param("tableName") String tableName, @Param("columnName") String columnName);
}
