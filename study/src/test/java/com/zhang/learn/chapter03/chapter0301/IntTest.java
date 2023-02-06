package com.zhang.learn.chapter03.chapter0301;

import com.google.common.math.IntMath;
import org.junit.jupiter.api.Test;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/1 11:32
 */
public class IntTest {
    @Test
    void intTest(){
        int a = IntMath.ceilingPowerOfTwo(9);
        System.out.println(a);
        int b = IntMath.floorPowerOfTwo(9);
        System.out.println(b);
    }
}
