package learn.util;

import org.springframework.util.StopWatch;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/9/15 9:35
 */
public class OrderUtil {
    /**
     * 订单号生成
     **/
    private static ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");
    private static final AtomicInteger SEQ = new AtomicInteger(1000);
    private static final DateTimeFormatter DF_FMT_PREFIX = DateTimeFormatter.ofPattern("yyMMddHHmmssSS");

    public static String generateOrderNo() {
        LocalDateTime dataTime = LocalDateTime.now(ZONE_ID);
        if (SEQ.intValue() > 9990) {
            SEQ.getAndSet(1000);
        }
        return dataTime.format(DF_FMT_PREFIX) + getLocalIpSuffix() + SEQ.getAndIncrement();
    }

    private volatile static String IP_SUFFIX = null;

    private static String getLocalIpSuffix() {
        if (null != IP_SUFFIX) {
            return IP_SUFFIX;
        }
        try {
            synchronized (OrderUtil.class) {
                if (null != IP_SUFFIX) {
                    return IP_SUFFIX;
                }
                InetAddress addr = InetAddress.getLocalHost();
                //  172.17.0.4  172.17.0.199 ,
                String hostAddress = addr.getHostAddress();
                if (null != hostAddress && hostAddress.length() > 4) {
                    String ipSuffix = hostAddress.trim().split("\\.")[3];
                    if (ipSuffix.length() == 3) {
                        IP_SUFFIX = ipSuffix;
                        return IP_SUFFIX;
                    } else if (ipSuffix.length() == 1) {
                        IP_SUFFIX = "00" + ipSuffix;
                        return IP_SUFFIX;
                    } else if (ipSuffix.length() == 2) {
                        IP_SUFFIX = "0" + ipSuffix;
                        return IP_SUFFIX;
                    }

                }
                IP_SUFFIX = ThreadLocalRandom.current().nextInt(100, 999) + "";
                return IP_SUFFIX;
            }
        } catch (Exception e) {
            System.out.println("获取IP失败:" + e.getMessage());
            IP_SUFFIX = ThreadLocalRandom.current().nextInt(100, 999) + "";
            return IP_SUFFIX;
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("开始计时");
        List<String> orderNos = Collections.synchronizedList(new ArrayList<String>());
        IntStream.range(0, 8000).parallel().forEach(i -> {
            orderNos.add(generateOrderNo());
        });

//        ExecutorService service = Executors.newFixedThreadPool(5);
//        List<Future> list = new ArrayList();
//        for (int i = 0; i < 5; i++) {
//
//            Future future = service.submit(() -> {
//                for (int j = 0; j < 1000; j++) {
//                    orderNos.add(generateOrderNo());
//                }
//            });
//            list.add(future);
//        }
//
//        service.shutdown();
//        for (int i = 0; i < 5; i++) {
//            Future future = list.get(i);
//            System.out.println(future.get());
//        }

        List<String> filterOrderNos = orderNos.stream().distinct().collect(Collectors.toList());

        System.out.println("订单样例：" + orderNos.get(1516));
        System.out.println("生成订单数：" + orderNos.size());
        System.out.println("过滤重复后订单数：" + filterOrderNos.size());
        System.out.println("重复订单数：" + (orderNos.size() - filterOrderNos.size()));

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        System.out.println("总耗时：" + (System.currentTimeMillis() - start));

    }
}
