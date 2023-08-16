package com.zhang.learn.chapter2023.chapter08.chapter0814;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-15 14:38
 */
public class TimeRequiredToBuy {
    public static void main(String[] args) {
        int[] tickets = {5,1,1,1};
        int k = 0;
        System.out.println(timeRequiredToBuy(tickets, k));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int r = 0;int len = tickets.length;int i=0;
        while (tickets[k] > 0) {
            if(tickets[i%len] > 0){
                r++;
                tickets[i%len] = tickets[i%len] -1;
                i++;
            }else{
                i++;
            }
        }
        return r;
    }
}
