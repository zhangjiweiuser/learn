package com.zhang.learn.chapter2023.chapter08.chapter0829;

import java.util.*;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-29 17:14
 */
public class FreqStack {
    public static void main(String[] args) {
        FreqStack stack1 = new FreqStack();
        stack1.push(5);
        stack1.push(7);
        stack1.push(5);
        stack1.push(7);
        stack1.push(4);
        stack1.push(5);
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
    }

    // 次数和 数
    private HashMap<Integer, List<Integer>> map = new HashMap();
    // 数和次数
    private HashMap<Integer, Integer> cnts = new HashMap<>();

    int max;


    public FreqStack() {

    }

    public void push(int val) {
        Integer count = cnts.getOrDefault(val, 0);
        cnts.put(val, count + 1);
        List<Integer> list = map.getOrDefault(count + 1, new ArrayList<>());
        list.add(val);
        map.put(count + 1, list);
        max = Math.max(max, count + 1);
    }

    public int pop() {
        List<Integer> list = map.get(max);
        int ans = list.remove(list.size()-1);
        cnts.put(ans, cnts.get(ans)-1);
        if(list.size() == 0){
            max--;
        }
        return ans;
    }
}
