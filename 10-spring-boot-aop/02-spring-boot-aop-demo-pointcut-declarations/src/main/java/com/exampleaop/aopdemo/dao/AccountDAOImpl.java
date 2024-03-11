package com.exampleaop.aopdemo.dao;

import com.exampleaop.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;
    @Override
    public void addAccount(Account account,boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK ");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork() ");
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {

        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("No soup for you!");

        }


        List<Account> accountsList = new ArrayList<>();
        Account account1 = new Account("Max","Platinum");
        Account account2 = new Account("Madhu","Gold");
        Account account3 = new Account("Luka","Silver");
        accountsList.add(account1);
        accountsList.add(account2);
        accountsList.add(account3);
        return accountsList;

    }
}
