package com.zhang.learn.chapter2024.chapter04.chapter0430;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

public class StreamTest {
    public static void main(String[] args) {
        List<String> str = Lists.newArrayList("1","2","3","4");

        Integer i = str.stream().filter(t -> Integer.valueOf(t) > 2).map(Integer::valueOf).sorted().findFirst().orElse(-1);

        System.out.println(i);

        Optional<Integer> first = str.stream().filter(t -> Integer.valueOf(t) > 10).map(Integer::valueOf).sorted().findFirst();
        if(first.isPresent()){
            System.out.println(first.get());
        }else {
            System.out.println("不存在");
        }
    }
}
