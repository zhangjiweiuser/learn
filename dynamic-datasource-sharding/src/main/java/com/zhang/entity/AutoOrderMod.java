package com.zhang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("t_auto_order_mod")
public class AutoOrderMod {
    @TableId(type = IdType.ID_WORKER)
    private Long orderId;
    private BigDecimal price;
    private Long userId;
    private String status;
}
