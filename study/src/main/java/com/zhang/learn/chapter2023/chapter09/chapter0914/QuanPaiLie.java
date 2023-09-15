package com.zhang.learn.chapter2023.chapter09.chapter0914;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QuanPaiLie {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] used = new int[3];
        Arrays.fill(used, 0);
        backtracking(arr, used);
        System.out.println("------------");
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static void backtracking(int[] arr, int[] used) {
        System.out.println("第一行 path:"+path+",used:"+Arrays.toString(used));
        if(path.size() == arr.length){
            result.add(new ArrayList<>(path));
            return;
        }
        System.out.println("path:"+path+",used:"+Arrays.toString(used));
        for(int i=0;i<arr.length;i++){
            if(used[i] == 1){
                continue;
            }
            used[i] = 1;
            path.add(arr[i]);
            backtracking(arr,used);
            System.out.println("backtracking end path:"+path+",used:"+Arrays.toString(used)+",i="+i);
            path.removeLast();
            used[i] = 0;
            System.out.println("backtracking remove 后 path:"+path+",used:"+Arrays.toString(used)+",i="+i);
        }
    }
}
