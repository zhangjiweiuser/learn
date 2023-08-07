package com.zhang.learn.chapter2023.chapter05.chapter0510;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-05-10 11:03
 */
public class FlatMapUtil {
    public static void main(String[] args) {
        list();
    }

    private static void list(){
        List<List<Integer>> result = new ArrayList<>();
        result.add(Lists.newArrayList(1));
        result.add(Lists.newArrayList(21,22));
        result.add(Lists.newArrayList(3));
        result.add(Lists.newArrayList(41,42));
        result.add(Lists.newArrayList(5));
        System.out.println(result);
        List<Integer> collect = result.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect);
    }
}
