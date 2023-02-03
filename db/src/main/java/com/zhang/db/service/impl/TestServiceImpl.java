package com.zhang.db.service.impl;

import com.zhang.db.annotation.OperateLog;
import com.zhang.db.dao.UserMapper;
import com.zhang.db.dto.UserDto;
import com.zhang.db.entity.User;
import com.zhang.db.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/28 13:58
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private UserMapper userMapper;

    @Async("asyncTaskExecutor")
    @Override
    public void asyncTask() {
        long start = System.currentTimeMillis();
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：void asyncTask()，耗时：" + (endTime - start));
    }

    @Async("asyncTaskExecutor")
    @Override
    public Future<String> asyncTask(String s) {
        long startTime = System.currentTimeMillis();
        try {
            //模拟耗时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：Future<String> asyncTask(String s)，耗时：" + (endTime - startTime));
        return AsyncResult.forValue(s);
    }

    @Async("asyncTaskExecutor")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void asyncTaskForTransaction(Boolean exFlag) {
        User user = new User();
        user.setUserName("zhaoliu");
        user.setPwd("123");
        user.setAge(140);
        int num = userMapper.insert(user);
        if (exFlag) {
            throw new RuntimeException("模拟异常");
        }
    }

    @Async("asyncTaskExecutor")
    @Override
    public String asyncTaskReturnString() {
        return "aaaa";
    }

    @OperateLog()
    @Override
    public void testAop(UserDto userDto,Long id) {
        System.out.println(userDto.toString());
    }
}
