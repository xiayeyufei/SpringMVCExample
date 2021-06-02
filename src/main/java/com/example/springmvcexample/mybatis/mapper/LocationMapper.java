package com.example.springmvcexample.mybatis.mapper;

import com.example.springmvcexample.mybatis.entity.Employee;
import com.example.springmvcexample.mybatis.entity.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface LocationMapper {
    public Location getLocation(Integer id);

    public List<Location> getAllLocations();

    public List<Location> getLocations(String countryId);

    public int addLocation(Location location);

    public int chgLocation(Location location);

    public int delLocation(int id);
    public List<Location> findLocations(@Param("orderBy") String[] orderBy,
                                        @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
}
