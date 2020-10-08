package com.learn.blog.Service;

import com.learn.blog.Mapper.AccountMapper;
import com.learn.blog.POJO.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("com.learn.blog.Service.AccountServiceInterface")
public class AccountService implements AccountServiceInterface{

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void saveAccount(Account account) {
    accountMapper.insert(account);
    }

    @Override
    public void deleteAccount(String id) {
    accountMapper.deleteById(id);
    }

    @Override
    public void updateAccount(Account account) {
    accountMapper.updateById(account);

    }


    @Override
    public Account getAccount(String id) {
        return accountMapper.selectById(id);
    }

    @Override
    public Account loginByAccount(Account account) {
       Account account1=accountMapper.selectById(account.getId());
       if(account1.getPassword().equals(account.getPassword()))
       return account1;
       else
           return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        return null;
    }
}
