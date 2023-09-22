package com.zhang.learn.chapter2023.chapter09.chapter0921;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-21 17:30
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        StringBuffer sb = new StringBuffer();
        while (i >= 0 && j >= 0) {
            int sum = (a.charAt(i--) - '0') + (b.charAt(j--) - '0') + carry;
            if (sum > 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(sum % 2);
        }
        while (i >= 0) {
            int sum = (a.charAt(i--) - '0') + carry;
            if (sum > 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(sum % 2);
        }
        while (j >= 0) {
            int sum = (b.charAt(j--) - '0') + carry;
            if (sum > 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(sum % 2);
        }
        if(carry == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
