package com.zhang.learn.chapter2023.chapter07.chapter0717;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-07-17 18:46
 */
public class BiJiao {
    public static void main(String[] args) {
        String v1 = "1.1";
        String v2 = "2.1";
        System.out.println(compare(v1,v2));
    }
    public static int compare (String version1, String version2) {
        // write code here
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i=0;
        while(i < arr1.length && i < arr2.length){
            if(Integer.valueOf(arr1[i]) < Integer.valueOf(arr2[i])){
                return -1;
            }else if(Integer.valueOf(arr1[i]) > Integer.valueOf(arr2[i])){
                return 1;
            }
            i++;
        }
        if(i < arr1.length){
            for(int j=i;j<arr1.length;j++){
                if(Integer.valueOf(arr1[i]) > 0){
                    return 1;
                }
            }
        }
        if(i < arr1.length){
            for(int j=i;j<arr1.length;j++){
                if(Integer.valueOf(arr1[i]) > 0){
                    return 1;
                }
            }
        }if(i < arr1.length){
            for(int j=i;j<arr2.length;j++){
                if(Integer.valueOf(arr2[i]) > 0){
                    return -1;
                }
            }
        }
        return 0;
    }
}
