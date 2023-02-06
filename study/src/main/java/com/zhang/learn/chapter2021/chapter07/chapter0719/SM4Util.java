package com.zhang.learn.chapter2021.chapter07.chapter0719;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/19 17:31
 */
public class SM4Util {
    public static void main(String[] args) {
        String content = "张三";
        String key = "1234567890123456";
        SymmetricCrypto sm4 = SmUtil.sm4(key.getBytes());
        String encrypt = sm4.encryptHex(content);
        System.out.println(encrypt);
        String decrypt = sm4.decryptStr(encrypt);
        System.out.println(decrypt);
    }
}
