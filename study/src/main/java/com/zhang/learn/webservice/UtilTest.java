package com.zhang.learn.webservice;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UtilTest {
    public static void main(String[] args) throws IOException {
        //地址
        String urlString = "http://demo3.1hai.cn/Ehiservice/EhiService.svc";
        //方法
        String soapActionString = "http://tempuri.org/IEhiService/GetCitiesList";
        URL url = new URL(urlString);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        //拼接请求体
        String soap = "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                + "<s:Body>"
                + "     <GetCitiesList xmlns=\"http://tempuri.org/\">"
                + "         <requestData xmlns:a=\"EhiServiceDataContract\" xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "             <a:UserName>200462</a:UserName>"
                + "             <a:Password>123qwe</a:Password>"
                + "             <a:RequestContent>"
                + "                 &lt;GetCitiesListRequest/&gt;"

                + "             </a:RequestContent>"
                + "         </requestData>"
                + "     </GetCitiesList>"
                + " </s:Body>"
                + "</s:Envelope>";

        byte[] buf = soap.getBytes();
        //设置一些头参数
        httpConn.setRequestProperty("Content-Length", String.valueOf(buf.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", soapActionString);
        httpConn.setRequestMethod("POST");
        //输入参数和输出结果
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        OutputStream out = httpConn.getOutputStream();
        out.write(buf);
        out.close();

        InputStream inputStream = httpConn.getInputStream();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] datas = outStream.toByteArray();

//        byte[] datas = readInputStream();
        String result = new String(datas);
        String a = result.replaceAll("&gt;", ">").replaceAll("&lt;", "<");
        System.out.println(a);
    }
}
