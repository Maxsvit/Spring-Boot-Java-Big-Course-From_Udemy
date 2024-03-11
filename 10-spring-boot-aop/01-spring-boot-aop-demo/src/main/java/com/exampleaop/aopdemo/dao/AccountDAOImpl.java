package com.exampleaop.aopdemo.dao;

import com.exampleaop.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account account,boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK ");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork() ");
        return false;
    }
}
