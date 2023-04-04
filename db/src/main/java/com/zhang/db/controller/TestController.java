package com.zhang.db.controller;

import com.zhang.db.dto.UserDto;
import com.zhang.db.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/28 14:07
 */
@Slf4j
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/testLog")
    public void testLog(){
        log.info("testLog");
    }

    @GetMapping("asyncTask1")
    public void asyncTask() {
        long startTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");

        //无返回值
        testService.asyncTask();

        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：调用异步业务结束，耗时：" + (endTime - startTime));
    }

    @GetMapping("asyncTask2")
    public void asyncTask(String s) {
        long startTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");

        //无返回值
        testService.asyncTask("a");

        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：调用异步业务结束，耗时：" + (endTime - startTime));
    }

    @GetMapping("asyncTask3")
    public void asyncTask3(String s) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");

        //无返回值
        Future<String> result = testService.asyncTask("a");
        System.out.println(result.get());
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：调用异步业务结束，耗时：" + (endTime - startTime));
    }

    @GetMapping("asyncTask4")
    public void asyncTaskForTransaction(Boolean exFlag) {
        long startTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");

        //无返回值
        testService.asyncTaskForTransaction(true);

        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：调用异步业务结束，耗时：" + (endTime - startTime));
    }

    @GetMapping("asyncTaskReturnString")
    public void asyncTaskReturnString() {
        long startTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");

        //无返回值
        String s = testService.asyncTaskReturnString();
        System.out.println("s:" + s);
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：调用异步业务结束，耗时：" + (endTime - startTime));
    }

    @GetMapping("testAop")
    public void testAop() {
        UserDto userDto = new UserDto();
        userDto.setUserName("张三");
        userDto.setUserId(105);
        //无返回值
        testService.testAop(userDto,10L);
    }

    @GetMapping("/testSentinel")
    public String testSentinel(){
        return testService.testSentinel();
    }
}
