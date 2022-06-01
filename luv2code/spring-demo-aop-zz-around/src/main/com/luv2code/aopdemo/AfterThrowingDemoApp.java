package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accountList = null;

        try {
            boolean tripwire = true;
            accountList = accountDAO.findAccounts(tripwire);
        }
        catch(Exception e) {
            System.out.println("\n\nMain Program caught exception: " + e);
        }

        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("----");
        System.out.println(accountList);
        System.out.println("\n");

        context.close();

    }
}
