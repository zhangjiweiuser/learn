package com.zhang.learn.chapter2021.chapter11.chapter09;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/11/9 15:37
 */
public class InsertSql {
    public static void main(String[] args) {
        String sql = "INSERT INTO `tenant_user_store`(`tenant_id`, `tenant_user_id`, `store_id`, `is_del`, `created_stime`, `modified_stime`) VALUES (2, %d, %d, 0, now(), now());";
        List<Integer> storeId = Lists.newArrayList(69, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 85);
        for (int i = 13; i <= 16; i++) {
            for (Integer store : storeId) {
                System.out.println(String.format(sql, i, store));
            }
        }

    }
}
