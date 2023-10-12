package com.zhang.learn.chapter2023.chapter09.chapter0928;

import java.util.Arrays;

public class FullBloomFlowers {
    public static void main(String[] args) {
        int[][] flowers = {{1, 6}, {3, 7}, {9, 12}, {4, 13}};
        int[] people = {2, 3, 7, 11};
        int[] ints = fullBloomFlowers(flowers, people);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int max = 0;
        for (int[] in : flowers) {
            max = Math.max(in[1], max);
        }
        int[] tmp = new int[max + 1];
        for (int[] in : flowers) {
            for (int i = in[0]; i <= in[1]; i++) {
                tmp[i]++;
            }
        }
        int t = 0;
        int[] result = new int[people.length];
        for (int k : people) {
            if (k > tmp.length) {
                result[t++] = 0;
            } else {
                result[t++] = tmp[k];

            }
        }
        return result;
    }

/*    public static int[] fullBloomFlowers2(int[][] flowers, int[] people) {

    }*/
}
