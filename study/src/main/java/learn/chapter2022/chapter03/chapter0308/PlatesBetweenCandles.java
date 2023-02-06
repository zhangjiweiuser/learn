package learn.chapter2022.chapter03.chapter0308;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-03-08 9:35
 */
public class PlatesBetweenCandles {
    public static void main(String[] args) {
        PlatesBetweenCandles candles = new PlatesBetweenCandles();
        String s = "**|**|***|";
        int[][] queries = {{2, 5}, {5, 9}};
        int[] result = candles.platesBetweenCandles(s, queries);
        System.out.println(Arrays.toString(result));
        
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] arr = queries[i];
            String sub = s.substring(arr[0], arr[1] + 1);
            int from = 0;
            int to = sub.length() - 1;
            while (from < to && sub.charAt(from) != '|') {
                from++;
            }
            while (to > 0 && sub.charAt(to) != '|') {
                to--;
            }
            int num = 0;
            while (from < to) {
                if (sub.charAt(from) == '*') {
                    num++;
                }
                from++;
            }
            res[i] = num;
            System.out.println(sub);
        }
        return res;
    }
}
