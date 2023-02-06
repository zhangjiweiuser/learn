package learn.chapter2021.chapter02.chapter0223;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/2/23 9:40
 */
public class AtomUtil {
    private static AtomicInteger count = new AtomicInteger(0);

    public static int add() {
        return count.getAndIncrement();
    }

    public static int decr() {
        return count.getAndDecrement();
    }
}
