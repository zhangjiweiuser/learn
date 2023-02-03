package com.zhang.learn.config;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.zhang.learn.annotation.NoRepeatSubmit;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/5/25 17:39
 */
@Slf4j
@Aspect
@Component
public class NoRepeatSubmitAop {

    private final Cache<String, Integer> cache = CacheBuilder.newBuilder().expireAfterWrite(2L, TimeUnit.SECONDS).build();

    @Around("execution(* com.zhang.learn.controller.*Controller.*(..)) && @annotation(nrs)")
    public Object around(ProceedingJoinPoint pjp, NoRepeatSubmit nrs) {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            String sessionId = Objects.requireNonNull(attributes).getSessionId();
            HttpServletRequest request = attributes.getRequest();
            String key = sessionId + "-" + request.getServletPath();
            log.info("key:{}", key);
            if (cache.getIfPresent(key) == null) {
                Object o = pjp.proceed();
                cache.put(key, 0);
                return o;
            } else {
                return "重复提交";
            }
        } catch (Throwable e) {
            return "aop拦截器异常";
        }
    }
}
