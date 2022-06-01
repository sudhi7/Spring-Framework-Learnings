package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.* (..))")
    private void forDaoPackage() {}

    @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackage()")
    public void startsWithAdd() {
        System.out.println("\n===>>> Executing @Before advice on methods with prefix add");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("Performing API Analytics");
    }

}
