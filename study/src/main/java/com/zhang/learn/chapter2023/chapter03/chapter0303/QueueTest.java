package com.zhang.learn.chapter2023.chapter03.chapter0303;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayBlockingQueue(10);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.poll();
        queue.poll();
        queue.add(50);
        queue.add(50);
        queue.add(50);
        queue.add(50);
        queue.add(50);
        queue.add(50);
        queue.add(50);
        queue.add(50);
        queue.add(50);
    }
}
