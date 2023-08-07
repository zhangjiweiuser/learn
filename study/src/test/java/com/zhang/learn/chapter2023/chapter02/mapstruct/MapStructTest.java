package com.zhang.learn.chapter2023.chapter02.mapstruct;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-02 14:41
 */
public class MapStructTest {

    @Test
    public void mapStructTest(){
        Address address = new Address();
        address.setCity("北京");
        address.setProvince("北京");
        User user = new User.UserBuilder().id(1).name("张三").address("北京市").birth(LocalDateTime.now()).sexww(Sex.FEMALE).addr(address).build();
        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);
        System.out.println(userDto);
    }

    @Test
    public void mapStructToVoTest(){
        Address address = new Address();
        address.setCity("北京");
        address.setProvince("北京");
        User user = new User.UserBuilder().id(1).name("张三").address("北京市").birth(LocalDateTime.now()).sexww(Sex.FEMALE).addr(address).build();
        UserVo userVo = UserMapper.INSTANCE.userToUserVo(user);
        System.out.println(userVo);
    }
    @Test
    public void userTest(){
        User user = new User.UserBuilder().id(1).name("张三").address("北京市").birth(LocalDateTime.now()).build();
        User user2 = new User.UserBuilder().id(2).name("张三").address("北京市").birth(LocalDateTime.now()).build();
        User user3 = new User.UserBuilder().id(3).name("张三2").address("北京市").birth(LocalDateTime.now()).build();
        User user4 = new User.UserBuilder().id(4).name("").address("北京市").birth(LocalDateTime.now()).build();
        User user5 = new User.UserBuilder().id(5).name("").address("北京市").birth(LocalDateTime.now()).build();
        User user6 = new User.UserBuilder().id(6).name("张三2").address("北京市").birth(LocalDateTime.now()).build();
        ArrayList<User> users = Lists.newArrayList(user, user2, user3, user4, user5, user6);
        Map<String, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getName));
        System.out.println(collect);

        List<UserDto> userDtos = UserMapper.INSTANCE.userToUserDto(users);
        System.out.println(userDtos);
    }

    @Test
    public void strTest(){
        System.out.println(StringUtils.leftPad("abc", 5, "0"));
        System.out.println(StringUtils.leftPad("abcdef", 5, "0"));
    }
}
