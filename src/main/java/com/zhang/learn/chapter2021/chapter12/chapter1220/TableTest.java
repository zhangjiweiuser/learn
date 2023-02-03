package com.zhang.learn.chapter2021.chapter12.chapter1220;

import com.google.common.collect.HashBasedTable;

import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/12/20 14:51
 */
public class TableTest {
    public static void main(String[] args) {
        HashBasedTable<String, String, String> table = HashBasedTable.create();
        table.put("a","a","a");
        table.put("a","b","b");
        table.put("a","c","c");
        table.put("d","d","d");
        Map<String, String> a = table.row("e");
        System.out.println(a == null);
        System.out.println(table.containsRow("f"));
    }
}
