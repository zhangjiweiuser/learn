package com.zhang.learn.chapter2024.chapter07.chapter0716;

import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderUtil {
    public static void main(String[] args) {
        Order order = new Order();
        OrderItem orderItem1 = new OrderItem("101",100);
        OrderItem orderItem2 = new OrderItem("104",40);
        OrderItem orderItem3 = new OrderItem("101",100);
        OrderItem orderItem4 = new OrderItem("105",50);
        OrderDetail detail1 = new OrderDetail();
        detail1.setPeriod(1);
        detail1.setItemList(Lists.newArrayList(orderItem1,orderItem2));
        OrderDetail detail2 = new OrderDetail();
        detail2.setPeriod(2);
        detail2.setItemList(Lists.newArrayList(orderItem3,orderItem4));
        order.setOrderId("123456");
        order.setDetailList(Lists.newArrayList(detail1,detail2));

        Map<Integer, List<OrderItem>> collect = order.getDetailList().stream().collect(Collectors.toMap(OrderDetail::getPeriod, OrderDetail::getItemList));

        Map<Integer, Map<String, Integer>> collect1 = order.getDetailList().stream().collect(Collectors.toMap(OrderDetail::getPeriod,
                t -> t.getItemList().stream().collect(Collectors.toMap(OrderItem::getFeeNo, OrderItem::getAmount))));

        System.out.println(JSON.toJSONString(collect1));
    }
}
