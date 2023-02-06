package learn.chapter2021.chapter06.chapter0630;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/6/30 14:24
 */
public class Counter {

//    private final ReentrantLock lock = new ReentrantLock();

    private int count;

    public void incr() {
//        lock.lock();
        try {
            count++;
        } finally {
//            lock.unlock();
        }
    }

    public int getCount() {
//        lock.lock();
        try {

            return count;
        } finally {
//            lock.unlock();
        }
    }
}
