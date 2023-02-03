package com.zhang.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zhang.db.enums.RoleTypeEnum;
import com.zhang.db.enums.StatusEnum;
import lombok.Data;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 9:55
 */
@Data
public class Role {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;

    private RoleTypeEnum type;
    private StatusEnum status;
}
