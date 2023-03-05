package com.zhang.learn.chapter2023.chapter03.chapter0303;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {

        } finally {
            lock.unlock();
        }

        ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock1.readLock();
        readLock.lock();
        readLock.unlock();
    }
}
