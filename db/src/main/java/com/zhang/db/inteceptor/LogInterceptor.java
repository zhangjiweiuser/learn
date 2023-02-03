package com.zhang.db.inteceptor;

import com.alibaba.fastjson.JSONObject;
import com.zhang.db.annotation.OperateLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.weaver.reflect.ReflectionWorld;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-04-07 21:20
 */
@Component
@Aspect
@Order(0)
@ConditionalOnClass({Around.class, ReflectionWorld.class})
public class LogInterceptor {
    @Around("@within(operateLog) || @annotation(operateLog)")
    public Object userAround(ProceedingJoinPoint jp, OperateLog operateLog) throws Throwable {
        Object[] obj = jp.getArgs();
        Object target = jp.getTarget();
        Signature signature = jp.getSignature();
        MethodSignature msg = (MethodSignature) signature;
        Method method = target.getClass().getMethod(msg.getName(), msg.getParameterTypes());
        Parameter[] parameters = method.getParameters();
        List<String> param = new ArrayList<>();
        for (Parameter p : parameters) {
            param.add(p.getName());
        }
        JSONObject result = new JSONObject();
        for (int i = 0; i < obj.length; i++) {
            Object argItem = obj[i];
            if (!(argItem instanceof HttpServletRequest) && !(argItem instanceof HttpServletResponse)) {
                result.put(param.get(i), argItem);
                if (i == 0) {
                    Method getUserId = argItem.getClass().getMethod("getUserId");

                    if (getUserId != null) {
                        getUserId.setAccessible(true);
                        Object invoke = getUserId.invoke(argItem, null);
                        System.out.println("invoke:" + invoke);
                    }
                }
            }
        }
        System.out.println(result.toJSONString());
        return jp.proceed(obj);


    }
}
