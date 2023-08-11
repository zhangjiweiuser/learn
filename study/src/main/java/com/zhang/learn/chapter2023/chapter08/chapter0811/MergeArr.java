package com.zhang.learn.chapter2023.chapter08.chapter0811;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-11 11:25
 */
public class MergeArr {
    public static void main(String[] args) {
        int[] A = {4,0,0,0,0,0};
        int[] B= {1,2,3,5,6};
        merge(A,1,B,5);
        System.out.println(Arrays.toString(A));
    }
    public static void merge(int A[], int m, int B[], int n) {
        int k = m;
        for(int i=m+n-1;i>=n;i--){
            A[i] = A[--m];
        }
        int i=n;
        int j=0;
        int t=0;
        while(i<k+n && j<n){
            if(A[i] <= B[j]){
                A[t++] = A[i++];
            }else{
                A[t++] = B[j++];
            }
        }
        if(j < n && t < m+n){
            while(j<n){
                A[t++] = B[j++];
            }
        }
    }
}
