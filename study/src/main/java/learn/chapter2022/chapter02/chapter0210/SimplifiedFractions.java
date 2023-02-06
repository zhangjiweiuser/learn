package learn.chapter2022.chapter02.chapter0210;

import java.util.*;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-02-10 9:54
 */
public class SimplifiedFractions {
    public static void main(String[] args) {
        SimplifiedFractions fractions = new SimplifiedFractions();
        System.out.println(fractions.simplifiedFractions(1));
        System.out.println(fractions.simplifiedFractions(2));
        System.out.println(fractions.simplifiedFractions(3));
        System.out.println(fractions.simplifiedFractions(4));
        System.out.println(fractions.simplifiedFractions(5));
        System.out.println(fractions.simplifiedFractions(6));
    }

    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (!isChu(i, j)) {
                    list.add(i + "/" + j);
                }
            }
        }
        return list;
    }

    private boolean isChu(int i, int j) {
        for (int k = 2; k <= i; k++) {
            if (i % k == 0 && j % k == 0) {
                return true;
            }
        }
        return false;
    }
}
