package com.zhang.learn.chapter2023.chapter03.chapter0331;

import java.util.concurrent.*;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-03-31 14:39
 */
public class TimeWheel implements Timer {

    private ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private BlockingQueue<TimerTaskWrapper> addQueue = new ArrayBlockingQueue<>(128);
    // 每一个tick时间间隔默认1毫秒
    private final long duration;
    // 时间轮启动时间
    private volatile long startTime;

    private Thread timeWheelThread;

    private CountDownLatch startLatch = new CountDownLatch(1);
    // 时间轮的tick数量
    private int tickNum = 128;

    private Bucket[] buckets;

    private boolean started = false;

    public TimeWheel(long duration, TimeUnit unit) {
        long nanos = unit.toNanos(duration);
        if (TimeUnit.MILLISECONDS.toNanos(1) > nanos) {
            this.duration = 1;
        } else {
            this.duration = unit.toMillis(duration);
        }
        this.timeWheelThread = new Thread(new Worker());
        this.buckets = new Bucket[tickNum];
        for (int i = 0; i < tickNum; i++) {
            this.buckets[i] = new Bucket();
        }
    }

    @Override
    public void createTimeTask(TimerTask task, long delay, TimeUnit unit) {
        start();
        long deadline = System.currentTimeMillis() + unit.toMillis(delay) - startTime;
        System.out.println("deadline = " + deadline);
        addQueue.offer(new TimerTaskWrapper(task, deadline));
    }

    private void start() {
        if (started) {
            return;
        }
        started = true;
        timeWheelThread.start();
        try {
            startLatch.await();
            System.out.println("启动完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 处理时间轮的转动
    class Worker implements Runnable {
        // 记录tick的次数
        private long tick;

        @Override
        public void run() {
            startTime = System.currentTimeMillis();
            startLatch.countDown();
            System.out.println("worker 启动完成。。。");
            for (; ; ) {
                long time = nextTick();
                if (time <= 0) {
                    continue;
                }
                int bucketIndex = (int) (tick & (tickNum - 1));
                System.out.println("bucketIndex = " + bucketIndex);
                Bucket bucket = buckets[bucketIndex];
                // 处理阻塞队列中的task
                doHandleQueueTask();
                // 处理过期数据
                bucket.expire(time);
                tick++;
            }
        }

        private void doHandleQueueTask() {
            for (int i = 0; i < 1024; i++) {
                TimerTaskWrapper taskWrapper = addQueue.poll();
                // 队列为空
                if (taskWrapper == null) {
                    break;
                }
                long taskTicks = taskWrapper.deadline / duration;
                taskWrapper.rounds = (taskTicks - tick) / tickNum;
                final long ticks = Math.max(taskTicks, tick);
                int bucketIndex = (int) (ticks & (tickNum - 1));
                System.out.println("insert bucketIndex = " + bucketIndex);
                Bucket bucket = buckets[bucketIndex];
                bucket.addTimerTask(taskWrapper);
            }
        }

        private long nextTick() {
            long deadline = duration * (tick + 1);
            for (; ; ) {
                long current = System.currentTimeMillis() - startTime;
                long sleepTime = deadline - current;
                if (sleepTime <= 0) {
                    return current;
                }
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class TimerTaskWrapper implements Runnable {

        private TimerTask task;
        // 任务执行截止时间
        protected long deadline;
        // 多少圈
        protected long rounds;
        TimerTaskWrapper prev;
        TimerTaskWrapper next;

        public TimerTaskWrapper(TimerTask task, long deadline) {
            this.task = task;
            this.deadline = deadline;
        }

        @Override
        public void run() {
            task.run();
        }

        public void expire() {
            service.execute(this);
        }
    }

    class Bucket {
        TimerTaskWrapper head;
        TimerTaskWrapper tail;

        public void addTimerTask(TimerTaskWrapper task) {
            if (task == null) {
                return;
            }
            if (head == null) {
                tail = task;
                head = tail;
            } else {
                tail.next = task;
                task.prev = tail;
                tail = task;
            }
        }

        public TimerTaskWrapper removeTimerTask(TimerTaskWrapper task) {
            TimerTaskWrapper next = task.next;
            if (task.prev != null) {
                task.prev.next = next;
            }
            if (task.next != null) {
                task.next.prev = task.prev;
            }

            if (task == head) {
                if (task == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = next;
                }
            } else if (task == tail) {
                tail = tail.prev;
            }
            task.prev = null;
            task.next = null;
            return next;
        }

        public void expire(long deadline) {
            TimerTaskWrapper task = head;
            while (task != null) {
                TimerTaskWrapper next = task.next;
                if (task.rounds <= 0) {
                    next = removeTimerTask(task);
                    if (task.deadline <= deadline) {
                        task.expire();
                    }
                } else {
                    // 减少时间轮的圈数
                    task.rounds--;
                }
                task = next;
            }
        }
    }
}
