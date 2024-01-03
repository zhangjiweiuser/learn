package com.zhang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_auto_shop_mod")
public class Shop {

    @TableId(type = IdType.ID_WORKER)
    private Long shopId;
    private String name;
}
