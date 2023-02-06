package learn.chapter2021.chapter06.chapter0611;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/6/11 10:53
 */
public class Fib {

    public static void main(String[] args) {
        long start2 = System.currentTimeMillis();
        System.out.println(fib2(40));
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);

        long start1 = System.currentTimeMillis();
        System.out.println(fib(40));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

        long start3 = System.currentTimeMillis();
        System.out.println(fib3(40));
        long end3 = System.currentTimeMillis();
        System.out.println(end3 - start3);

        long start4 = System.currentTimeMillis();
        System.out.println(fib4(40));
        long end4 = System.currentTimeMillis();
        System.out.println(end4 - start4);
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static int fib2(int n) {
        if (n < 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        return helper(map, n);
    }

    private static int helper(Map<Integer, Integer> map, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (null != map.get(n)) {
            return map.get(n);
        }
        int num = helper(map, n - 1) + helper(map, n - 2);
        map.put(n, num);
        return num;
    }

    private static int fib3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[1] = nums[2] = 1;
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    private static int fib4(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int prev = 1, curr = 1;

        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;

        }
        return curr;
    }
}
