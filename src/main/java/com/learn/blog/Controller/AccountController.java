package com.learn.blog.Controller;

import com.learn.blog.POJO.Account;
import com.learn.blog.Response.AccountResponse;
import com.learn.blog.Service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/personalCenter")
public class AccountController {



    @Resource
    private AccountService accountService;



    Account accountPresent=new Account();

    //登陆操作 使用用户名+密码方式登陆
    @GetMapping("/login")
    public AccountResponse login(@RequestBody Account account)
    {
        Account account1=accountService.loginByAccount(account);
        if(account1.getStatue()!=null)
        {
            return AccountResponse.loginFail(1);
        }
        else
        {
            account1.setStatue(1);
            accountService.updateAccount(account1);
            accountPresent=account1;
        }
        log.info("select account"+account);
        if(account1==null)
            return AccountResponse.loginFail(0);
        return AccountResponse.loginSuccess(account1);
    }

    //注册操作   ID+用户名+密码
    @PostMapping("/register") public AccountResponse register(@RequestBody Account account) {
        Account account1=accountService.getAccount(account.getId());
        log.info("select account"+account);
        if(account1==null)
        {
            accountService.saveAccount(account);
            return AccountResponse.registerSuccess(account);
        }
        else
            return AccountResponse.registerFail();
    }

    //更改密码
    @PutMapping("/update/{password}") public AccountResponse update(@PathVariable String password){
        if(accountPresent==null)
            return AccountResponse.updateFail();
        else
        {
            accountPresent.setPassword(password);
        accountService.updateAccount(accountPresent);
        }
        return AccountResponse.updateSuccess();
    }

    //删除账户
    @DeleteMapping("/delete") public AccountResponse delete(){
        if(accountPresent==null)
            return AccountResponse.updateFail();
        else
        {
           accountService.deleteAccount(accountPresent.getId());
        }
        return AccountResponse.updateSuccess();
    }

}
