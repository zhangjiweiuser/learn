package com.zhang.learn.chapter2024.chapter03.chapter0322;

import com.alibaba.fastjson2.JSON;
import com.google.common.base.CaseFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Pdf2Ppt {
    public static void main(String[] args) throws Exception {

//        convertDto();
        convertField();
    }

    /**
     * 转换成实体类
     * @throws Exception
     */
    private static void convertDto() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("D:/ziduan.txt")));
        String str = null;
        while ((str = br.readLine()) != null) {
            String[] split = str.split("\\s");
            System.out.println("/**\n" +
                    "     * " + split[0] + "  " + split[1] + "\n" +
                    "     */");
            String resultStr = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, split[2]);
            System.out.println("priva11te String " + resultStr + ";");
        }
        br.close();
    }

    /**
     * 转换成拉取文件的fieldDesc
     * @throws Exception
     */
    private static void convertField()  throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("D:/ziduan.txt")));
        String str = null;
        List<Desc> descList = new ArrayList<>();
        while ((str = br.readLine()) != null) {
            String[] split = str.split("\\s");
//            System.out.println("/**\n" +
//                    "     * "+split[0]+"  "+split[1]+"\n" +
//                    "     */");
//            System.out.println("private String "+split[2]+";");
//            String resultStr = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, split[2]);
//            System.out.println("转换后结果是："+resultStr);
            descList.add(new Desc(split[0],split[1]));
        }
//        [{"field":"projectNumber","fieldDes":"项目编号"}]
        System.out.println(JSON.toJSONString(descList));
        br.close();
    }
    @Data
    @AllArgsConstructor
    static class Desc{
        private String field;
        private String fieldDesc;
    }
}
