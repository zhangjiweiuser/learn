package com.zhang.learn.chapter2023.chapter10.chapter1027;

import java.util.Arrays;

public class MaxArea {
    private static final int MOD = (int)1e9+7;
    public static void main(String[] args) {
        int[] horizontalCuts = {2};
        int[] verticalCuts = {2};
        System.out.println(maxArea(1000000000,1000000000,horizontalCuts,verticalCuts));
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hn = horizontalCuts.length;
        int wn = verticalCuts.length;
        int maxH = Math.max(horizontalCuts[0],h - horizontalCuts[hn-1]);
        int maxW = Math.max(verticalCuts[0],w - verticalCuts[wn-1]);

        for(int i=1;i<hn;i++){
            maxH = Math.max(maxH,horizontalCuts[i] - horizontalCuts[i-1]);
        }
        for (int i = 1; i < wn; i++) {
            maxW = Math.max(maxW,verticalCuts[i] - verticalCuts[i-1]);
        }
        return (int)((maxW *1L* maxH ) % MOD);
    }
}
