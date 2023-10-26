package com.zhang.learn.chapter2023.chapter10.chapter1026;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZuHeZongHe {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        List<List<Integer>> ans = combine(9, 3,9);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combine(int n, int k,int target) {
        backtracking(k, target,1,0);
        return result;
    }

    public static void backtracking(int k, int target,int startIndex,int sum) {
        if(sum > target){
            return;
        }
        if (path.size() == k) {
            if(sum == target){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) +1; i++) {
            path.add(i);
            sum += i;
            backtracking(k,target, i + 1,sum);
            path.removeLast();
            sum -= i;
        }
    }
}
