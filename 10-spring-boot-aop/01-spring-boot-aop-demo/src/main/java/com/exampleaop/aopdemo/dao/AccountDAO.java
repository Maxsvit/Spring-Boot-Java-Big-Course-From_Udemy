package com.exampleaop.aopdemo.dao;

import com.exampleaop.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount,boolean vipFlag);

    boolean doWork();
}
