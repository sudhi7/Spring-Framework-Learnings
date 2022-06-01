package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    @Around("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> executing @Around on method: " + method);

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("\n=====>> Duration: " + duration/ 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> executing @After (finally) on method: " + method);

    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exe"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exe) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> executing @AfterThrowing on method: " + method);
        System.out.println("\n=====>>>> The exception is: " + exe);

    }

    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
    returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> executing @AfterReturning on method: " + method);

        System.out.println("\n=====>>>> result is: " + result);

        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for(Account account: result) {
            String uppName = account.getName().toUpperCase();
            account.setName(uppName);
        }

    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n====>>> Executing @Before advice on method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] arg = joinPoint.getArgs();

        for(Object temp: arg) {
            System.out.println(temp);
            if(temp instanceof Account) {
                Account account = (Account) temp;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account Level " + account.getLevel());
            }
        }
    }
}
