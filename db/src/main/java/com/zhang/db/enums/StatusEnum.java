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
public enum StatusEnum implements BaseEnum {

    OPEN(1, "正常"),
    DEL(2, "删除");

    @EnumValue
    private Integer code;
//    @JsonValue
    private String name;

    StatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @JsonCreator
    public static StatusEnum create(String code) {
        try {
            int code2 = Integer.parseInt(code);
            for (StatusEnum value : StatusEnum.values()) {
                if (value.code == code2) {
                    return value;
                }
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No element matches " + code);
        }
        throw new IllegalArgumentException("No element matches " + code);
    }

}
