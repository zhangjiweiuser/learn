package learn.chapter2022.chapter03.chapter0314;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-03-14 15:26
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-4, -2, 0, 2, 4, 5};
        SortedSquares squares = new SortedSquares();
        System.out.println(Arrays.toString(squares.sortedSquares(nums)));
    }

    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                result[index--] = nums[right] * nums[right];
                right--;
            } else {
                result[index--] = nums[left] * nums[left];
                left++;
            }
        }
        return result;
    }
}
