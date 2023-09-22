package com.zhang.learn.chapter2023.chapter09.chapter0922;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 生成 N 个 1 到 500 的随机数，你需要删除掉其中重复的数字，即相同的数字只保留一个，把其余相同的数字去掉，然后再把这些数从小到大进行输出。
 *
 * @author zhangjiwei1
 * @description
 * @create 2023-09-22 9:10
 */
public class SuiJiPaiXu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        while(nextInt >0){
            list.add(scanner.nextInt());
            nextInt--;
        }
        List<Integer> result = paiXu(list);
        for(int i : result){
            System.out.print(i+" ");
        }
    }
    private static List<Integer> paiXu(List<Integer> list){
        System.out.println(list);
        int[] nums = new int[501];
        for(int i : list){
            nums[i] = 1;
        }
        list.clear();
        for(int i =0;i< nums.length;i++){
            if(nums[i] == 1){
                list.add(i);
            }
        }
        return list;
    }
}
