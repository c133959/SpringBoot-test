package com.atguigu.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/1/20 21:29
 * @Version 1.0
 */
@Controller
public class HelloController {

//    改由视图控制器来控制
//    @RequestMapping({"/","/index.html"})
//    public String index() {
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("hello")
    public String Hello() {
        return "Hello World";
    }

    @RequestMapping("success")
    public String success(Map<String, Object> map) {
//        页面中的hello，先调用success接口，通过controller方法中保存的map集合中的数据，将数据返回到页面上调用
        map.put("hello", "<h1>你好</h1>");
        map.put("id", 10086);
        map.put("class", "test");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));

        return "success";
    }
}
