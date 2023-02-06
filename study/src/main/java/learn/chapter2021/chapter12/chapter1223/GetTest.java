package learn.chapter2021.chapter12.chapter1223;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/12/23 15:44
 */
public class GetTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> {
            String forObject = restTemplate.getForObject("http://127.0.0.1:10008/rent/car/front/common/healthCheck", String.class);
            System.out.println(forObject);
        }, 0,1, TimeUnit.SECONDS);

    }
}
