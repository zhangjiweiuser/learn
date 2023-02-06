package learn.chapter08.chapter0826;

import java.util.Arrays;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/26 15:05
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9};
        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));
    }

    private static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {

                digits[i]++;
                return digits;
            } else {

                digits[i] = 0;
            }
        }
        int[] result = new int[length + 1];
        result[0] = 1;
        return result;
    }
}
