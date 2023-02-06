package com.zhang.learn.chapter2022.chapter03.chapter0316;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-03-16 15:24
 */
public class Sub {
    public static void main(String[] args) throws IOException {
//        List<String> weixin = Lists.newArrayList();
//        List<String> strings = Files.readLines(new File("D:/weixinopenid.txt"), Charsets.UTF_8);
//        for (String s : strings) {
//            weixin.add(s.split("\t")[1]);
//        }
//        System.out.println(weixin);
//
//        List<String> appInDb = Lists.newArrayList("wx5a99f4fdfd104593", "wx5a99f4fdfd104593", "wx3c15fe1cbcd88519", "wx97c6bb3187a8101c", "wx8508f26db5336b9a", "wxf4db8f128b4c1ab6", "wxbcfae9a7df68b625", "wx206dce8923fadea9", "wx2b7e02207c934ec1", "wx7a588280af251025", "wx5a99f4fdfd104593", "wxd0c6fa20289c796f", "wx44c956a3fe68867f", "wx28d3e9d8e785eb22", "wx8231a55f3c759bcd", "wx0db047930eb46dba", "wxb6aa1babc74c0954", "wx2e48dbf03c815c2a", "wx07f5e34bfe6cd573", "wx1f5a80fe64c29ec2", "wxcbb97819364399d0", "wxe3fa286be3803556", "wxaef350fa9205bcf3", "wxbfb5353edd00237a", "wx54585e1ae0615da1", "wxfba0508415ee1d15", "wxed54e0d9b62a9786", "wx4d7b319966b858b9", "wxd09e9eee7e924821", "wx724e2e1e623a959d", "wx4c8f4c714f05e323", "wx63f86f7767316e06", "wxe84b8a4abad7ef7b", "wxb2af89aa012f6228", "wxbd72e399c0a59e98", "wx6227e6af766d7be7");
//
//        System.out.println(CollectionUtils.subtract(weixin, appInDb));
//        System.out.println(CollectionUtils.subtract(appInDb, weixin));
//        DecimalFormat DECIMAL_FORMAT = new DecimalFormat("00");
//        System.out.println(DECIMAL_FORMAT.format(150));
//        System.out.println(DECIMAL_FORMAT.format(1));
        String data = "1,2,3,4,5";
        List<Long> settleBillNoResponse = Arrays.stream(data.split(",")).mapToLong(Long::valueOf).boxed().collect(Collectors.toList());
        System.out.println(settleBillNoResponse);
    }
}
