package com.zhang.learn.chapter2023.chapter03.chapter0331;

import java.util.concurrent.TimeUnit;

public interface Timer {

    void createTimeTask(TimerTask task, long delay, TimeUnit unit);
}
