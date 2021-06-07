package com.example.springmvcexample.contrller;

import com.example.springmvcexample.form.EmployeeSearchForm;

import com.example.springmvcexample.mybatis.entity.Department;
import com.example.springmvcexample.mybatis.entity.Employee;
import com.example.springmvcexample.mybatis.entity.Job;
import com.example.springmvcexample.mybatis.mapper.DepartmentMapper;
import com.example.springmvcexample.mybatis.mapper.EmployeeMapper;

import com.example.springmvcexample.mybatis.mapper.JobMapper;
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
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @RequestMapping("/list")
    public String list(HttpServletRequest hsr, @Valid EmployeeSearchForm employeeSearchForm, BindingResult bindingResult, Model model){
        List<Job> joblist=jobMapper.getAllJobs();
        List<Department> dlist= departmentMapper.getAllDepartments();
        if (!bindingResult.hasErrors()) {
            long employeeCount = employeeMapper.getEmployeeCount(employeeSearchForm.getFirst_name(), employeeSearchForm.getLast_name(),employeeSearchForm.getEmail(),
                    employeeSearchForm.getPhoneNumber(), employeeSearchForm.getStarthiredate(), employeeSearchForm.getEndhiredate(),employeeSearchForm.getJob(),
                    employeeSearchForm.getMinSalary(),employeeSearchForm.getMaxSalary(),employeeSearchForm.getCommissionPct(),employeeSearchForm.getManagerId(),employeeSearchForm.getDepartmentname());
            int pageTotal = (int) Math.ceil(employeeCount * 1.0 / 10);
            employeeSearchForm.getPaging().setPageTotal(pageTotal);
            List<Employee> employees = employeeMapper.findEmployees(employeeSearchForm.getFirst_name(), employeeSearchForm.getLast_name(),employeeSearchForm.getEmail(),
                    employeeSearchForm.getPhoneNumber(), employeeSearchForm.getStarthiredate(), employeeSearchForm.getEndhiredate(),employeeSearchForm.getJob(),
                    employeeSearchForm.getMinSalary(),employeeSearchForm.getMaxSalary(),employeeSearchForm.getCommissionPct(),employeeSearchForm.getManagerId(),employeeSearchForm.getDepartmentname(),
                    null,employeeSearchForm.getPaging().getPageNo(),employeeSearchForm.getPaging().getPageSize());
            model.addAttribute("employees", employees);
            System.out.println("-----------"+employeeSearchForm.getStarthiredate());
            System.out.println("-----------"+employeeSearchForm.getEndhiredate());
        }
        else{
            //List<User> users =userMapper.findall();
            employeeSearchForm.getPaging().setPageTotal(0);
            //model.addAttribute("users", users);
        }
        model.addAttribute("joblist",joblist);
        model.addAttribute("dlist",dlist);
        return "employee/list";
    }
    @GetMapping("/addchg")
    public String addchg(Model model, @RequestParam(required = false) Integer id) {
        List<Job> joblist=jobMapper.getAllJobs();
        List<Department> dlist= departmentMapper.getAllDepartments();
        model.addAttribute("joblist",joblist);
        model.addAttribute("dlist",dlist);
        if(id!=null){
            Employee employee = employeeMapper.getEmployee(id);
            System.out.println(employee.getFirstName()+"++++++++++++");
            model.addAttribute(employee);
        }
        else{
            Employee employee=new Employee();
            employee.setId(0);
            model.addAttribute(employee);
        }
        return "employee/form";
    }
    @PostMapping("/addchg")
    public String addchg(@Valid Employee employee, BindingResult bindingResult, RedirectAttributes attr,Model model) {
        List<Job> joblist=jobMapper.getAllJobs();
        List<Department> dlist= departmentMapper.getAllDepartments();
        model.addAttribute("joblist",joblist);
        model.addAttribute("dlist",dlist);
        boolean accountExisted = false;
        Job job=new Job();
        if (!bindingResult.hasErrors()) {
            try {
                if (employee.getId() == 0) {
                    employeeMapper.addEmployee(employee);
                } else {
                    employeeMapper.chgEmployee(employee);
                }
                attr.addAttribute("id", employee.getId());
                return "redirect:detail";
            } catch (Exception e) {
                e.printStackTrace();
                if (employee.getId() == 0) {
                    bindingResult.reject("user.add.failed", "添加用户失败");
                } else {
                    bindingResult.reject("user.chg.failed", "修改用户失败");
                }
            }
        }
        return "employee/form";
    }
    @GetMapping("/detail")
    public String getUserById(Model model, @RequestParam Integer id) {
        Employee employee = employeeMapper.getEmployee(id);
        model.addAttribute(employee);
        return "employee/detail";
    }
    @GetMapping("/del")
    public ModelAndView del(ModelAndView view, @RequestParam Integer id) {
        employeeMapper.delEmployee(id);
        view.setViewName("redirect:list");
        return view;
    }


}
