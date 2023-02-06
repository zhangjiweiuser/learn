package com.zhang.learn.chapter0702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/7/2 15:44
 */
public class HttpUtil {
    public static void main(String[] args) {
        System.out.println(doGet("http://h5api.m.taobao.com/h5/mtop.taobao.detail.getdesc/6.0/?jsv=2.4.11&appKey=12574478&t=1538180732308&sign=e93a97b7e9a9a459297f4e689051c895&api=mtop.taobao.detail.getdesc&v=6.0&timeout=20000&data=%7B%22id%22%3A%22615771709519%22%2C%22type%22%3A%220%22%2C%22f%22%3A%22TB1AsvbfnqWBKNjSZFx8qwpLpla%22%7D"));
    }
    public static String doGet(String url) {
        URL webPageUrl = null;
        HttpURLConnection connection = null;
        InputStreamReader streamReader = null;
        BufferedReader reader = null;
        char[] buffer = new char[1024]; // 缓冲区
        int readlength = 0;
        String content = ""; // 要返回的String
        StringBuilder strBuilder = new StringBuilder(); // 存储读取网页内容

        try {
            // 读流
            webPageUrl = new URL(url);
            connection = (HttpURLConnection) webPageUrl.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows XP; SV1; .NET CLR 1.1.4322)");
            // 重定向设置
            HttpURLConnection.setFollowRedirects(true);
            connection.setInstanceFollowRedirects(false);

            // 设置连接超时时间和读超时时间为10秒和60秒
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);

            streamReader = new InputStreamReader(connection.getInputStream(), "utf-8");
            reader = new BufferedReader(streamReader);

            while (-1 != (readlength = reader.read(buffer))) {
                strBuilder.append(buffer, 0, readlength);
            }

            content = strBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return content;
    }
}
