package com.zhang.learn.chapter2023.chapter09.chapter0926;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个人用手枪决斗.A的命中率是30％,B的命中率是50％.
 * 他们决定按这样的顺序：A先开一枪,未命中, 则B再开一枪, 如未命中,则A再开枪.
 * 这样循环,直到他们只剩下一个人.请用代码实现此方法，入参：无，返回值：A或者B，即本次调用谁会存活
 */
public class CunHu3 {

    private static volatile boolean over = false;

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        CunHuoTask cunHuoTask30 = new CunHuoTask(30, "A", conditionA, conditionB);
        CunHuoTask cunHuoTask50 = new CunHuoTask(50, "B", conditionB, conditionC);
        CunHuoTask cunHuoTask60 = new CunHuoTask(60, "C", conditionC, conditionA);
        new Thread(cunHuoTask30).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(cunHuoTask50).start();
        new Thread(cunHuoTask60).start();
    }


    static class CunHuoTask implements Runnable {
        int num;
        String xuanShou;
        Condition cur;
        Condition next;

        public CunHuoTask(int num, String xuanShou, Condition cur, Condition next) {
            this.num = num;
            this.xuanShou = xuanShou;
            this.cur = cur;
            this.next = next;
//        this.nums = nums;
        }

        @Override
        public void run() {
            while (!over) {
                System.out.println(this.xuanShou + "进入 while");
                lock.lock();
                System.out.println(this.xuanShou + "进入synchronized");

                if (!over) {
                    int i = ThreadLocalRandom.current().nextInt(1000);
                    System.out.println("选手" + this.xuanShou + ": " + i);
                    if (i < num) {
                        System.out.println(xuanShou + "存活");
                        over = true;
                        return;
                    }
                    next.signal();
                    try {
                        cur.await();
                        lock.unlock();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}

