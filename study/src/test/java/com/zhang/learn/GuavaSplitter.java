package com.zhang.learn;

import com.google.common.base.Splitter;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/9/8 11:32
 */
public class GuavaSplitter {
    public static void main(String[] args) {
        String str = ",,,,a,g";
        List<String> stringList = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(str);
        System.out.println(stringList);
        String[] arr = str.split(",");
        for(String s : arr){
            System.out.println(s);
        }
    }
}
