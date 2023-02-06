package learn.chapter12.chapter1221;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/12/21 14:11
 */
public class TimeUtil {

    public static void main(String[] args) {
//        System.out.println(System.currentTimeMillis());
//        System.out.println(str2Long("2020-12-31 10:10:03"));
//
//        System.out.println(hashMapTest());
//        System.out.println(treeMapTest());
        System.out.println(compareLocalDate("2020-12-21 10:10:03"));
        System.out.println(compareLocalDate("2020-12-22 10:10:03"));
        System.out.println(compareLocalDate("2020-12-20 10:10:03"));
    }

    private static long str2Long(String timeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(timeStr, formatter);
        long mill = time.toInstant(ZoneOffset.ofHours(+8)).toEpochMilli();
        return mill;
    }

    private static String compareLocalDate(String timeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime pickUpDateTimeLocal = LocalDateTime.parse(timeStr, formatter);
        LocalDate pickUpDateTimeLocalDate = pickUpDateTimeLocal.toLocalDate();
        LocalDate now = LocalDate.now();
        if (pickUpDateTimeLocalDate.isBefore(now)) {
            return "取车时间不能早于今天";
        }
        return "正常";
    }

    private static String hashMapTest() {
        Map<String, String> needVerify = new HashMap<>();
        needVerify.put("cc", "cc");
        needVerify.put("aa", "aa");
        needVerify.put("bb", "bb");
        needVerify.put("ab", "ab");
        List<Map.Entry<String, String>> entryList = new ArrayList<>(needVerify.entrySet());
        //排序
        entryList.sort(Comparator.comparing(Map.Entry::getKey));
        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<String, String> entry : entryList) {
            buffer.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        return buffer.toString();
    }

    private static String treeMapTest() {
        Map<String, String> needVerify = new TreeMap<>();
        needVerify.put("cc", "cc");
        needVerify.put("aa", "aa");
        needVerify.put("bb", "bb");
        needVerify.put("ab", "ab");

        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<String, String> entry : needVerify.entrySet()) {
            buffer.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        return buffer.toString();
    }
}
