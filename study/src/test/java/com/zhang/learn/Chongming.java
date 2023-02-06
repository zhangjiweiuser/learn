package com.zhang.learn;

import com.google.common.io.Files;
import org.assertj.core.util.Lists;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/10/27 16:18
 */
public class Chongming {
    public static void main(String[] args) throws IOException {
//        File file = new File("D:\\4班2");
//        File[] files = file.listFiles();
//        for (File f : files) {
//            String name = f.getName();
//            int length = name.length();
//
//            String substring = name.substring(length - 22);
//            System.out.println(name + " ---  " + substring);
//            File newFile = new File("D:/4班/" + substring);
//            f.renameTo(newFile);
//
//        }
//        Files.copy(new File("D:/erweima.png"),new File("D:/erweima2.png"));
        List<String> strings = Files.readLines(new File("D:/姓名.txt"), Charset.forName("utf-8"));
        System.out.println(strings);
        System.out.println(strings.size());
        File file = new File("D:\\一四班消防进校园图片");
        String[] names = file.list();
        List<String> listNew = Lists.newArrayList();
        for(String name : names){
            String nameName = name.split("\\.")[0];
            listNew.add(nameName);
        }
        for(String name : strings){
            if(!listNew.contains(name)){
                System.out.println(name);
            }
        }

    }
}
