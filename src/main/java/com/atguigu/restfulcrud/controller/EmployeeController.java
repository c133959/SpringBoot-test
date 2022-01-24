package com.atguigu.restfulcrud.controller;

import com.atguigu.restfulcrud.dao.EmployeeDao;
import com.atguigu.restfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @ClassName: EmployeeController
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/1/24 22:37
 * @Version 1.0
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/emps")
    //查询所有员工列表页面
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        // 放在请求域中共享
        model.addAttribute("emps", employees);

        // thymeleaf就会自动拼串 classpath:/template/
        return "emp/list";
    }
}
