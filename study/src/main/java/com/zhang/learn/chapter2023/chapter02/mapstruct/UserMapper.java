package com.zhang.learn.chapter2023.chapter02.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "sex", target = "sex",qualifiedByName = "getSex"),
            @Mapping(source = "birth", target = "birth", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "addr",target = "city",qualifiedByName = "getCity")
    })
    UserDto userToUserDto(User user);

    @Mappings({
            @Mapping(source = "sex", target = "sex",qualifiedByName = "getSex"),
            @Mapping(source = "addr",target = "city",qualifiedByName = "getCity")
    })
    UserVo userToUserVo(User user);
    default String getCity(Address address){
        if(null == address){
            return "未知";
        }
        return address.getCity();
    }
    default String getSex(Sex sex){
        if(null == sex){
            return "未知";
        }
        return sex.getDesc();
    }

    List<UserDto> userToUserDto(List<User> users);
}
