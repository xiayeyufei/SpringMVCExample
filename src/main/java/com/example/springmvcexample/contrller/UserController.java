package com.example.springmvcexample.contrller;

import com.example.springmvcexample.form.UserSearchForm;
import com.example.springmvcexample.mybatis.entity.User;
import com.example.springmvcexample.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/list")
    public String list(HttpServletRequest hsr, Model model, @Valid UserSearchForm userSearchForm, BindingResult bindingResult) {

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

        return "user/list";
    }

}
