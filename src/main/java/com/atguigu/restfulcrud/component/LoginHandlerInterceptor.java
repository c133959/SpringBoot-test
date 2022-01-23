package com.atguigu.restfulcrud.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: LoginHandlerInterceptor
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/1/23 18:13
 * @Version 1.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    // 目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        //如果loginUser不为空，说明当前已成功登录
        if (user == null) {
            //未登录，返回登录界面
            // 获取转发器，给转发出去,转发到登录页
            request.setAttribute("msg", "没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            // 已登录,方形
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
