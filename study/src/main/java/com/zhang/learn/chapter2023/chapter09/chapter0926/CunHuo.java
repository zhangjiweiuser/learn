package com.zhang.learn.chapter2023.chapter09.chapter0926;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 两个人用手枪决斗.A的命中率是30％,B的命中率是50％.
 * 他们决定按这样的顺序：A先开一枪,未命中, 则B再开一枪, 如未命中,则A再开枪.
 * 这样循环,直到他们只剩下一个人.请用代码实现此方法，入参：无，返回值：A或者B，即本次调用谁会存活
 */
public class CunHuo {

    private static volatile boolean over = false;

    private static final Object lock = new Object();

    public static void main(String[] args) {
        CunHuoTask cunHuoTask30 = new CunHuoTask(30, "A");
        CunHuoTask cunHuoTask50 = new CunHuoTask(50, "B");
        CunHuoTask cunHuoTask60 = new CunHuoTask(60, "C");
        new Thread(cunHuoTask30).start();
        new Thread(cunHuoTask50).start();
        new Thread(cunHuoTask60).start();
    }


    static class CunHuoTask implements Runnable {
        int num;
        String xuanShou;

        public CunHuoTask(int num, String xuanShou) {
            this.num = num;
            this.xuanShou = xuanShou;
//        this.nums = nums;
        }

        @Override
        public void run() {
            while (!over) {
                System.out.println(this.xuanShou + "进入 while");
                synchronized (lock) {
                    System.out.println(this.xuanShou + "进入synchronized");
                    lock.notifyAll();
                    if (!over) {
                        int i = ThreadLocalRandom.current().nextInt(1000);
                        System.out.println("选手" + this.xuanShou + ": " + i);
                        if (i < num) {
                            System.out.println(xuanShou + "存活");
                            over = true;
                            return;
                        }
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}

