package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        Account myAccount = new Account();

        accountDAO.addAccount(myAccount, true);
        accountDAO.doWork();

        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        System.out.println(accountDAO.getName());
        System.out.println(accountDAO.getServiceCode());

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        System.out.println(membershipDAO.addSilly());
        membershipDAO.goToSleep();

        context.close();

    }
}
