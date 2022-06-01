package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + " do some work");
        return true;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public List<Account> findAccounts(boolean tripwire) {

        if(tripwire) {
            throw new RuntimeException("Exception!!");
        }
        List<Account> accountList = new ArrayList<>();
        Account temp = new Account("John", "Silver");
        Account temp1 = new Account("Madhu", "Platinum");
        Account temp2 = new Account("Luca", "Gold");

        accountList.add(temp);
        accountList.add(temp1);
        accountList.add(temp2);

        return accountList;
    }
}
