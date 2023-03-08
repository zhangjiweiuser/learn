package com.zhang.learn.chapter2023.chapter03.chapter0309;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5,7,1,4,6,7,8,0};
        heap(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heap(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while(heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }

    }
    private static void heapInsert(int[] arr,int index){
        while(arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index -1) /2;
        }
    }
    private static void swap(int[] arr,int i,int j){
        if(i != j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    private static void heapify(int[] arr,int index,int heapSize){
        // 左孩子节点
        int left = index * 2 + 1;
        // 说明左孩子节点存在
        while(left < heapSize){
            // 将左右孩子节点中值较大的复制给largest
            int largest = left+1<heapSize && arr[left+1] > arr[left] ? left+1:left;
            // 将孩子节点中较大的和父节点进行比较
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arr,largest,index);
            left = largest * 2 +1;
        }
    }
}
