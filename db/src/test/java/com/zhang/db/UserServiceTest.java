package com.zhang.db;

import com.zhang.db.dto.UserDto;
import com.zhang.db.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 10:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getAllTest() {
        System.out.println(userService.findAllUser());
    }

    @Test
    public void saveTest() {
        UserDto user = new UserDto().setUserName("lisi")
                .setPwd("456").setAge(190);
        System.out.println("是否成功:" + userService.saveUser(user));
    }
}
