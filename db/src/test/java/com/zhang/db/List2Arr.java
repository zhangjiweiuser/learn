package com.zhang.db;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/27 14:52
 */
public class List2Arr {
    @Test
    public void list2Arr(){
        List<String> strList = new ArrayList<>();
        strList.add("list");
        strList.add("to");
        strList.add("array");

        // ============== List 转换成 数组（方式1，推荐） =========================
        String[] strArray = new String[strList.size()];
        String[] strArray2 = strList.toArray(strArray);

        System.out.println("List 转换成数组（方式1，推荐），结果如下：");
        System.out.println(Arrays.toString(strArray2));

    }
}
