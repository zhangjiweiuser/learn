package com.zhang;

import com.zhang.entity.AutoOrderMod;
import com.zhang.service.AutoOrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Random;

@SpringBootTest
@Slf4j
public class OrderTest {
    @Resource
    AutoOrderService autoOrderService;

    @Test
    public void testInsertAutoOrderMod() {
        Random random = new Random();
        for (int i = 1; i < 10; i++) {
            AutoOrderMod order = new AutoOrderMod();
            order.setPrice(new BigDecimal(i));
            order.setUserId(Integer.valueOf(random.nextInt(25)).longValue());
            order.setStatus(String.valueOf(i));
            autoOrderService.save(order);
        }
    }

}
