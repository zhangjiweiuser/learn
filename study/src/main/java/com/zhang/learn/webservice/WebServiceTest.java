package com.zhang.learn.webservice;

import cn.hutool.core.lang.Console;
import cn.hutool.http.webservice.SoapClient;
import cn.hutool.http.webservice.SoapProtocol;
import com.alibaba.fastjson2.JSONObject;

import javax.xml.soap.SOAPMessage;

public class WebServiceTest {
    public static void main(String[] args) {

        SoapClient client = SoapClient.create("http://demo3.1hai.cn/Ehiservice/EhiService.svc", SoapProtocol.SOAP_1_2)
                // 设置要请求的方法，此接口方法前缀为web，传入对应的命名空间
                .setMethod("GetCitiesList", "http://tempuri.org/IEhiService/EhiServiceDataContract")

                .setParam("a:UserName", "200462",false)
                .setParam("a:Password", "123qwe",false);

        // 发送请求，参数true表示返回一个格式化后的XML内容
        // 返回内容为XML字符串，可以配合XmlUtil解析这个响应
        SOAPMessage message = client.getMessage();
        System.out.println(JSONObject.toJSONString(message));
        Console.log(client.send());
    }
}
