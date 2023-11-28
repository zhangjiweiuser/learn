package com.zhang.learn.chapter2023.chapter11.chapter1106;

public class QuanZhong {
    private static int[] def = new int[]{7, 3};

    public static void main(String[] args) {
        get();
    }

    private static void get() {
        int[] now = new int[]{8, 2};
        for (int i = 0; i < 10; i++) {
            int max = 0;
            for(int j = 1;j < def.length;j++){
                if(now[j] > now[max]){
                    max = j;
                }
            }
            System.out.println("这次选中的是:"+max);
            now[max] = now[max] - 10;
            for(int j = 0;j< def.length;j++){
                now[j] = now[j] + def[j];
            }
//            System.out.println(Arrays.toString(now));
        }
    }
}
