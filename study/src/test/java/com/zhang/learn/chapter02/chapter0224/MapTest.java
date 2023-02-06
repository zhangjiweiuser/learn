package com.zhang.learn.chapter02.chapter0224;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/2/24 15:48
 */
public class MapTest {
    @Test
    void mapTest() {
        Map<String, String> map = new HashMap<>(4);
        map.put("a", "a");
        map.put("b", "b");
        System.out.println(map);

    }
}
