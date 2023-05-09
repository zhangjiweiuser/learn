package com.zhang.db.service.impl;

import com.zhang.db.dto.UserDto;
import com.zhang.db.service.UserCacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-04-13 9:56
 */
@Service
public class UserCacheServiceImpl implements UserCacheService {
    @Override
    @Cacheable(value = "users", key = "#id+'_'+#age", unless = "#result == null")
    public UserDto getById(int id, int age) {
        UserDto user = new UserDto();
        user.setUserId(id);
        user.setUserName("hello");
        user.setPwd("hello");
        user.setAge(age);
        System.out.println("进入到getById");
        if (id > 20) {
            return null;
        }
        return user;
    }

    @Override
    @Cacheable(value = "username", key = "#id", unless = "#result == '' or #result == null")
    public String getName(int id) {
        System.out.println("getName:" + id);
        if (id > 50) {
            return null;
        } else if (id > 30) {
            return "";
        }
        return "name:" + id;
    }

    @Override
    @CacheEvict(value = "users", key = "#id")
    public void deleteById(int id) {
        System.out.println("删除id:" + id);
    }
}
