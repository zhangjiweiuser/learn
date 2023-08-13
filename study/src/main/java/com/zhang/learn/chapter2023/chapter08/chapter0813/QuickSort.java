package com.zhang.learn.chapter2023.chapter08.chapter0813;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,1,48,5,5,5,-2,18,20,5,5,5,5,15,12,-1,96};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        int l = left;
        int r = right;
        int pivot = arr[left];
        while(l < r){
            while(l < r && arr[r] >= pivot) {
                r--;
            }
            while(l < r && arr[l] <= pivot){
                l++;
            }
            if(l < r){
                int t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
            }
        }
        if(l != left){
            arr[left] = arr[l];
            arr[l] = pivot;
        }
        sort(arr,left,l-1);
        sort(arr,l+1,right);
    }
}
