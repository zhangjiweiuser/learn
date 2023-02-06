package learn.chapter2021.chapter11.chapter19;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/11/19 10:23
 */
public class IdCardTest {
    public static void main(String[] args) {
//        System.out.println(test1("41282619890307461X"));
//        System.out.println(test2("41282619890307461X"));
//        System.out.println(343%11);
        String date = "20210231";
        String nDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd")).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(nDate);
        System.out.println(LocalDate.now().getYear());
    }

    public static int test1(String id) {
        int sum = (id.charAt(0) - '0') * 7 + (id.charAt(1) - '0') * 9 + (id.charAt(2) - '0') * 10
                + (id.charAt(3) - '0') * 5 + (id.charAt(4) - '0') * 8 + (id.charAt(5) - '0') * 4
                + (id.charAt(6) - '0') * 2 + (id.charAt(7) - '0') * 1 + (id.charAt(8) - '0') * 6
                + (id.charAt(9) - '0') * 3 + (id.charAt(10) - '0') * 7 + (id.charAt(11) - '0') * 9
                + (id.charAt(12) - '0') * 10 + (id.charAt(13) - '0') * 5 + (id.charAt(14) - '0') * 8
                + (id.charAt(15) - '0') * 4 + (id.charAt(16) - '0') * 2;
        return sum;
    }

    public static int test2(String id) {
        int[] beishu = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        int sum = 0;
        for (int i = 0; i < beishu.length; i++) {
            sum += (id.charAt(i) - '0') * beishu[i];
        }
        return sum;
    }
}
