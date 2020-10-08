package com.learn.blog.Response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class AccountResponse {
    private boolean isok;
    private int code;//200  400  500
    private String message;
    @JsonIgnore
    private Object data;

    //登陆成功返回信息
    public static AccountResponse loginSuccess(Object obj) {
        AccountResponse responds = new AccountResponse();
        responds.setIsok(true);
        responds.setCode(200);
        responds.setData(obj);
        responds.setMessage("登陆成功");
        return responds;
    }

    //注册成功返回信息
    public static AccountResponse registerSuccess(Object obj) {
        AccountResponse responds = new AccountResponse();
        responds.setIsok(true);
        responds.setCode(200);
        responds.setData(obj);
        responds.setMessage("注册成功");
        return responds;
    }

    //删除成功返回信息
    public static AccountResponse deleteSuccess(Object obj) {
        AccountResponse responds = new AccountResponse();
        responds.setIsok(true);
        responds.setCode(200);
        responds.setData(obj);
        responds.setMessage("删除成功");
        return responds;
    }

    //更改密码成功返回信息
    public static AccountResponse updateSuccess() {
        AccountResponse responds = new AccountResponse();
        responds.setIsok(true);
        responds.setCode(200);
        responds.setMessage("更改成功");
        return responds;
    }

    //登陆失败返回信息
    public static AccountResponse loginFail(Integer exception) {
        AccountResponse responds = new AccountResponse();
        responds.setIsok(false);
        responds.setCode(200);
        switch (exception)
        {
            case 0: responds.setMessage("用户名或密码错误");
            case 1: responds.setMessage("用户已登录");
        }
        System.out.println(responds);
        return responds;
    }

    //登陆失败返回信息
    public static AccountResponse registerFail() {
        AccountResponse responds = new AccountResponse();
        responds.setIsok(false);
        responds.setCode(200);
        responds.setMessage("用户名被占用");
        System.out.println(responds);
        return responds;
    }

    //修改失败返回信息
    public static AccountResponse updateFail() {
        AccountResponse responds = new AccountResponse();
        responds.setIsok(false);
        responds.setCode(200);
        responds.setMessage("请先登录");
        System.out.println(responds);
        return responds;
    }

    //注册失败返回信息
    public static AccountResponse deleteFail() {
        AccountResponse responds = new AccountResponse();
        responds.setIsok(false);
        responds.setCode(200);
        responds.setMessage("请先登陆");
        System.out.println(responds);
        return responds;
    }
}
