package com.zhang.db.service;

import com.zhang.db.dto.UserDto;

import java.util.concurrent.Future;

public interface TestService {

    /**
     * 异步调用，无返回值
     */
    void asyncTask();

    Future<String> asyncTask(String s);

    void asyncTaskForTransaction(Boolean exFlag);

    String asyncTaskReturnString();

    void testAop(UserDto userDto,Long id);
}
