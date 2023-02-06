package learn.chapter2022.chapter10.chapter1031;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-12-26 14:23
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = {72,15,95,16,45};
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    private static void quick(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        int j = partition(arr,left,right);
        quick(arr,left,j-1);
        quick(arr,j+1,right);
    }

    private static int partition(int[] arr,int left,int right){
        int pivot = arr[left];
        int j =  left;
        for(int i= left+1;i<=right;i++){
            if(arr[i] < pivot){
                swap(arr,i,++j);
            }
        }
        swap(arr,left,j);
        return j;
    }

    private static void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
