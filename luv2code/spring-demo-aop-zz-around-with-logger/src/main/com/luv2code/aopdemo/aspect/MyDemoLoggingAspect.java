package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n=====>>>> executing @Around on method: " + method);

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;

        logger.info("\n=====>> Duration: " + duration/ 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=====>>>> executing @After (finally) on method: " + method);

    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exe"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exe) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=====>>>> executing @AfterThrowing on method: " + method);
        logger.info("\n=====>>>> The exception is: " + exe);

    }

    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
    returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=====>>>> executing @AfterReturning on method: " + method);

        logger.info("\n=====>>>> result is: " + result);

        convertAccountNamesToUpperCase(result);

        logger.info("\n=====>>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for(Account account: result) {
            String uppName = account.getName().toUpperCase();
            account.setName(uppName);
        }

    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info("\n====>>> Executing @Before advice on method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        logger.info("Method: " + methodSignature);

        Object[] arg = joinPoint.getArgs();

        for(Object temp: arg) {
            System.out.println(temp);
            if(temp instanceof Account) {
                Account account = (Account) temp;
                logger.info("Account name: " + account.getName());
                logger.info("Account Level " + account.getLevel());
            }
        }
    }
}
