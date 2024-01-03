package com.zhang;

import com.zhang.entity.Shop;
import com.zhang.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class ShopTest {
    @Resource
    ShopService shopService;

    @Test
    public void testInsertAutoOrderMod() {
        for (int i = 1; i < 10; i++) {
            Shop shop = new Shop();
            shop.setName(String.valueOf(i));
            shopService.save(shop);
        }
    }

}
