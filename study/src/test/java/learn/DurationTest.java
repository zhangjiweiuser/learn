package learn;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/9/25 10:55
 */
public class DurationTest {
    public static void main(String[] args) {
        LocalDateTime realPickupTime = LocalDateTime.of(2020,9,25,10,0,0);
        LocalDateTime realReturnTime = LocalDateTime.of(2020,9,25,11,0,0);
        long minutes = Duration.between(realPickupTime, realReturnTime).toMinutes();
        System.out.println(minutes);
    }
}
