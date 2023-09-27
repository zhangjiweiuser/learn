package com.zhang.learn.chapter2023.chapter09.chapter0926;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 两个人用手枪决斗.A的命中率是30％,B的命中率是50％.
 * 他们决定按这样的顺序：A先开一枪,未命中, 则B再开一枪, 如未命中,则A再开枪.
 * 这样循环,直到他们只剩下一个人.请用代码实现此方法，入参：无，返回值：A或者B，即本次调用谁会存活
 */
public class CunHuo2 {
    public static void main(String[] args) {
        cunHuo();
    }
    private static String cunHuo(){
        while (true){
            // A 先手
            int i = ThreadLocalRandom.current().nextInt(100);
            System.out.println("本次A是否击中:"+i);
            if(i < 30){
                // 说明A击中了B，A存活
                return "A";
            }
            // B 后手
            int j = ThreadLocalRandom.current().nextInt(100);
            System.out.println("本次B是否击中:"+j);
            if(j < 50){
                // 说明B击中了，B存活
                return "B";
            }

        }
    }
}
