package com.zhang.db.qrcode;

import java.io.IOException;
import java.util.Objects;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-07-19 11:03
 */
public class QrCodeUtil {
    public static void main(String[] args) throws IOException {
//        List<String> strings = Files.readLines(new File("D:/轧差.txt"), Charsets.UTF_8);
//        JSONArray array = new JSONArray();
//        for (int i = 0; i < strings.size(); i=i+6) {
//            if(i % 6 == 0){
//                System.out.println(i+"--" + strings.get(i));
//                JSONObject json = new JSONObject();
//                json.put("mchId",strings.get(i+1));
//                json.put("companyId",strings.get(i+2));
//                json.put("transactionAmount",strings.get(i+3));
//                json.put("createTime",strings.get(i+4));
//                json.put("businessNumber",strings.get(i+5));
//                json.put("businessType",5);
//                json.put("transactionType",4);
//                array.add(json);
//            }
//        }
//        System.out.println(JSONArray.toJSON(array));
//
//        Map<String, List<Object>> collect = array.stream().collect(Collectors.groupingBy(json -> ((JSONObject) json).getString("mchId") +"--"+ ((JSONObject) json).getString("companyId")));
//        collect.entrySet().forEach(entry->{
//            System.out.println(entry.getKey()+"--("+entry.getValue().stream().mapToInt(json->((JSONObject) json).getIntValue("transactionAmount")).sum());
//
//        });
//        CRC32 crc32 = new CRC32();
//        crc32.update("aaaaaaa".getBytes());
//        System.out.println(crc32.getValue());
//        System.out.println(crc32.getValue());
//        List<String> strings1 = Files.readLines(new File("D:/1.txt"), Charsets.UTF_8);
//        List<String> strings2 = Files.readLines(new File("D:/2.txt"), Charsets.UTF_8);
//        System.out.println(strings1.size());
//        System.out.println(strings2.size());
//        strings1.removeAll(strings2);
//        System.out.println(strings1.size());
//        CRC32 crc32 = new CRC32();
//        crc32.update("aa".getBytes(Charsets.UTF_8));
//        System.out.println(crc32.getValue());

        Integer a = new Integer("87887878");
        Integer b = new Integer("87887878");
        System.out.println(Objects.equals(a,b));
    }


}
