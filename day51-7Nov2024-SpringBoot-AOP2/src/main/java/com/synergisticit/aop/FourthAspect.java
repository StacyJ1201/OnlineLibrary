package com.synergisticit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ThirdAspect {

    @After("execution(* com.synergisticit.service.EmployeeService*.*(..))")
    public void after(JoinPoint jp) {
        System.out.println("FirstAspect-@After:... Signature: " +jp.getSignature());
    }

}
