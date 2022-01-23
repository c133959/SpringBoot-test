package com.atguigu.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/1/23 17:39
 * @Version 1.0
 */
@Controller
public class LoginController {

//    @RequestMapping(value="/user/login", method = RequestMethod.POST)
    @PostMapping(value="/user/login")
    public String login(@RequestParam("username") String user,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(user) && "123456".equals(password)) {
//            return "dashboard";//登录成功
            //防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser", user);//将登录成功的用户信息存入session-配合拦截器使用
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }

}
