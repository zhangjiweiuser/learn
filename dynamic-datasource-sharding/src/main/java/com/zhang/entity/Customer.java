package com.zhang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Customer {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
}
