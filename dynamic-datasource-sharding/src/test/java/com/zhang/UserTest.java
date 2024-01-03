package com.zhang;

import com.zhang.entity.User;
import com.zhang.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class UserTest {
    @Resource
    UserService userService;

    @Test
    public void testInsertUser() {
        for (int i = 1; i < 10; i++) {
            User user = new User();
            user.setName(String.valueOf(i));
            userService.save(user);
        }
    }

}
