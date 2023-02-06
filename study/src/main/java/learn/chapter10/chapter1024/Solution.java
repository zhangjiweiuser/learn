package learn.chapter10.chapter1024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/10/24 17:53
 */
public class Solution {

    public static void main(String[] args) {
//        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
//        System.out.println(videoStitching(clips, 10));
//        int[][] clips2 = {{0, 1}, {1, 2}};
//        System.out.println(videoStitching(clips2, 5));
//        int[][] clips3 = {{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
//        System.out.println(videoStitching(clips3, 9));
//        int[][] clips4 = {{0, 1}, {2, 8}};
//        System.out.println(videoStitching(clips4, 5));
        int[][] clips5 = {{16,18},{16,20},{3,13},{1,18},{0,8},{5,6},{13,17},{3,17},{5,6}};
        System.out.println(videoStitching2(clips5, 15));
    }

    // clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
    //输出：3

    public static int videoStitching2(int[][] clips, int T){
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];

    }

    public static int videoStitching(int[][] clips, int t) {
        sort(clips);

        for (int[] a : clips) {
            System.out.println(a[0] + "--" + a[1]);
        }
        int max = 0;
        for (int[] c : clips) {
            if (c[1] > max) {
                max = c[1];
            }
        }
        if (clips[0][0] > 0) {
            return -1;
        }
        if (max < t) {
            return -1;
        }

        Map<Integer, int[]> map = new HashMap<>();
        for (int[] c : clips) {
            int num = c[0];
            if (map.get(num) == null) {
                map.put(num, c);
            }
        }


        int min = 1;
        int right = 0;
//        for (int i = 0; i < clips.length; i++) {
//            int[] clip = clips[i];
//            if (clip[1] > right) {
//                min++;
//                right = clip[1];
//                if (clip[1] >= t) {
//                    return min;
//                }
//            }
//
//        }
        int[] c = map.get(0);
        right = c[1];

        while (right < t) {
            boolean f = false;
            for (int i = right; i > c[0]; i--) {
                int[] a = map.get(i);
                if (null != a) {
                    f = true;
                    min++;
                    right = a[1];
                    c = a;
                }
            }
            if (!f) {
                return -1;
            }

        }


        return min;
    }

    private static void sort(int[][] clips) {

        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
    }
}
