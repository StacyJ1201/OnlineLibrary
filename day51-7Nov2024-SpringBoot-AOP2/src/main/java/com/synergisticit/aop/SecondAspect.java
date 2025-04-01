package com.synergisticit.aop;

import com.synergisticit.domain.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Locale;

@Component
@Aspect
public class FirstAspect {

    @After("execution(* com.synergisticit.service.EmployeeService*.*(..))")
    public void after(JoinPoint jp) {
        System.out.println("FirstAspect-@After:... Signature: " +jp.getSignature());
    }

    @Before("execution(* com.synergisticit.service.EmployeeService*.*(..))")
    public void before(JoinPoint jp) {
        System.out.println("FirstAspect-@Before:... Signature: " +jp.getSignature());
    }

    @AfterReturning(value="execution(* com.synergisticit.service.EmployeeService*.*(..))", returning="employees")
    public void afterReturning(JoinPoint jp, List<Employee> employees) {
        System.out.println("FirstAspect-@AfterReturning:... Signature: " +jp.getSignature());
        System.out.println("Size of the list returned "+employees.size());
        if(employees != null){
            employees.forEach(e -> e.getName().toUpperCase());
        }
    }

    @AfterReturning(value="execution(* com.synergisticit.service.EmployeeService*.*(..))", returning="e")
    public void afterReturning2(JoinPoint jp,  Employee e) {
        System.out.println("FirstAspect-@AfterReturning:... Signature: " +jp.getSignature());
        System.out.println(" afterReturning2e: "+ e);

    }

    //=============================

    @AfterThrowing(value="execution(* com.synergisticit.service.EmployeeService*.*(..))", throwing="e")
    public void afterThrowing(JoinPoint jp, Throwable e) {
        System.out.println("FirstAspect-@AfterReturning:... Signature: " +jp.getSignature());
        System.out.println("FirstAspect-@AfterThrowing:... " +e.getClass() + ", message: " + e.getMessage());

    }

    @Around(value="execution(* com.synergisticit.service.EmployeeService*.*(..))")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("FirstAspect-@Around:... ");

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object returnedObject = null;
        StringBuilder sb = new StringBuilder();

        try {
            returnedObject = pjp.proceed();
            stopWatch.stop();
            sb.append(pjp.getSignature().getName()+ "(): ");
            sb.append("@Around...ExecutionTime: "+ stopWatch.getTotalTimeSeconds() + " seconds.");

            System.out.println(sb);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return returnedObject;
    }
}
