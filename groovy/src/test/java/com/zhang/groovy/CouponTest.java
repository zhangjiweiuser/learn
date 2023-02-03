package com.zhang.groovy;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/16 15:01
 */
public class CouponTest {
    @Test
    void linKenTest() throws IOException {
        List<String> result = FileUtils.readLines(new File("D:/linken0804-0815.txt"), Charset.forName("utf-8"));
        Map<String, Set<String>> map = new HashMap<>();
        for (String str : result) {
            System.out.println(str);
            String[] spl = str.split("\\s");
            System.out.println(spl[3] + "--" + spl[5]);
            System.out.println("-------------------");
            String[] dealers = spl[5].split(",");
            for (String dealer : dealers) {
                Set<String> sets = map.getOrDefault(dealer, new HashSet<>());
                sets.add(spl[3]);
                map.put(dealer, sets);
            }
        }
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue().size() + "\t" + entry.getValue().toString());
        }
        System.out.println(map.size());
    }


    @Test
    void linKen2Test() throws IOException {
        List<String> result = FileUtils.readLines(new File("D:/lingquan.txt"), Charset.forName("utf-8"));
        Map<String, Set<String>> map = new HashMap<>();
        for (String str : result) {
//            System.out.println(str);
            String[] spl = str.split("\\s");
            String phone = spl[3];
//            System.out.println(phone + "--" + spl[5]);
            String json = spl[6];

            json = json.replace("\"{","{").replace("\"\"","\"").replace("}\"","}");
//            System.out.println(json);
            JSONObject requst = JSONObject.parseObject(json);
            System.out.println(spl[3] +"\t" + spl[5]+"\t"+ requst.getString("dealers"));
//            System.out.println("-------------------");
//            String[] dealers = requst.getString("dealers").split(",");
//            for (String dealer : dealers) {
//                Set<String> sets = map.getOrDefault(dealer, new HashSet<>());
//                sets.add(phone);
//                map.put(dealer, sets);
//            }
        }
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue().size() + "\t" + entry.getValue().toString());
        }
        System.out.println(map.size());
    }
}
