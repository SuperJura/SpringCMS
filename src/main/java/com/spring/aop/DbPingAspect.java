package com.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author JuraLocal
 */
@Aspect
public class DbPingAspect {
    
    @Pointcut("execution(* com.spring.db.*.*(..))")
    public void dbMethod()
    {}
    
    @Before("dbMethod()")
    public void dbPing() {
        System.out.println("executing database method....");
    }
}