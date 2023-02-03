package com.zhang.learn.chapter2021.chapter11.chapter22;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/11/22 16:44
 */
public class List2Arr {
    public static void main(String[] args) {
//        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
//        Integer[] arr = list.toArray(new Integer[0]);
//        for(Integer in : arr){
//            System.out.println(in);
//        }
//        System.out.println("--------------");
//        Integer[] arr2 = new Integer[list.size()];
//        Integer[] arr3 = list.toArray(arr2);
//        for(Integer in2 : arr2){
//            System.out.println(in2);
//        }
//        System.out.println("--------------");
//        for(Integer in3 : arr3){
//            System.out.println(in3);
//        }

//        Table.Cell<String, String, String> cell = Tables.immutableCell("a", "b", "c");
//        System.out.println(cell.getRowKey());
//        System.out.println(cell.getValue());
        long[] dealerIds = {1, 2, 3};
        String collect = LongStream.of(dealerIds).distinct().mapToObj(String::valueOf).collect(Collectors.joining(","));

        System.out.println(collect);

    }
}
