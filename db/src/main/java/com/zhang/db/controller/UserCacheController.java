package com.zhang.db.controller;

import com.zhang.db.dto.UserDto;
import com.zhang.db.service.UserCacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 10:02
 */
@RestController
public class UserCacheController extends BaseController{
    @Resource
    private UserCacheService userCacheService;

    @GetMapping("/getById")
    public UserDto getById(int id, int age) {
        return userCacheService.getById(id,20);
    }

    @GetMapping("/deleteById")
    public void deleteById(int id) {
        userCacheService.deleteById(id);
    }

    @GetMapping("/getName")
    public String getName(int id) {
        return userCacheService.getName(id);
    }
}
