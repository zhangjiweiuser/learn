package com.zhang.db.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/11 11:33
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RoleTypeEnum implements BaseEnum {

    MANAGER(1, "管理员"),
    GUEST(2, "访客");

    @EnumValue
//    @JsonValue
    private Integer code;
//    @JsonValue
    private String name;

    RoleTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static RoleTypeEnum create(Integer code) {
        try {

            for (RoleTypeEnum value : RoleTypeEnum.values()) {
                if (value.code == code.intValue()) {
                    return value;
                }
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No element matches " + code);
        }
        throw new IllegalArgumentException("No element matches " + code);
    }

}
