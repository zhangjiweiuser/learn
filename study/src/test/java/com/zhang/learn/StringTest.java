package com.zhang.learn;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/1/7 13:38
 */
public class StringTest {

    @Test
    public void splitTest() {
        String lonLatStr = ",1";
        String[] lonLatSeg = lonLatStr.split(",");
        System.out.println(lonLatSeg.length);
    }

    @Test
    public void md5Test() {
        String password = DigestUtils.md5DigestAsHex("12345".getBytes());
        System.out.println(password);
        // 827ccb0eea8a706c4c34a16891f84e7b

        String password2 = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(password2);
        //1f32aa4c9a1d2ea010adcf2348166a04
    }

    @Test
    public void byteTest() throws UnsupportedEncodingException {
        System.out.println(Arrays.toString("12345".getBytes()));
        System.out.println(Arrays.toString(DigestUtils.md5Digest("12345".getBytes())));
        System.out.println(Arrays.toString(DigestUtils.md5Digest(DigestUtils.md5Digest("12345".getBytes()))));

        System.out.println(DigestUtils.md5DigestAsHex("12345".getBytes("utf8")));
        System.out.println(DigestUtils.md5DigestAsHex(DigestUtils.md5DigestAsHex("12345".getBytes("utf8")).getBytes("utf8")));

    }

    @Test
    public void shiroMd5Test() {
        String password = "12345";//明码
        String algorithmName = "MD5";//加密算法
        Object source = password;//要加密的密码

//        Object salt = "admin";//盐值，一般都是用户名或者userid，要保证唯一
        int hashIterations = 2;//加密次数

//        SimpleHash simpleHash = new SimpleHash(algorithmName,source,salt,hashIterations);
        SimpleHash simpleHash = new SimpleHash(algorithmName, source, null, hashIterations);
        System.out.println(simpleHash);//打印出经过盐值、加密次数、md5后的密码
        // aad43635bbd353cef6ea6546093fa0c7

    }

    @Test
    public void appendIfMissing() {
        System.out.println(StringUtils.appendIfMissing("经济", "型"));
        System.out.println(StringUtils.appendIfMissing("经济", "型", "济"));
        System.out.println(StringUtils.appendIfMissing("经济", "型", "经济"));
    }
    @Test
    public void capitalizeTest(){
        System.out.println(StringUtils.capitalize("zhang"));
        System.out.println(StringUtils.capitalize("Zhang"));
        System.out.println(StringUtils.capitalize("'zhang"));
        System.out.println(1<<22);
        System.out.println(1<<21);
        System.out.println((1<<28));
        System.out.println((1<<29));
    }
}
