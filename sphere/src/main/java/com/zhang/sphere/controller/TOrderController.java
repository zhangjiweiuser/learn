package com.zhang.sphere.controller;

import com.zhang.sphere.entity.TOrder;
import com.zhang.sphere.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhangjiwei
 * @since 2023-12-01
 */
@RestController
@RequestMapping("/order")
public class TOrderController {

    @Autowired
    private TOrderService itOrderService;

    @GetMapping("add")
    public String add() {
        for (int i = 0; i < 100; i++) {

            TOrder order = TOrder.builder()
                    .userId(i + 1)
                    .description("测试订单").build();

            itOrderService.save(order);
        }
        return "ok";
    }
//    @GetMapping("list")
//    public String list() {
//        return itOrderService.list().stream()
//                .map(tOrder -> tOrder.toString() + "<br>").collect(toList()).toString();
//    }
}
