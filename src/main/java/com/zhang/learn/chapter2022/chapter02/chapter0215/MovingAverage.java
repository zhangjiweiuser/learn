package com.zhang.learn.chapter2022.chapter02.chapter0215;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-02-15 19:54
 */
public class MovingAverage {
    public static void main(String[] args) {
        MovingAverage average = new MovingAverage(3);
        System.out.println(average.next(1));
        System.out.println(average.next(10));
        System.out.println(average.next(3));
        System.out.println(average.next(5));
    }

    private List<Integer> list = new ArrayList<>();
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (list.size() < this.size) {
            list.add(val);
        } else {
            list.remove(0);
            list.add(val);
        }
        return 1.0 * list.stream().mapToInt(t -> t).sum() / list.size();
    }
}
