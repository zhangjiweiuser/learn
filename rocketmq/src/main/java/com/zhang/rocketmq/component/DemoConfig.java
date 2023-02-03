package com.zhang.rocketmq.component;

import com.zhang.rocketmq.service.DemoService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/4 13:44
 */
@Component
public class DemoConfig implements InitializingBean, DisposableBean {
    @Autowired
    private DemoService demoService;

    public DemoConfig() {
        System.out.println();
        System.out.println("constructor");
        System.out.println("属性:" + demoService);
        System.out.println();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println();
        System.out.println("destroy");
        System.out.println("属性demoService：" + (null != demoService));

        System.out.println();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println();
        System.out.println("afterPropertiesSet");
        System.out.println("属性demoService：" + (null != demoService));
        System.out.println();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println();
        System.out.println("@PostConstrut....");
        System.out.println("属性iDemoService已注入：" + (null != demoService));

        System.out.println();
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println();
        System.out.println("@PreDestroy.....");
        System.out.println("属性iDemoService已注入：" + (null != demoService));
        System.out.println();
    }

    public void init() {
        System.out.println();
        System.out.println("init-method by xml 配置文件");
        System.out.println("属性iDemoService已注入：" + (demoService != null));
        System.out.println();
    }

    public void cleanUp() {
        System.out.println();
        System.out.println("destroy-method by xml 配置文件");
        System.out.println("属性iDemoService已注入：" + demoService);
        System.out.println();
    }
}
