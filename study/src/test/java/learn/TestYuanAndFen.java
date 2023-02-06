package learn;


import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.regex.Pattern;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/9/16 17:37
 */
public class TestYuanAndFen {
    private static final BigDecimal HUNDRED = new BigDecimal("100");
    // 判断小数点后2位的数字的正则表达式
    private static final Pattern PATTERN = java.util.regex.Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d)*)?$");


    public static void main(String[] args) {
//        System.out.println(yuan2Fen("0.00"));
//        System.out.println(yuan2Fen("015.2"));
//        System.out.println(yuan2Fen("15.201"));
//        System.out.println(yuan2Fen("132.1"));
//        System.out.println(yuan2Fen("135."));
//        System.out.println(yuan2Fen("12.69"));
        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8))*1000);
        System.out.println(System.currentTimeMillis());
    }

    public static BigDecimal fen2Yuan(int money, int scale) {
        return new BigDecimal(money).divide(HUNDRED, scale, BigDecimal.ROUND_HALF_UP);
    }

    public static int yuan2Fen(String yuan) {
        if (StringUtils.isBlank(yuan)) {
            return 0;
        }
        if (PATTERN.matcher(yuan).matches()) {
            return new BigDecimal(yuan).multiply(HUNDRED).intValue();
        }
        return 0;
    }

    public static int yuan2Fen(BigDecimal yuan) {
        return yuan.multiply(HUNDRED).intValue();
    }
}
