package learn.chapter02.chapter0224;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 任务编号生成工具类
 * @ClassName: taskNoUtil
 * @Date: 2021/2/1 16:00
 * @Author: xuxiaoxiao1
 * @Version: 1.0
 **/
public class TaskNoUtil {
    //todo 以后考虑分布式Id
    //减少不同机器相同编码的概率
    private static final String RANDOW_STRING = TaskNoUtil.getRandomNo(3);

    private static final DateTimeFormatter YY_MM_DD_HH_MM = DateTimeFormatter.ofPattern("yyMMddHHmm");

    private static LocalDateTime LOCAL_DATE_TIME = LocalDateTime.now().withSecond(0).withNano(0);

    private static AtomicInteger ATOMIC_INTEGER = new AtomicInteger(10001);

    /**
     * 创建连续的任务编号
     * D/S/X+税种首字母(消息为M)+四位随机码+YYMMddHHmm+10001流水号
     *
     * @param taskType 类型 taskType 任务类型1-税务申报；2-底表申报；3-通知公示
     * @return java.lang.String 唯一的、连续任务编号
     * @date 2021/2/1 16:00
     * @author xuxiaoxiao1
     **/
    public static synchronized String getTaskNoByType(Integer taskType, String taxTypeId) {
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);
        //分钟换了则重置
        if (now.isAfter(LOCAL_DATE_TIME)) {
            LOCAL_DATE_TIME = now;
            ATOMIC_INTEGER = new AtomicInteger(10001);
        }
        String taskTypeStr = taskType == 1 ? "S" : taskType == 2 ? "D" : taskType == 3 ? "X" : "Q";
        String taxTypeIdStr = "Q";//其他
        if (StringUtils.isNotBlank(taxTypeId)) {
            taxTypeIdStr = taxTypeId.substring(0, 1);
        }
        taxTypeIdStr = taskType == 3 ? "M" : taxTypeIdStr;
        String dateStr = LOCAL_DATE_TIME.format(YY_MM_DD_HH_MM);
        return taskTypeStr + taxTypeIdStr + RANDOW_STRING + dateStr + ATOMIC_INTEGER.getAndIncrement();
    }

    /**
     * 获取指定长度，以大写字母开头，包含大小字母或数据的随机码
     *
     * @param len
     * @return java.lang.String
     * @date 2020/6/2 10:22
     * @author xuxiaoxiao1
     **/
    public static String getRandomNo(int len) {
        if (len < 1) {
            return "";
        }
        char[] charArr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < len; ++x) {
            sb.append(charArr[ThreadLocalRandom.current().nextInt(charArr.length)]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(getTaskNoByType(1, "Q") + "  ---  " + Thread.currentThread().getName());
            }
        };

        Thread t1 = new Thread(r);
        t1.setName("线程1");
        Thread t2 = new Thread(r);
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}
