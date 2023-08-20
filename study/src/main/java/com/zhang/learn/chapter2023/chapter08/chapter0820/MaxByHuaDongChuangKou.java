package com.zhang.learn.chapter2023.chapter08.chapter0820;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxByHuaDongChuangKou {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        List<Integer> result = max(arr,3);
        System.out.println(result);
    }

    private static List<Integer> max(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        deque.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                deque.clear();
            }
            deque.add(arr[i]);

            if (i >= k - 1) {
                if(deque.size() > k){
                    deque.removeFirst();
                }else if(deque.size() == k){
                    result.add(deque.removeFirst());
                }else{
                    result.add(deque.peekFirst());
                }
            }
        }
        return result;
    }
}
