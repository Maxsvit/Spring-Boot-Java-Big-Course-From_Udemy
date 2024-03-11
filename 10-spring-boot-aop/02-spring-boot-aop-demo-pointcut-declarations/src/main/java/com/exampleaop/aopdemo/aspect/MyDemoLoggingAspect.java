package com.exampleaop.aopdemo.aspect;

import com.exampleaop.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.xml.crypto.dsig.SignatureMethod;
import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.exampleaop.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n ======>>> Executing @Around on method: "
                + method);

        long begin = System.currentTimeMillis();

        Object result =null;
        try {
          result = proceedingJoinPoint.proceed();
        }
        catch (Exception exc){
            System.out.println(exc.getMessage());

           throw exc;
        }
        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("\n ======>>> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }


    @After("execution(* com.exampleaop.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint){

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n ======>>> Executing @After on method: "
                + method);



    }

    @AfterThrowing(
            pointcut = "execution(* com.exampleaop.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(
            JoinPoint joinPoint, Throwable theExc
    ){
        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n ======>>> Executing @AfterThrowing on method: " + method);

        System.out.println("\n ======>>> The exeption is:  " + theExc);


    }


    @AfterReturning(
            pointcut = "execution(* com.exampleaop.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n ======>>> Executing @AfterReturning on method: " + method);

        System.out.println("Result is:" + result );

        convertAccountNamesToUpperCase(result);

        System.out.println("Result is:" + result );
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account: result){

            String theUpperName = account.getName().toUpperCase();

            account.setName(theUpperName);
        }
    }

    @Before("com.exampleaop.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n=====>>> Executing @Before advice");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args){
            System.out.println(tempArg);
            if (tempArg instanceof Account){
                Account theAccount = (Account) tempArg;

                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }
    }

}
