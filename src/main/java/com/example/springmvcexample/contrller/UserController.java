package com.example.springmvcexample.contrller;

import com.example.springmvcexample.form.UserSearchForm;
import com.example.springmvcexample.mybatis.entity.User;
import com.example.springmvcexample.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/addchg")
    public String addchg(Model model, @RequestParam(required = false) Long id) {
        if(id!=null){
            User user = userMapper.getUserById(id);
            String a="修改用户";
            model.addAttribute(user);
            model.addAttribute("a",a);
        }
        else{
            User user=new User();
            String a="添加用户";
            model.addAttribute(user);
            model.addAttribute("a",a);
        }
        return "user/form";
    }
    @PostMapping("/addchg")
    public String addchg(@Valid User user, BindingResult bindingResult, RedirectAttributes attr,Model model) {
        if (!bindingResult.hasFieldErrors("confirmPassword")
                && !StringUtils.equals(user.getPassword(), user.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", null, "确认密码与密码不一致");
        }
//        if( userMapper.getUserByAccount(user.getAccount())!=null) {
//            bindingResult.reject("userForm.chg.exist","账号已存在");
//        }
        if (!bindingResult.hasErrors()) {
            if (user.getId()!=0){
                try {
                    userMapper.chgUser(user);
                    attr.addAttribute("id",user.getId());
                    System.out.println(user.getAccount());
                    return "redirect:detail";
                }catch(Exception e) {
                    e.printStackTrace();
                    bindingResult.reject("userForm.chg.error","修改账号失败");
                }
            }
            else{
                try {
                    if( userMapper.getUserByAccount(user.getAccount())!=null) {
                        bindingResult.reject("userForm.chg.exist","账号已存在");
                    }
                    userMapper.addUser(user);
                    attr.addAttribute("id",user.getId());
                    return "redirect:detail";
                }catch(Exception e) {
                    e.printStackTrace();
                    bindingResult.reject("userForm.add.error");
                }
            }
        }
        else{
            if (user.getId()!=0){
                String a="修改用户";
                model.addAttribute("a",a);
            }
            else{
                String a="添加用户";
                model.addAttribute("a",a);
            }
        }
        return "user/form";

    }
    @GetMapping("/chg")
    public String chg(Model model, @RequestParam(required = false) Long id) {
        User user = userMapper.getUserById(id);
        model.addAttribute(user);
        return "user/form";
    }
    @PostMapping("/chg")
    public String chg(@Valid User user, BindingResult bindingResult, RedirectAttributes attr) {
        if (!bindingResult.hasFieldErrors("confirmPassword")
                && !StringUtils.equals(user.getPassword(), user.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", null, "确认密码与密码不一致");
        }
        if( userMapper.getUserByAccount(user.getAccount())!=null) {
            bindingResult.reject("userForm.chg.exist","账号已存在");
        }
        if (!bindingResult.hasErrors()) {
            try {
                userMapper.chgUser(user);
                attr.addAttribute("id",user.getId());
                return "redirect:detail";
            }catch(Exception e) {
                e.printStackTrace();
                bindingResult.reject("userForm.chg.error","修改账号失败");
            }
        }
        return "user/form";
    }
    @GetMapping("/detail")
    public String getUserById(Model model, @RequestParam long id) {
        User user = userMapper.getUserById(id);
        model.addAttribute(user);
        return "user/detail";
    }
    @GetMapping("/add")
    public String add(User user) {
        return "user/form";
    }

    @PostMapping("/add")
    public String add(@Valid User user, BindingResult bindingResult, RedirectAttributes attr) {
        if (!bindingResult.hasFieldErrors("confirmPassword")
                && !StringUtils.equals(user.getPassword(), user.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", null, "确认密码与密码不一致");
        }
        if( userMapper.getUserByAccount(user.getAccount())!=null) {
            bindingResult.reject("userForm.add.exist");
        }
        if (!bindingResult.hasErrors()) {
            try {
                userMapper.addUser(user);
                attr.addAttribute("id",user.getId());
                return "redirect:detail";
            }catch(Exception e) {
                e.printStackTrace();
                bindingResult.reject("userForm.add.error");
            }
        }
        return "user/form";
    }
    @RequestMapping("/list")
    public String list(HttpServletRequest hsr, @Valid UserSearchForm userSearchForm, BindingResult bindingResult, Model model){
        if (!bindingResult.hasErrors()) {
            long userCount = userMapper.getUserCount(userSearchForm.getAccount(), userSearchForm.getName(),
                    userSearchForm.getSex(), userSearchForm.getStartBirthday(), userSearchForm.getEndBirthday(),
                    userSearchForm.getMinSalary(), userSearchForm.getMaxSalary(), userSearchForm.getAuthorities());
            int pageTotal = (int) Math.ceil(userCount * 1.0 / 10);
            userSearchForm.getPaging().setPageTotal(pageTotal);
            List<User> users = userMapper.findUsers(userSearchForm.getAccount(), userSearchForm.getName(),
                    userSearchForm.getSex(), userSearchForm.getStartBirthday(), userSearchForm.getEndBirthday(),
                    userSearchForm.getMinSalary(), userSearchForm.getMaxSalary(), userSearchForm.getAuthorities(),
                    null, userSearchForm.getPaging().getPageNo(),
                    userSearchForm.getPaging().getPageSize());
            model.addAttribute("users", users);
        }
        else{
            //List<User> users =userMapper.findall();
            userSearchForm.getPaging().setPageTotal(0);
            //model.addAttribute("users", users);
        }
        return "user/list";
    }
    @ModelAttribute("sexList")
    public List<String> getSexList() {
        List<String> sexList = new ArrayList<String>();
        sexList.add("男");
        sexList.add("女");
        return sexList;
    }
    @ModelAttribute("authorityList")
    public List<String> getAuthorityList() {
        List<String> authorityList = new ArrayList<String>();
        authorityList.add("读");
        authorityList.add("写");
        authorityList.add("删除");
        return authorityList;
    }

}
