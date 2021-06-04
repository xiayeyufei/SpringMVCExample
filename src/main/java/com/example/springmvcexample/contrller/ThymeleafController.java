package com.example.springmvcexample.contrller;

import com.example.springmvcexample.mybatis.entity.Employee;
import com.example.springmvcexample.mybatis.entity.Region;
import com.example.springmvcexample.mybatis.mapper.CommonMapper;
import com.example.springmvcexample.mybatis.mapper.EmployeeMapper;
import com.example.springmvcexample.mybatis.mapper.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.*;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private CommonMapper commonMapper;

    @GetMapping(value = "/02_welcome")
    public String welcome(Model model, Principal principal, HttpSession httpSession) {
        model.addAttribute("welcome", "Hello world。");
        return "/thymeleaf/02_welcome";//返回的是模板的路径
    }

    @GetMapping(value = "/03_expression")
    public String expression(Model model) {
        Map<String, String> fruits = new HashMap<>();
        fruits.put("apple", "苹果");
        fruits.put("mango", "芒果");
        fruits.put("peach", "桃子");
        fruits.put("red cherry", "红樱桃");
        Employee president = employeeMapper.getEmployee(100);
        List<Employee> employees = employeeMapper.getAllEmployees();
        model.addAttribute("num01", 36);
        model.addAttribute("num02", 10);
        model.addAttribute("fruits", fruits);
        model.addAttribute("president", president);
        model.addAttribute("employees", employees);
        return "/thymeleaf/03_expression";
    }

    @GetMapping(value = "/04_01_setattrval")
    public String setattrval(Model model) {
        model.addAttribute("width", 128);
        model.addAttribute("height", 128);
        model.addAttribute("alt", "浏览器不支持图片");
        return "/thymeleaf/04_01_setattrval";
    }

    @GetMapping(value = "/04_02_attrappend")
    public String attrappend(Model model) {
        model.addAttribute("table_dark", "table-dark");
        model.addAttribute("col_4", "col-4");
        return "/thymeleaf/04_02_attrappend";
    }

    @GetMapping(value = "/04_03_fixvalueboolean")
    public String fixvalueboolean(Model model) {
        model.addAttribute("sex", "female");
        return "/thymeleaf/04_03_fixvalueboolean";
    }

    @GetMapping(value = "/05_iterate")
    public String iterate(Model model) {
        Map<String, String> fruits = new HashMap<>();
        fruits.put("apple", "苹果");
        fruits.put("mango", "芒果");
        fruits.put("peach", "桃子");
        fruits.put("red cherry", "红樱桃");
        List<Employee> employees = employeeMapper.getAllEmployees();
        model.addAttribute("fruits", fruits);
        model.addAttribute("employees", employees);
        return "/thymeleaf/05_iterate";
    }

    @GetMapping(value = "/06_conditional_evaluation")
    public String conditionalEvaluation(Model model) {
        List<Employee> employees = employeeMapper.getAllEmployees();
        model.addAttribute("employees", employees);
        return "/thymeleaf/06_conditional_evaluation";
    }

    @GetMapping(value = "/07_select_expression")
    public String selectExpression(Model model) {
        List<Employee> employees = employeeMapper.getAllEmployees();
        model.addAttribute("employees", employees);
        return "/thymeleaf/07_select_expression";
    }

    @GetMapping(value = "/08_local_var")
    public String localVar(Model model) {
        List<Employee> employees = employeeMapper.getAllEmployees();
        model.addAttribute("employees", employees);
        return "/thymeleaf/08_local_var";
    }

    @GetMapping(value = "/09_unescape_text")
    public String unescapeText(Model model) {
        String code = "<i><b><u>3<sup>4</sup>=81</u></b></i>";
        model.addAttribute("code", code);
        return "/thymeleaf/09_unescape_text";
    }

    @GetMapping(value = "/10_inline_text")
    public String inlineText(Model model) {
        String code = "<i><b><u>3<sup>4</sup>=81</u></b></i>";
        Employee president = employeeMapper.getEmployee(100);
        model.addAttribute("code", code);
        model.addAttribute("president", president);
        return "/thymeleaf/10_inline_text";
    }

    @GetMapping(value = "/11_inline_js_css")
    public String inlineJsCss(Model model) {
        model.addAttribute("color", "red");
        model.addAttribute("fontSize", "3em");
        model.addAttribute("textAlign", "center");
        model.addAttribute("fontWeight", 900);
        Employee president = employeeMapper.getEmployee(100);
        model.addAttribute("president", president);
        return "/thymeleaf/11_inline_js_css";
    }

    @GetMapping(value = "/12_01_exp_util")
    public String expUtil(Model model) {
        List<Employee> employees = employeeMapper.getAllEmployees();
        model.addAttribute("employees", employees);
        return "/thymeleaf/12_01_exp_util";
    }

    @GetMapping(value = "/12_02_exp_util_numbers")
    public String expUtilNumbers(Model model) {
        DecimalFormat df = new DecimalFormat("#.00000");
        double num = new Double(df.format(Math.random() * 1000));
        Double[] numArray = new Double[3];
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = new Double(df.format(Math.random() * 1000));
        }
        List<Double> numList = Arrays.asList(numArray);
        Set<Double> numSet = new HashSet<Double>(numList);
        model.addAttribute("num", num);
        model.addAttribute("numArray", numArray);
        model.addAttribute("numList", numList);
        model.addAttribute("numSet", numSet);
        return "/thymeleaf/12_02_exp_util_numbers";
    }
//    @GetMapping(value = "/employees/{pageno}")
//    public String findEmployees(@PathVariable int pageno, Model model) {
//        List<Employee> employees = employeeMapper.findEmployees(null, pageno, 10);
//        long total =commonMapper.getRowCount("employees","employee_id");
//        model.addAttribute("employees", employees);
//        model.addAttribute("pageno",pageno);
//        model.addAttribute("total",total);
//        return "/thymeleaf/employees";
//    }

}
