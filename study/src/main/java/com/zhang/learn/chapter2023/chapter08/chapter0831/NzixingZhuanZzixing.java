package com.zhang.learn.chapter2023.chapter08.chapter0831;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-31 14:13
 */
public class NzixingZhuanZzixing {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",4));
    }

    /**
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     * <p>
     * <p>
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] result = new String[numRows];
        Arrays.fill(result, "");
        int index = 0;
        boolean isDown = false;
        for (int i = 0; i < s.length(); i++) {
            result[index] += s.charAt(i);
            if (index == 0 || index == numRows - 1) {
                // 第一次index=0，isDown修改为true，说明可以继续往下走，当index=numRows的时候，说明不能继续往下走，然后把isDown修改为false
                isDown = !isDown;
            }
            index += isDown ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< result.length;i++){
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
