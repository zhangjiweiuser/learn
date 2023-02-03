package com.zhang.db.quanzhong;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/27 14:25
 */
public class WeightTest {
    static List<WeightCategory> categorys = new ArrayList<WeightCategory>();
    private static Random random = new Random();

    public static void main(String[] args) {
        initData();
        Integer weightSum = categorys.stream().mapToInt(WeightCategory::getWeight).sum();
        if (weightSum <= 0) {
            System.out.println("总权重不能小于0");
            return;
        }
        Integer n = random.nextInt(weightSum);
        System.out.println("n:" + n);
        Integer m = 0;
        for (WeightCategory wc : categorys) {
            if (m <= n && n < m + wc.getWeight()) {
                System.out.println("就是这个：" + wc.getCategory());
                break;
            }
            m += wc.getWeight();
        }
    }

    private static void initData() {
        WeightCategory wc1 = new WeightCategory("A", 60);
        WeightCategory wc2 = new WeightCategory("B", 20);
        WeightCategory wc3 = new WeightCategory("C", 20);
        categorys.add(wc1);
        categorys.add(wc2);
        categorys.add(wc3);
    }
}
