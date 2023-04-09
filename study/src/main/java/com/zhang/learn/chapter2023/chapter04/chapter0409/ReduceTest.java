package com.zhang.learn.chapter2023.chapter04.chapter0409;

import java.util.stream.Stream;

public class ReduceTest {
    public static void main(String[] args) {
        int sum = Stream.of("a", "b", "c", "a")
                .mapToInt(s -> "a".equals(s) ? 1 : 0)
                .sum();
        System.out.println(sum);
        int sum2 = Stream.of("a", "b", "c", "a")
                .mapToInt(s -> "a".equals(s) ? 1 : 0)
                .reduce(0, Integer::sum);
        System.out.println(sum2);
    }
}
