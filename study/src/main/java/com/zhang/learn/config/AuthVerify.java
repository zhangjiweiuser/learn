package com.zhang.learn.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/12/10 10:34
 */
@Component
@Aspect
public class AuthVerify {

    @Around("execution(* com.zhang.learn.controller.*.*(..))")
    public Object auth(ProceedingJoinPoint pjp) throws Throwable {

//        int random = RandomUtil.getRandom().nextInt(0, 10);
//        System.out.println(random);
//        if (random < 5) {
//            return "random 小于5";
//        }

        return pjp.proceed();
    }
}
