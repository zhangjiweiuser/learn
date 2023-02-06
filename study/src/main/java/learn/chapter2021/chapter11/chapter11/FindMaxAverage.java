package learn.chapter2021.chapter11.chapter11;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/11/11 10:58
 */
public class FindMaxAverage {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{0,1,1,3,3}, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {

        int total = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
            }
            if (total < sum) {
                total = sum;
            }
        }
        return total * 1.00000 / k;
    }
}
