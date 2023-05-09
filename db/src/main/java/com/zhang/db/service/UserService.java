package com.zhang.db.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.db.dto.UserDto;
import com.zhang.db.entity.User;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 9:57
 */
public interface UserService extends IService<User> {
    List<User> findAllUser();

    boolean saveUser(UserDto userDto);
    int insert(UserDto userDto);

    User addUser(User user);
}
