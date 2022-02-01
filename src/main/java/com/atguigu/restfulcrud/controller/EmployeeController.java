package com.atguigu.restfulcrud.controller;

import com.atguigu.restfulcrud.dao.DepartmentDao;
import com.atguigu.restfulcrud.dao.EmployeeDao;
import com.atguigu.restfulcrud.entities.Department;
import com.atguigu.restfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    //查询所有员工列表页面
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        // 放在请求域中共享
        model.addAttribute("emps", employees);

        // thymeleaf就会自动拼串 classpath:/template/
        return "emp/list";
    }

    // 来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 来到添加页面
        // 查出所有的部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    // 员工添加
    // SpringMVC自动将请求参数和入参对象的属性进行一一绑定；
    // 要求请求参数的名字和Javabean入参的对象中的属性名相同
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        // 来到员工列表页面
        //保存员工信息
        System.out.println("保存的员工信息" + employee);
        employeeDao.save(employee);
        // 回到员工列表页面
        // forward: 转发一个请求
        // redirect: 重定向一个地址 /代表当前路径
        return "redirect:/emps";
    }

    // 进入员工信息修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        // 页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        // 回到修改页面
        return "emp/add";
    }

    // 员工修改；需要提交员工的id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println("修改的员工数据" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // 员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
