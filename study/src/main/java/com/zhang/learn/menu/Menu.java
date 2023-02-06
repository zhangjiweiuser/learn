package com.zhang.learn.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/8/20 16:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private int id;
    private String name;
    private int type;
    private String url;
    private int parentId;
    private int menuOrder;

    private List<Menu> child;
}
