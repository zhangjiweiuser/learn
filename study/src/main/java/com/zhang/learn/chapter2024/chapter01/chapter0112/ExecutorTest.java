package com.zhang.learn.chapter2024.chapter01.chapter0112;

public class ExecutorTest {
    public static void main(String[] args) throws InterruptedException {

//        List<String> jzDeduct = new ArrayList<>();
//        jzDeduct.add("a");
//        jzDeduct.add("b");
//        jzDeduct.add("c");
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(30));
//        //买断订单 调桔子划扣
//        final CountDownLatch jzLatch = new CountDownLatch(jzDeduct.size());
//        jzDeduct.forEach(thirdDeduct -> executor.execute(() -> {
//            // 超时处理
//            try {
//                System.out.println("开始执行：" + thirdDeduct + "," + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
//                if ("b".equals(thirdDeduct)) {
//                    TimeUnit.SECONDS.sleep(3);
//                } else if ("c".equals(thirdDeduct)) {
//                    TimeUnit.SECONDS.sleep(5);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                jzLatch.countDown();
//            }
//        }));
//        if (jzLatch.getCount() > 0) {
//            jzLatch.await();
//        }
//        System.out.println("到我这了:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        boolean result = isTrue();
        result = result & false1();
        result = result & false2();
        System.out.println(result);
    }
    private static boolean isTrue(){
        return true;
    }
    private static boolean false1(){
        System.out.println("false1");
        return false;
    }
    private static boolean false2(){
        System.out.println("false2");
        return true;
    }
}
