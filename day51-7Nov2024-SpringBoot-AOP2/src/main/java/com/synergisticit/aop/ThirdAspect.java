package com.synergisticit.aop;

import com.synergisticit.domain.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.List;

@Component
@Aspect
public class SecondAspect {

    @After("execution(* com.synergisticit.service.EmployeeService*.*(..))")
    public void after(JoinPoint jp) {
        System.out.println("FirstAspect-@After:... Signature: " +jp.getSignature());
    }

}
