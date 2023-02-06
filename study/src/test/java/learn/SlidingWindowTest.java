package learn;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/10/20 10:10
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SlidingWindowTest {

    @Autowired
    private SlidingWindowService slidingWindowService;

    @Test
    public void overMaxCountTest() {
        boolean isOverMaxCount = slidingWindowService.overMaxCount("front", 5, 5);
        System.out.println(isOverMaxCount);
    }

    @Test
    public void canAccessTest() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {

            executor.submit(() -> {
                boolean isCanAccess = slidingWindowService.canAccess2("front", 5, 5);
                System.out.println(isCanAccess);
            });
        }

        TimeUnit.SECONDS.sleep(20);
    }
}
