package com.zhang.db.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 10:10
 */
@Data
@Accessors(chain = true)
public class UserDto {

    private String userName;
    private String pwd;
    private Integer age;
    private Integer userId;
}
