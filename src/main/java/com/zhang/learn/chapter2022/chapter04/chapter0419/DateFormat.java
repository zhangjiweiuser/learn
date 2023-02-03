package com.zhang.learn.chapter2022.chapter04.chapter0419;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-05-09 14:52
 */
public class DateFormat {
    public static void main(String[] args) {
//        String startTime = "2022-09-09 12:13:14";
//        System.out.println(startTime.substring(0,10)+" 00:00:00");
//        System.out.println("("+startTime.substring(0,10)+") 00:00:00");
//        System.out.println(formatDateTime(new Date(), "yyyy年MM月dd日"));

        String sql = "INSERT INTO aw_withdraw_log(withdraw_code, msg, create_time, `type`)VALUES('WD202206270100%s', '提交分账信息', '2022-06-28 04:00:44', 2);";
        DecimalFormat DECIMAL_FORMAT_SIX = new DecimalFormat("0000");
//        for(int i=1001;i<1734;i++){
//            System.out.println(String.format(sql,DECIMAL_FORMAT_SIX.format(i)));
//        }
//        BigDecimal d = new BigDecimal(100000);
//        BigDecimal r = new BigDecimal(0.001875*3);
//        BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN);
//        BigDecimal j = d.multiply(r).setScale(2, RoundingMode.HALF_UP);
//        BigDecimal k = d.multiply(r).setScale(2, RoundingMode.HALF_DOWN);
//        System.out.println(i);
//        System.out.println(j);
//        System.out.println(k);

//        System.out.println(new BigDecimal("18.46").setScale(0, RoundingMode.HALF_EVEN));
//        System.out.println(new BigDecimal("18.44").setScale(0, RoundingMode.HALF_EVEN));
//        System.out.println(new BigDecimal("18.45").setScale(0, RoundingMode.HALF_EVEN));
//
//        System.out.println(new BigDecimal("18.56").setScale(0, RoundingMode.HALF_EVEN));
//        System.out.println(new BigDecimal("18.54").setScale(0, RoundingMode.HALF_EVEN));
//        System.out.println(new BigDecimal("18.55").setScale(0, RoundingMode.HALF_EVEN));
//
//        System.out.println(new BigDecimal("0.6").setScale(0, RoundingMode.HALF_EVEN));
//        System.out.println(new BigDecimal("0.66").setScale(0, RoundingMode.HALF_EVEN));
//        System.out.println(new BigDecimal("0.54").setScale(0, RoundingMode.HALF_EVEN));
//        System.out.println(new BigDecimal("0.50").setScale(0, RoundingMode.HALF_EVEN));
//        System.out.println(new BigDecimal("0.50").setScale(0, RoundingMode.HALF_UP));


//        System.out.println(new BigDecimal("0.60").setScale(0, RoundingMode.HALF_UP).longValue());
//        System.out.println(new BigDecimal("0.60").setScale(2, RoundingMode.HALF_UP).longValue());
//        Set<String> set = new HashSet<>();
//        set.add("6Q0");
//        set.add("6S0");
//        System.out.println(JSONObject.toJSONString(set));
        System.out.println(System.currentTimeMillis());
    }
    public static String formatDateTime(Date date, String format) {
        String result = "";
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            result = formater.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
