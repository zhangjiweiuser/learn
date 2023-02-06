package learn.chapter2021.chapter06.chapter0630;

import java.util.concurrent.*;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/6/30 15:10
 */
public class ExecutorsTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
        for (int i = 0; i < 6; i++) {
            executor.execute(()->{
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+"执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }
}
