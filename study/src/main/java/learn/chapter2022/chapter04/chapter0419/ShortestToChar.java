package learn.chapter2022.chapter04.chapter0419;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-04-19 9:28
 */
public class ShortestToChar {
    public static void main(String[] args) {
        ShortestToChar shortest = new ShortestToChar();
        String s = "loveleetcode"; char c = 'e';
        int[] ans = shortest.shortestToChar(s,c);
        System.out.println(Arrays.toString(ans));

        Long aa = 121545L;
        Long bb = 121545L;
        System.out.println(aa == bb);
    }
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                list.add(i);
            }
        }
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < list.size(); j++) {
                min = Math.min(min,Math.abs(i-list.get(j)));

            }
            ans[i] = min;
        }
        return ans;
    }
}
