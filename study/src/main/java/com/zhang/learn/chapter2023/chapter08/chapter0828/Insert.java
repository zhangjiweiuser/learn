package com.zhang.learn.chapter2023.chapter08.chapter0828;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-28 17:19
 */
public class Insert {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2,5};
        int[][] result = insert(intervals, newInterval);
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] tmp = intervals[i];
            if(newInterval[0] < tmp[0] || newInterval[1] < tmp[0]){
                if(newInterval[0] < list.get(list.size()-1)[1] ){
                    if(newInterval[0] < list.get(list.size()-1)[0]){
                        list.get(list.size()-1)[0] = newInterval[0];
                    }
                    if(newInterval[1] > list.get(list.size()-1)[1]){
                        list.get(list.size()-1)[1] = newInterval[1];
                    }
                }else{
                    list.add(newInterval);
                    list.add(tmp);
                }
            }else {
                list.add(tmp);
            }
        }
        if(newInterval[0] > intervals[intervals.length-1][0]){
            list.add(newInterval);
        }
        for (int[] a : list) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("------------");
        return intervals;
    }
}
