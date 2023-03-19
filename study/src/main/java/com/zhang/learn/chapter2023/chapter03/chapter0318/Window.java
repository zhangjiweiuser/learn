package com.zhang.learn.chapter2023.chapter03.chapter0318;

import java.util.Arrays;
import java.util.LinkedList;

public class Window {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,6,7};
        int[] res = window(arr,4);
        System.out.println(Arrays.toString(res));
    }

    private static int[] window(int[] arr, int length) {
        if (null == arr || arr.length < length || length < 1) {
            return null;
        }
        // 存放的是arr的下标，值是从大到小
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - length + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() == i - length){ // i-w = 过期的下标
                qmax.pollFirst();
            }
            if(i >= length - 1){ // 这个时候说明达到了窗口length长度
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
