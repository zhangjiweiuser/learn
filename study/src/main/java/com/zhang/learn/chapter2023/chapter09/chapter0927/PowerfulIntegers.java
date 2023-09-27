package com.zhang.learn.chapter2023.chapter09.chapter0927;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
    public static void main(String[] args) {
        PowerfulIntegers power = new PowerfulIntegers();
        List<Integer> integers = power.powerfulIntegers(1, 1, 4000);
        System.out.println(integers);
    }
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= 20; i++) {
            int xc = xn(x, i);
            if (xc > bound) {
                break;
            }
            for (int j = 0; j <= 20; j++) {
                int res = xc + xn(y,j);
                if(res <= bound){
                    set.add(res);
                }else {
                    break;
                }
            }
        }
        return new ArrayList<>(set);
    }

    private int xn(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int res = 1;
        while (n > 0) {
            res = res * x;
            n--;
        }
        return res;
    }
}
