package com.zhang.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.entity.User;
import com.zhang.mapper.UserMapper;
import com.zhang.service.UserService;
import org.springframework.stereotype.Service;
@DS("db_3")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
