package com.zhang.learn.chapter2023.chapter02.mapstruct;

import lombok.Getter;

@Getter
public enum Sex {
    //
    MALE("男"),
    FEMALE("女");
    private String desc;

    Sex(String desc) {
        this.desc = desc;
    }


}
