package com.zhang.learn.webservice;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetCityTest {
    public static void main(String[] args) throws DocumentException, IOException {
        //地址
        String urlString = "http://demo3.1hai.cn/Ehiservice/EhiService.svc";
        //方法
        String soapActionString = "http://tempuri.org/IEhiService/GetCitiesList";
        AbstractYiHai getCityRequest = new GetCityRequest("GetCitiesList");
        System.out.println(getCityRequest.build());
        String soapXml = getCityRequest.build();
        String result = HttpClientUtil.doPost(urlString, soapActionString, soapXml);
//        System.out.println(result);
//        SAXReader saxReader = new SAXReader();
//        Document document = saxReader.read((new ByteArrayInputStream(result.getBytes("UTF-8"))));
//        Element root = document.getRootElement();
//        System.out.println(root.getText());
//        AbstractYiHai getStoreListRequest = new GetStoreListRequest();
//        System.out.println(getStoreListRequest.build());
//        String str = null;
//        BufferedReader br = new BufferedReader(new FileReader("D:/city.txt"));
//        StringBuffer sb = new StringBuffer();
//        while ((str = br.readLine()) != null) {
//            sb.append(str);
//        }
//        System.out.println(sb.toString());
        SAXReader saxReader = new SAXReader();
//        result = result.replaceAll("&gt;", ">").replaceAll("&lt;", "<");
        System.out.println("result:" + result);
        Document document = saxReader.read((new ByteArrayInputStream(result
                .getBytes("UTF-8"))));
        Element root = document.getRootElement();
        System.out.println("root.asXML():" + root.asXML());
//        Iterator<Element> it = root.elementIterator();
//        while (it.hasNext()) {
//            Element el = it.next();
//            System.out.println("el:"+el.getName());
//            System.out.println("el.asXML()"+el.asXML());
//        }

        Element body = root.element("Body");
        System.out.println("body:" + body.asXML());
        Iterator<Element> it = body.elementIterator();
        while (it.hasNext()) {
            Element el = it.next();
            System.out.println("el:" + el.getName());
            System.out.println("el.asXML()" + el.asXML());
        }
        Element getCitiesListResponse = body.element("GetCitiesListResponse");
        System.out.println("getCitiesListResponse:" + getCitiesListResponse.asXML());
        Element getCitiesListResult = getCitiesListResponse.element("GetCitiesListResult");
        System.out.println("getCitiesListResult:" + getCitiesListResult.asXML());
        System.out.println("getCitiesListResult:" + getCitiesListResult.getText());
        String realResult = getCitiesListResult.getText();
        Document document2 = saxReader.read((new ByteArrayInputStream(realResult
                .getBytes("UTF-8"))));
        Element rootElement = document2.getRootElement();
        System.out.println("rootElement:" + rootElement.asXML());

        Element resultCode = rootElement.element("Result");
        String code = resultCode.attributeValue("Code");
        System.out.println(code);
        Element citiesList = rootElement.element("CitiesList");
        Iterator<Element> cityList = citiesList.elementIterator("City");
        String sql = "insert into channel_city(city_id,city_name,city_pinyin,has_out_service,Created_STime,Modified_STime) VALUES \n" +
                "(%s,'%s','%s',%d,NOW(),now());";
        List<String> ids = new ArrayList<>();
        while (cityList.hasNext()) {
            Element city = cityList.next();
            String id = city.attributeValue("Id");
            String pinYin = city.attributeValue("PinYin");
            String hasOutService = city.attributeValue("HasOutService");
            String cityName = city.getTextTrim();
            System.out.println(String.format(sql, id, cityName, pinYin, "Y".equals(hasOutService) ? 1 : 0));
//            System.out.println(cityName + "--" + id + "--" + pinYin + "--" + hasOutService);
            ids.add(id);
        }
        System.out.println(ids);
//        Element getCitiesListResponse = getCitiesListResult.element("GetCitiesListResponse");
//        Iterator<Element> it = root.elementIterator();
//        while (it.hasNext()) {
//            Element el = it.next();
//            System.out.println(el.asXML());
//        }
//        System.out.println(root.asXML());
    }
}
