package com.library.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
    @Around("execution(* com.library.service.*.*(..))")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try { return joinPoint.proceed(); }
        finally { System.out.println(joinPoint.getSignature() + " took " + (System.nanoTime() - start) + " ns"); }
    }
}
