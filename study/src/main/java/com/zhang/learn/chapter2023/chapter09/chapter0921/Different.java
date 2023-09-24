package com.zhang.learn.chapter2023.chapter09.chapter0921;

public class Different {
    public static void main(String[] args) {
        System.out.println(diff2(1,8));
        System.out.println(diff2(3,8));
    }
    private static int diff(int a,int b){
        String s = Integer.toBinaryString(a);
        String t = Integer.toBinaryString(b);
        int sl = s.length()-1;
        int tl = t.length()-1;
        int count = 0;
        while(sl >= 0 && tl >= 0){
            if(s.charAt(sl--) != t.charAt(tl--)){
                count++;
            }
        }
        while(sl >= 0){
            if(s.charAt(sl--) == '1'){
                count++;
            }
        }
        while (tl >= 0){
            if(t.charAt(tl--) == '1'){
                count++;
            }
        }
        return count;
    }
    private static int diff2(int a,int b){
        int xor = a ^ b;
        int count = 0;
        while(xor != 0){
            count += xor & 1;
            xor = xor >> 1;
        }
        return count;
    }
}
