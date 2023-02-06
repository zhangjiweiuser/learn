package com.zhang.learn.chapter2021.chapter12.chapter1224;


import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/12/24 17:21
 */
public class PriorityQueueUtil {
    public static void main(String[] args) {
        PriorityQueue<Employee> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Employee(1, "AAA", LocalDate.now()));
        priorityQueue.add(new Employee(4, "CCC", LocalDate.now()));
        priorityQueue.add(new Employee(5, "BBB", LocalDate.now()));
        priorityQueue.add(new Employee(2, "FFF", LocalDate.now()));
        priorityQueue.add(new Employee(3, "DDD", LocalDate.now()));
        priorityQueue.add(new Employee(6, "EEE", LocalDate.now()));

        while (true) {
            Employee e = priorityQueue.poll();
            if (e == null) {
                break;
            } else {
                System.out.println(e);
            }
        }
    }
}
