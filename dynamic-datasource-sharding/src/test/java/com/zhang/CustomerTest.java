package com.zhang;

import com.zhang.entity.Customer;
import com.zhang.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class CustomerTest {
    @Resource
    CustomerService customerService;

    @Test
    public void testInsertCustomer() {
        for (int i = 1; i < 10; i++) {
            Customer customer = new Customer();
            customer.setName("顾客"+String.valueOf(i));
            customerService.save(customer);
        }
    }

}
