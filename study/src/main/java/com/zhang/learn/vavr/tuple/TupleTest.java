package com.zhang.learn.vavr.tuple;

import com.google.common.collect.Lists;
import io.vavr.Tuple;
import io.vavr.Tuple1;
import io.vavr.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-01-13 16:19
 */
public class TupleTest {
    public static void main(String[] args) {
//        List<User> users = getUsers();
//        userStatistic(users);
//        arr();
        listToMap();
    }
    
    private static void listToMap(){
        List<Integer> list = Lists.newArrayList(1,2,3,4);
        Map<Integer, Integer> collect = list.stream().collect(Collectors.toMap(k->{
            System.out.println("k="+k);
            return k;
        }, v->{
            System.out.println("v="+v);
            return v*2;
        }));
        System.out.println(collect);
    }
    private static void arr() {
        List<String> collect = Stream.of("a", "b", "c", "aa", "ab")
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());
        System.out.println(collect);
        String[] arr = {"a", "b", "c", "aa", "ab"};
        List<String> collect2 = Stream.of(arr).filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());
        System.out.println(collect2);
        List<String> collect3 = Arrays.stream(arr).filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());
        System.out.println(collect3);
    }

    private static void tupleTest() {
        Tuple2<String, Integer> java = Tuple.of("java", 8);
        System.out.println(java._1);
        System.out.println(java._2);
        Tuple1<String> tem = Tuple.of("aa");
        System.out.println(tem._1);
    }

    private static void userStatistic(List<User> users) {
        Map<Integer, String> collect = users.stream().filter(u -> u.getAge() > 18)
                .collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getName, Collectors.joining(",", "[", "]"))));
        System.out.println(collect);

        Map<Integer, List<String>> collect2 = users.stream().filter(u -> u.getAge() > 18)
                .collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getName, Collectors.toList())));
        System.out.println(collect2);


        Map<Integer, List<User>> collect3 = users.stream().filter(u -> u.getAge() > 18)
                .collect(Collectors.groupingBy(User::getAge, Collectors.toList()));
        System.out.println(collect3);
    }

    private static List<User> getUsers() {
        return Lists.newArrayList(new User(1, "张三1", 18),
                new User(2, "张三2", 19),
                new User(3, "张三3", 20),
                new User(4, "张三4", 18),
                new User(5, "张三5", 20),
                new User(6, "张三6", 22));
    }
}
