package com.zhang.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.db.aware.SpringBeanUtil;
import com.zhang.db.dao.UserMapper;
import com.zhang.db.dto.UserDto;
import com.zhang.db.entity.User;
import com.zhang.db.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 9:58
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> findAllUser() {
        return baseMapper.findAllUser();
    }

    @Override
    public boolean saveUser(UserDto userDto) {
        UserService userService = SpringBeanUtil.getBean(UserService.class);

        return 1 == userService.insert(userDto);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPwd(userDto.getPwd());
        user.setAge(userDto.getAge());
        int num = baseMapper.insert(user);
        if (userDto.getAge() > 120) {
            throw new RuntimeException("年龄超过120岁了");
        }
        return num;

    }

    @Override
    public User addUser(User user) {
        return user;
    }
}
