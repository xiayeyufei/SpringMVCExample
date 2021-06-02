package com.example.springmvcexample.contrller;

import com.example.springmvcexample.mybatis.entity.Employee;
import com.example.springmvcexample.mybatis.entity.Location;
import com.example.springmvcexample.mybatis.mapper.CommonMapper;
import com.example.springmvcexample.mybatis.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private CommonMapper commonMapper;
    @GetMapping(value = "/findlocation/{pageNo}")
    public String findEmployees(@PathVariable int pageNo, Model model) {
        List<Location> locations = locationMapper.findLocations(null, pageNo, 10);
        int total = commonMapper.getRowCount("locations", "location_id").intValue();
        int pageCount=total/10+((total%10)!=0?1:0);
        model.addAttribute("locations", locations);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("total",total);
        return "/thymeleaf/locations";
    }
}
