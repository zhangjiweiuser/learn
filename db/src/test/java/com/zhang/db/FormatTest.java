package com.zhang.db;

import com.google.common.base.Splitter;

import java.io.IOException;
import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/26 17:27
 */
public class FormatTest {
    public static void main(String[] args) throws IOException {
        String ids = "1,2,3,5,6,8,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,32,35,36,37,38,39,40,41,43,44,48,49,50,51,52,53,54,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,77,87,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129";
        String sql = "insert into tenant_user_store(tenant_id,tenant_user_id,store_id,is_del,Created_STime,Modified_STime) values(2,6,%s,0,now(),now());";
        List<String> strings = Splitter.on(",").splitToList(ids);
        for (String id : strings) {
            System.out.println(String.format(sql, id));
        }
//        InputStream is = ClassLoader.getSystemResourceAsStream("sql.txt");
//        if (null == is) {
//            return;
//        }
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        byte[] bytes = new byte[1024];
//        int len;
//        while ((len = is.read(bytes)) != -1) {
//            bos.write(bytes, 0, len);
//        }
//        String result = bos.toString();
//        List<String> strings = Splitter.on("\r\n").splitToList(result);
//        for (String str : strings) {
//            System.out.println("00:" + str);
//        }
//        File file = ResourceUtils.getFile("classpath:sql.txt");
//        List<String> strings = Files.readLines(file, Charsets.UTF_8);
//        for (String str : strings) {
//            System.out.println(str);
//        }
    }
}
