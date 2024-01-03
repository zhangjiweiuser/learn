package com.zhang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_auto_role_mod")
public class AutoRoleMod {
    @TableId(type = IdType.ID_WORKER)
    private Long roleId;
    private String name;
}
