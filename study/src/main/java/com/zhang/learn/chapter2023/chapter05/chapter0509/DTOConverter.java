package com.zhang.learn.chapter2023.chapter05.chapter0509;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-05-09 15:53
 */
public class DTOConverter {
    public static void main(String[] args) {
        userToDto();
    }

    private static void userToDto(){
        User user = new User();
        user.setId(1);
        user.setName("user1");
        user.setAge(15);
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        System.out.println(userDTO.toString());
    }
}
