package com.example.springmvcexample.contrller;

import com.example.springmvcexample.form.EmployeeSearchForm;

import com.example.springmvcexample.mybatis.entity.Employee;
import com.example.springmvcexample.mybatis.mapper.EmployeeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;
    @GetMapping("/list")
    public String list(HttpServletRequest hsr ,@Valid EmployeeSearchForm employeeSearchForm,BindingResult bindingResult,Model model){
        if (!bindingResult.hasErrors()){
            long employeeCount=employeeMapper.getEmployeeCount(employeeSearchForm.getFirst_name(),employeeSearchForm.getLast_name(),employeeSearchForm.getEmail(),
                    employeeSearchForm.getPhoneNumber(),employeeSearchForm.getStarthiredate(),
                    employeeSearchForm.getEndhiredate(),employeeSearchForm.getEmail(),employeeSearchForm.getMinSalary(),
                    employeeSearchForm.getMaxSalary(),employeeSearchForm.getCommissionPct(),employeeSearchForm.getManagerId(),
                    employeeSearchForm.getDepartment());
            int pageTotal= (int) Math.ceil(employeeCount*1.0/10);
            employeeSearchForm.getPaging().setPageTotal(pageTotal);
            List<Employee> employees=employeeMapper.findEmployees(employeeSearchForm.getFirst_name(),employeeSearchForm.getLast_name(),employeeSearchForm.getEmail(),
                    employeeSearchForm.getPhoneNumber(),employeeSearchForm.getStarthiredate(),
                    employeeSearchForm.getEndhiredate(),employeeSearchForm.getEmail(),employeeSearchForm.getMinSalary(),
                    employeeSearchForm.getMaxSalary(),employeeSearchForm.getCommissionPct(),employeeSearchForm.getManagerId(),
                    employeeSearchForm.getDepartment(),null, employeeSearchForm.getPaging().getPageNo(),
                    employeeSearchForm.getPaging().getPageSize());
            model.addAttribute("employees", employees);
        }
        else {
            employeeSearchForm.getPaging().setPageTotal(0);
        }
        return "employee/list";
    }


}
