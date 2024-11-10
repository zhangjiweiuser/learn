package com.zhang.learn.chapter2024.chapter06.chapter0605;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {

    private List<User> userList = new ArrayList<>();
    @BeforeEach
    public void init(){
        userList.add(new User("1001","小A",95));
        userList.add(new User("1001","小B",99));
        userList.add(new User("1002","小c",92));
        userList.add(new User("1003","小D",93));
    }

    @Test
    public void list2Map(){
        Map<String, User> collect = userList.stream().collect(Collectors.toMap(User::getId, Function.identity(), (k1, k2) -> k1));
        System.out.println(collect);
    }
    @Test
    public void mapping(){
        String collect = userList.stream().collect(Collectors.mapping(User::getName, Collectors.joining(",", "[", "]")));
        System.out.println(collect);
        String collect1 = userList.stream().map(User::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect1);
    }
    @Test
    public void map2Int() throws ParseException {
//        Map<String, Integer> collect = userList.stream().collect(Collectors.groupingBy(User::getId, Collectors.summingInt(User::getScore)));
//        Map<String, Integer> collect2 = userList.stream().collect(Collectors.groupingBy(User::getId, Collectors.reducing(0,User::getScore,Integer::sum)));
//        System.out.println(collect);
//        System.out.println(collect2);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        System.out.println(formatter.parse("20240301"));


    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class User{
        private String id;
        private String name;
        private Integer score;
    }
}
