package com.zhang.learn.controller;

import com.zhang.learn.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/12/30 14:05
 */
@RestController
public class RestTemplateController {

    @GetMapping("/getUser")
    public User getUser(int id) {
        User user = new User();
        user.setId(id);
        user.setName("name" + id);
        return user;
    }

    @GetMapping("/getUser2")
    public User getUser2(@RequestParam(name = "id") int id) {
        User user = new User();
        user.setId(id);
        user.setName("name" + id);
        return user;
    }

    @PostMapping("/postUser")
    public User postUser(@RequestParam int id) {
        User user = new User();
        user.setId(id);
        user.setName("name" + id);
        return user;
    }

    @PostMapping("/postUser1")
    public User postUser1(int id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    @PostMapping("/postUser2")
    public User postUser2(@RequestBody User user) {

        return user;
    }
}
