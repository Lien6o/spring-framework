package org.springframework.mytest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author Lien6o
 */
@Aspect
@Component
public class AspectProxy {


    @Around("@annotation(com.youchat.creative.factory.spring.DummyTransactional)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AspectProxy: around " + joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }

}
