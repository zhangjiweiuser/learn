package com.zhang.db.dto;

import com.zhang.db.enums.RoleTypeEnum;
import com.zhang.db.enums.StatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 10:10
 */
@Data
@Accessors(chain = true)
public class RoleDto {

    private String name;
    private RoleTypeEnum type;
    private StatusEnum status;
}
