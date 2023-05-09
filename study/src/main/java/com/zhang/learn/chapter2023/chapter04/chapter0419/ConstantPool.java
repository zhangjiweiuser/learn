package com.zhang.learn.chapter2023.chapter04.chapter0419;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-04-19 21:29
 */
public class ConstantPool {
    private static List<String> notDealWithdrawCode = Lists.newArrayList("WD2023042401000006",
            "WD2023042401000004",
            "WD2023042401000003",
            "WD2023042401000002",
            "WD2023042201000007",
            "WD2023042101000009",
            "WD2023042101000007",
            "WD2023042101000006",
            "WD2023042001000003",
            "WD2023042001000002",
            "WD2023041901000001",
            "WD2023041701000015",
            "WD2023041701000013",
            "WD2023041701000011",
            "WD2023041701000009",
            "WD2023041701000007",
            "WD2023041701000006",
            "WD2023041401000009",
            "WD2023041401000006",
            "WD2023041301000004",
            "WD2023041301000002",
            "WD2023041201000012",
            "WD2023041201000010",
            "WD2023041201000009",
            "WD2023041201000008",
            "WD2023041201000007",
            "WD2023041101000015",
            "WD2023041101000014",
            "WD2023041101000013",
            "WD2023041001000023",
            "WD2023041001000021",
            "WD2023041001000019",
            "WD2023041001000017",
            "WD2023041001000016",
            "WD2023040801000006",
            "WD2023040701000009",
            "WD2023040701000007",
            "WD2023040701000006",
            "WD2023040601000008",
            "WD2023040601000006",
            "WD2023040601000004",
            "WD2023040401000033",
            "WD2023040401000031",
            "WD2023040401000029",
            "WD2023040401000028",
            "WD2023040401000027",
            "WD2023040401000025",
            "WD2023040401000023",
            "WD2023040401000020",
            "WD2023040401000019");
    public static void main(String[] args) {
        String s1 = new StringBuffer("计算机").append("原理").toString();
        String s2 = s1.intern();
        System.out.println(s1 == s2); // true

        String s3 = new StringBuffer("ja").append("va").toString();
        String s4 = s3.intern();
        System.out.println(s3 == s4); // false

        String s5 = new StringBuffer("计算科学").toString();
        String s6 = s5.intern();
        System.out.println(s5 == s6); // false

        System.out.println(notDealWithdrawCode.contains("WD2023040401000027"));
    }
}
