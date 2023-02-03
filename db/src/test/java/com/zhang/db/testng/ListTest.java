package com.zhang.db.testng;

import com.google.common.base.Joiner;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/6 19:14
 */
public class ListTest {
    @Test
    void list2Str(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(null);
        list.add(3);
        String str = Joiner.on(",").skipNulls().join(list);
        System.out.println(str);
        List<Long> longList = Arrays.stream(str.split(",")).mapToLong(Long::valueOf).boxed().collect(Collectors.toList());
        System.out.println(longList);
    }
}
