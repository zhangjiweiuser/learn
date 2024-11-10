package com.zhang.activiti6.config;

import org.activiti.engine.impl.asyncexecutor.DefaultAsyncJobExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;

@Configuration
public class ActivitiConfig {
    @Bean
    public ExecutorService executorService(){
        ThreadPoolExecutorFactoryBean factoryBean = new ThreadPoolExecutorFactoryBean();
        factoryBean.setCorePoolSize(10);
        factoryBean.setMaxPoolSize(20);
        factoryBean.setQueueCapacity(100);
        return factoryBean.getObject();
    }
    @Bean
    public DefaultAsyncJobExecutor asyncJobExecutor(ExecutorService executorService){
        DefaultAsyncJobExecutor defaultAsyncJobExecutor = new DefaultAsyncJobExecutor();
        defaultAsyncJobExecutor.setExecutorService(executorService);
        return defaultAsyncJobExecutor;

//         <bean id="asyncExecutor"
//        class="org.activiti.engine.impl.asyncexecutor.DefaultAsyncJobExecutor">
//            <!-- 需要配置一个服务 基于spring去配置它 -->
//            <property name="executorService" ref="executorService"/>
//        </bean>
//        <bean id="executorService" class="org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean">
//            <property name="threadNamePrefix" value="activiti-job-"/>
//            <property name="corePoolSize" value="10"/>
//            <property name="maxPoolSize" value="20"/>
//            <property name="queueCapacity" value="100"/>
//            <!-- 设置当线程池满了时候的拒绝策略,这里是使用的默认策略，抛出异常 -->
//            <property name="rejectedExecutionHandler">
//                <bean class="java.util.concurrent.ThreadPoolExecutor$AbortPolicy"/>
//            </property>
//        </bean>
    }
}
