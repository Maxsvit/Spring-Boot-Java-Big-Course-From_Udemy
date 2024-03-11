package com.exampleaop.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.exampleaop.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void  logToCloudAsync(){
        System.out.println("\n=====>>> Executing @Before advice #3 with async ");
    }


}
