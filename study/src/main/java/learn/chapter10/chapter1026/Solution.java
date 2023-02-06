package learn.chapter10.chapter1026;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/10/26 11:28
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
        stopWatch.stop();
        System.out.println(stopWatch.getNanoTime());
        stopWatch.reset();
        stopWatch.start();
//        System.out.println(Arrays.toString(smallerNumbersThanCurrent2(nums)));
        stopWatch.stop();
        System.out.println(stopWatch.getNanoTime());
        System.out.println(Arrays.toString(smallerNumbersThanCurrent3(nums)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int no = 0;
            for (int m : nums) {
                if (m < num) {
                    no++;
                }
            }
            result[i] = no;
        }
        return result;
    }

    public static int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    result[i]++;
                } else if (nums[i] < nums[j]) {
                    result[j]++;
                }
            }
        }
        return result;
    }

    public static int[] smallerNumbersThanCurrent3(int[] nums) {
        int[] arr = new int[nums.length];

        int[] arrCount = new int[101];
        for (int i = 0; i < nums.length; i++) {
            arrCount[nums[i]]++;
        }

        int count = 0;
        for (int i = 0; i < arrCount.length; i++) {
            if (arrCount[i] > 0) {
                int curCount = arrCount[i];

                arrCount[i] = count;

                count += curCount;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrCount[nums[i]];
        }

        return arr;
    }
}
