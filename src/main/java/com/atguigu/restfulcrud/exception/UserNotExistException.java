package com.atguigu.restfulcrud.exception;

/**
 * @ClassName: UserNotExistException
 * @Description: 自定义用户不存在时的异常处理情况
 * @Author sunsl
 * @Date 2022/2/1 9:57
 * @Version 1.0
 */
public class UserNotExistException extends RuntimeException     {

    public UserNotExistException() {
        super("用户不存在");
    }

}
