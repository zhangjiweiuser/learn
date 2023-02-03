package com.zhang.db;

import com.google.common.collect.Sets;
import org.assertj.core.util.Maps;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/26 15:29
 */
public class SetsTest {
    @Test
    public void setAddTest() {
        Set<Integer> sets = Sets.newHashSet(4427, 4881, 5569);
        System.out.println(sets.contains(4418));
        System.out.println(sets.contains(4881));
    }

    @Test
    public void mapTest() {
        Map<Integer, String> maps = Maps.newHashMap(10, "aa");
        System.out.println(maps.get(10));
        System.out.println(maps.get(11));
    }

    @Test
    public void instantTest() {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.getEpochSecond());
        System.out.println(now.toEpochMilli());
        System.out.println(System.currentTimeMillis());
        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8)));
    }

    @Test
    public void map2Test() {
        Map<Integer, Long> childTaskId2Clue = new HashMap<Integer, Long>() {{
            put(4427, 2026323L);
            put(4881, 2026324L);
            put(5569, 2026325L);
        }};
        String str = String.valueOf(childTaskId2Clue.get(4427));
        System.out.println(str);
    }
}
