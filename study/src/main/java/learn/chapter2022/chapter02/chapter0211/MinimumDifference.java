package learn.chapter2022.chapter02.chapter0211;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-02-11 9:35
 */
public class MinimumDifference {
    public static void main(String[] args) {
        MinimumDifference difference = new MinimumDifference();
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        System.out.println(difference.minimumDifference(nums, k));
    }

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (nums[i + k - 1] - nums[i] < min) {
                min = nums[i + k - 1] - nums[i];
            }
        }
        return min;
    }
}
