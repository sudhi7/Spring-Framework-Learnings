package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

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
