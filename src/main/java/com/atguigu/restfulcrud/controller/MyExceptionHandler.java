package com.atguigu.restfulcrud.controller;

import com.atguigu.restfulcrud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MyExceptionHandler
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/2/1 10:10
 * @Version 1.0
 */
// 异常处理器 控制通知器
@ControllerAdvice
public class MyExceptionHandler {

    //1. 浏览器客户端返回的都是JSON格式
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e) {
//
//        // 自定义JSON错误信息
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user.notExist");
//        map.put("message", e.getMessage());
//        return map;
//
//    }

    //2. 转发到/error进行自适应响应效果处理
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {

        // 自定义JSON错误信息
        Map<String, Object> map = new HashMap<>();
        // 由于状态码是200，无法跳转到定制的错误页面
        /**
         * Integer statusCode =
         *      (Integer)request.getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.notExist");
        map.put("message", e.getMessage());

        // 将map传入request，request会最终转发到错误处理器
        request.setAttribute("ext", map);

        return "forward:/error";
    }

}
