package com.example.springmvcexample.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommonMapper {
	public Long getRowCount(@Param("tableName") String tableName, @Param("columnName") String columnName);

}
