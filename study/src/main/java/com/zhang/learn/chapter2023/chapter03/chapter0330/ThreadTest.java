package com.zhang.learn.chapter2023.chapter03.chapter0330;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);
        OperationTask task1 = new OperationTask("taskList1");
        OperationTask task2 = new OperationTask("taskList2");
        OperationTask task3 = new OperationTask("taskList3");
        //使用线程池执行task
        executor.scheduleAtFixedRate(task1, 0, 5000, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(task2, 0, 5000, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(task3, 0, 5000, TimeUnit.MILLISECONDS);
        //构建消息list
        List<String> ipList = new ArrayList<>();
        ipList.add("1");
        ipList.add("2");
        ipList.add("3");
        ipList.add("4");
        ipList.add("5");
        ipList.add("6");
        ipList.add("7");
        ipList.add("8");
        ipList.add("9");
        ipList.add("10");
        ipList.add("11");
        ipList.add("12");
        ipList.add("13");
        ipList.add("14");
        ipList.add("15");
        ipList.add("16");
        //将消息Hash到对应的task中
        dispatchThread(task1, task2, task3, ipList);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //模拟第二次的消息消费
        dispatchThread(task1, task2, task3, ipList);

    }

    private static void dispatchThread(OperationTask task1, OperationTask task2,
                                       OperationTask task3, List<String> ipList) {
        for (String s : ipList) {
            int mod = Math.floorMod(s.hashCode(), 3);
            switch (mod) {
                case 1:
                    task1.addTask(s);
                    break;
                case 2:
                    task2.addTask(s);
                    break;
                case 3:
                    task3.addTask(s);
                    break;
                default:
                    task1.addTask(s);
                    break;
            }
        }
    }

    static class OperationTask implements Runnable {
        private final String name;

        public OperationTask(String name) {
            this.name = name;
        }

        private final Queue<String> taskQueue = new LinkedBlockingQueue();

        public void addTask(String task) {
            this.taskQueue.add(task);
        }

        @Override
        public void run() {
            System.out.println(name + "  start  " + Thread.currentThread().getId());
            int count = 0;
            while (!taskQueue.isEmpty()) {
                System.out.println("TaskOperator: " + name + " operate task : " + taskQueue.poll());
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
            }
        }
    }
}
