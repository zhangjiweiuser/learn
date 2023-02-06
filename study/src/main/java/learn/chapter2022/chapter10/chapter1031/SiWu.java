package learn.chapter2022.chapter10.chapter1031;

import java.math.BigDecimal;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-10-31 14:36
 */
public class SiWu {
    public static void main(String[] args) {
        double f = 10.2345;
        BigDecimal b0 = new BigDecimal(f);
        BigDecimal b1 = new BigDecimal(f);
        BigDecimal b2 = new BigDecimal(f);
        BigDecimal b3 = new BigDecimal(f);
        BigDecimal b4 = new BigDecimal(f);
        BigDecimal b5 = new BigDecimal(f);
        BigDecimal b6 = new BigDecimal(f);
        BigDecimal b7 = new BigDecimal("10.2345");

        double f0 = b0.setScale(0, BigDecimal.ROUND_UP).doubleValue();
        double f1 = b1.setScale(0, BigDecimal.ROUND_DOWN).doubleValue();
        double f2 = b2.setScale(0, BigDecimal.ROUND_CEILING).doubleValue();
        double f3 = b3.setScale(0, BigDecimal.ROUND_FLOOR).doubleValue();
        double f4 = b4.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
        double f5 = b5.setScale(0, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        double f6 = b6.setScale(0, BigDecimal.ROUND_HALF_EVEN).doubleValue();
//        double f7 = b7.setScale(0, BigDecimal.ROUND_UNNECESSARY).doubleValue();

//        System.out.println(f + "使用  远离零方向舍入（ROUND_UP）方式四舍五入结果为：" + f0);
//        System.out.println(f + "使用  趋向零方向舍入（ROUND_DOWN）方式四舍五入结果为：" + f1);
//        System.out.println(f + "使用  向正无穷方向舍入（ROUND_CEILING）方式四舍五入结果为：" + f2);
//        System.out.println(f + "使用  向负无穷方向舍入（ROUND_FLOOR）方式四舍五入结果为：" + f3);
//        System.out.println(f + "使用  最近数字舍入(5进)（ROUND_HALF_UP）方式四舍五入结果为：" + f4);
//        System.out.println(f + "使用  最近数字舍入(5舍)（ROUND_HALF_DOWN）方式四舍五入结果为：" + f5);
//        System.out.println(f + "使用  银行家舍入法（ROUND_HALF_EVEN）方式四舍五入结果为：" + f6);
//        System.out.println(f + "使用  不需要舍入模式（ROUND_UNNECESSARY）方式结果为：" + f7);

//        System.out.println(new BigDecimal("10.509").setScale(0, BigDecimal.ROUND_UP).longValue());
//        System.out.println(new BigDecimal("10.499").setScale(0, BigDecimal.ROUND_HALF_UP).longValue());
//        System.out.println(new BigDecimal("10.499").setScale(0, BigDecimal.ROUND_HALF_EVEN).longValue());

//        System.out.println(new BigDecimal("10.499").setScale(0, BigDecimal.ROUND_HALF_UP).longValue());
//        System.out.println(new BigDecimal("10.499").setScale(0, BigDecimal.ROUND_HALF_EVEN).longValue());
//
//
//        System.out.println(new BigDecimal("10.009").setScale(0, BigDecimal.ROUND_HALF_UP).longValue());
//        System.out.println(new BigDecimal("10.009").setScale(0, BigDecimal.ROUND_HALF_EVEN).longValue());
//
//        System.out.println(new BigDecimal("10.549").setScale(0, BigDecimal.ROUND_HALF_UP).longValue());
//        System.out.println(new BigDecimal("10.549").setScale(0, BigDecimal.ROUND_HALF_EVEN).longValue());
//
//        System.out.println(new BigDecimal("10.559").setScale(0, BigDecimal.ROUND_HALF_UP).longValue());
//        System.out.println(new BigDecimal("10.559").setScale(0, BigDecimal.ROUND_HALF_EVEN).longValue());
//
//        System.out.println(new BigDecimal("10.569").setScale(0, BigDecimal.ROUND_HALF_UP).longValue());
//        System.out.println(new BigDecimal("10.569").setScale(0, BigDecimal.ROUND_HALF_EVEN).longValue());
//
//        System.out.println(new BigDecimal("10.500").setScale(0, BigDecimal.ROUND_HALF_UP).longValue());
//        System.out.println(new BigDecimal("10.500").setScale(0, BigDecimal.ROUND_HALF_EVEN).longValue());
//
//        System.out.println(new BigDecimal("10.500").setScale(0, RoundingMode.HALF_UP).longValue());
//        System.out.println(new BigDecimal("10.500").setScale(0, RoundingMode.HALF_EVEN).longValue());


//        System.out.println(new BigDecimal("10.000").setScale(0, RoundingMode.UP).longValue());
//        System.out.println(new BigDecimal("10.010").setScale(0, RoundingMode.UP).longValue());
//        System.out.println(new BigDecimal("10.060").setScale(0, RoundingMode.UP).longValue());
//        System.out.println(new BigDecimal("10.440").setScale(0, RoundingMode.UP).longValue());
//        System.out.println(new BigDecimal("10.460").setScale(0, RoundingMode.UP).longValue());
//        System.out.println(new BigDecimal("10.640").setScale(0, RoundingMode.UP).longValue());
//        System.out.println(new BigDecimal("10.660").setScale(0, RoundingMode.UP).longValue());
//        List<Integer> list1 = Lists.newArrayList(1,2,3);
//        List<Integer> list2 = Lists.newArrayList(4,2);
//        Collection subtract = CollectionUtils.subtract(list2, list1);
//        System.out.println(subtract);
//        Collection subtract2 = CollectionUtils.subtract(list1, list2);
//        System.out.println(subtract2);
//        System.out.println(CollectionUtils.containsAny(list1,list2));
        System.out.println(Integer.valueOf(new StringBuffer().append(10).reverse().toString()));
    }
}
