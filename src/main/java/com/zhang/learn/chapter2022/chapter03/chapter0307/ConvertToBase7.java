package com.zhang.learn.chapter2022.chapter03.chapter0307;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-03-07 9:25
 */
public class ConvertToBase7 {
    public static void main(String[] args) {
        ConvertToBase7 convert = new ConvertToBase7();
        System.out.println(convert.convertToBase7(0));
        System.out.println(convert.convertToBase7(8));
        System.out.println(convert.convertToBase7(100));
        System.out.println(convert.convertToBase7(-100));
        System.out.println(convert.convertToBase7(-7));
        System.out.println(convert.convertToBase7(-6));
    }

    public String convertToBase7(int num) {
        StringBuffer sb = new StringBuffer();
        boolean numLt0 = false;
        if (num < 0) {
            num = -num;
            numLt0 = true;
        }

        do {
            sb.append(num % 7);
            num = num / 7;
        } while (num != 0);
        sb.reverse();
        if (numLt0) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
}
