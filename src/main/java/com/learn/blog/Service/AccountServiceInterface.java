package com.learn.blog.Service;

import com.learn.blog.POJO.Account;

import java.util.List;

public interface AccountServiceInterface {
    void saveAccount(Account account);
    void deleteAccount(String accountId);
    void updateAccount(Account account);
    Account getAccount(String accountId);
    Account loginByAccount(Account account);
    List<Account> getAllAccounts();
}
