package com.zhang.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 9:55
 */
@Data
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String pwd;
    private Integer age;
}
