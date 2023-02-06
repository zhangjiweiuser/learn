package learn.chapter2022.chapter12.chapter1228;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-12-28 14:56
 */
public class AvgArr {
    public static void main(String[] args) {
        int[] arr = {1, 12, -5, -6, 50, 3};
        System.out.println(maxAvg(arr, 4));
    }

    private static double maxAvg(int[] arr, int k) {
        int sum = 0;
        int maxSum = 0;
        double avg = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        maxSum = Math.max(sum, maxSum);
        for (int i = k; i < arr.length; i++) {
            sum += arr[i];
            sum -= arr[i - k];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum * 1.0 / k;
    }
}
