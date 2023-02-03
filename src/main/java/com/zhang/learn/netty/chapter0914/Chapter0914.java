package com.zhang.learn.netty.chapter0914;

import io.netty.util.NettyRuntime;

import java.nio.IntBuffer;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/9/14 14:17
 */
public class Chapter0914 {
    public static void main(String[] args) {
//        IntBuffer intBuffer = IntBuffer.allocate(5);
//        for (int i = 0; i < intBuffer.capacity(); i++) {
//            intBuffer.put(i * 5);
//        }
//        // 从buffer冲取数据
//        // 将buffer转换，进行读写切换
//        intBuffer.flip();
//        while (intBuffer.hasRemaining()) {
//            System.out.println(intBuffer.get());
//        }

        System.out.println();
        System.out.println(NettyRuntime.availableProcessors());
    }
}
