package com.exampleaop.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public void addSillyMember() {

        System.out.println(getClass() + ": DOING MY DB WORK ADDING A MEMBERSHIP ACCOUNT");

    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": DOING MY DB WORK HERE");

    }
}
