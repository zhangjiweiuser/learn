package learn.chapter2021.chapter11.chapter10;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/11/10 16:14
 */
public class Solution {
    public static void main(String[] args) {

    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (null == timeSeries) {
            return 0;
        }
        if (timeSeries.length == 1) {
            return duration;
        }

        int total = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            total += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return total + duration;
    }
}
