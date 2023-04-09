package com.zhang.learn.chapter2023.chapter04.chapter0409;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByTest {
    public static void main(String[] args) {
        Map<String, Map<String, List<Person>>> map = Stream.of(
                new Person("张三", 18, 180),
                new Person("张三", 14, 180),
                new Person("张三", 16, 180),
                new Person("张三", 20, 180),
                new Person("李四", 3, 180),
                new Person("李四", 19, 180),
                new Person("李四", 6, 180),
                new Person("李四", 22, 180)
        ).collect(Collectors.groupingBy(Person::getName, Collectors.groupingBy(p -> p.getAge() >= 18 ? "成年" : "未成年")));
        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((k1, v1) -> {
                System.out.println("\t" + k1 + "=" + v1);
            });
        });
    }
}
