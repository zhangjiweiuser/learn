package com.zhang.learn.chapter2021.chapter07.chapter0702;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/2 14:31
 */
public class MaskUtil {
    public static void main(String[] args) {
        String name = "张三";
        System.out.println(MaskType.NAME.mask(name));
        String idCard = "415689521456986542";
        System.out.println(MaskType.ID_CARD.mask(idCard));
    }
}
