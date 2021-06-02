package com.example.springmvcexample.mybatis.mapper;

import com.example.springmvcexample.mybatis.entity.Country;
import com.example.springmvcexample.mybatis.entity.Location;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CountryMapper {

	List<Country> getAllCountries();

}
