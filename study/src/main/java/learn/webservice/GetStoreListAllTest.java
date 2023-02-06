package learn.webservice;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.Iterator;

public class GetStoreListAllTest {
    public static void main(String[] args) throws DocumentException, IOException {
        //地址
        String urlString = "http://demo3.1hai.cn/Ehiservice/EhiService.svc";
        //方法
        String soapActionString = "http://tempuri.org/IEhiService/GetStoresListAll";
        AbstractYiHai getStoreListAllRequest = new GetStoreListAllRequest("GetStoresListAll");
        System.out.println(getStoreListAllRequest.build());
        String soapXml = getStoreListAllRequest.build();
        String result = HttpClientUtil.doPost(urlString, soapActionString, soapXml);
        SAXReader saxReader = new SAXReader();
        System.out.println("result:" + result);
        Document document = saxReader.read((new ByteArrayInputStream(result
                .getBytes("UTF-8"))));
        Element root = document.getRootElement();
        System.out.println("root.asXML():" + root.asXML());
        String br = root.asXML();
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("D:/xml.txt")));
        bw.write(br.replaceAll("&gt;",">").replaceAll("&lt;","<"));
        bw.close();
        Element body = root.element("Body");
        System.out.println("body:" + body.asXML());
        Iterator<Element> it = body.elementIterator();
        while (it.hasNext()) {
            Element el = it.next();
            System.out.println("el:" + el.getName());
            System.out.println("el.asXML()" + el.asXML());
        }
        Element getCitiesListResponse = body.element("GetStoresListAllResponse");
        System.out.println("getCitiesListResponse:" + getCitiesListResponse.asXML());
        Element getCitiesListResult = getCitiesListResponse.element("GetStoresListAllResult");
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
        Element citiesList = rootElement.element("StoresList");
        Iterator<Element> storeList = citiesList.elementIterator("Store");
//        String sql = "insert into channel_city(city_id,city_name,city_pinyin,has_out_service,Created_STime,Modified_STime) VALUES \n" +
//                "(%s,'%s','%s',%d,NOW(),now());";
//        List<String> ids = new ArrayList<>();
        while (storeList.hasNext()) {
            Element store = storeList.next();
            String id = store.attributeValue("Id");
            String Type = store.attributeValue("Type");
            String IsAirport = store.attributeValue("IsAirport");
            String IsPhysicalStore = store.attributeValue("IsPhysicalStore");
            String PaymentType = store.attributeValue("PaymentType");
            String Hours = store.attributeValue("Hours");
            String OpenStatus = store.attributeValue("OpenStatus");
            String IsAllHoursStore = store.attributeValue("IsAllHoursStore");
            String DisplayType = store.attributeValue("DisplayType");
            String name = store.element("Name").getTextTrim();
            String NameEn = store.element("NameEn").getTextTrim();
            String phoneNo = store.element("PhoneNo").getTextTrim();
            Element AddressInfo = store.element("AddressInfo");
            Element CityEle = AddressInfo.element("City");
            String cityId = CityEle.attributeValue("Id");
            String cityName = CityEle.getTextTrim();
            String PinYin = CityEle.attributeValue("PinYin");
            String HasOutService = CityEle.attributeValue("HasOutService");
            String District = AddressInfo.element("District").getTextTrim();
            String BusinessDistrict = AddressInfo.element("BusinessDistrict").getTextTrim();
            String Address = AddressInfo.element("Address").getTextTrim();
            String AddressEn = AddressInfo.element("AddressEn").getTextTrim();
            Element Coordinate = store.element("Coordinate");
            String Provider = Coordinate.attributeValue("Provider");
            String Longitude = Coordinate.element("Longitude").getTextTrim();
            String Latitude = Coordinate.element("Latitude").getTextTrim();
            Element BusinessHours = store.element("BusinessHours");
            String OpeningTime = BusinessHours.element("OpeningTime").getTextTrim();
            String ClosingTime = BusinessHours.element("ClosingTime").getTextTrim();
            Element StorePhotos = store.element("StorePhotos");
            String string = "";
            if (null != StorePhotos) {
                string = StorePhotos.attributeValue("string");
            }
//            String EarliestBookingTime ="";
//            if (null != StorePhotos) {
//                EarliestBookingTime = city.element("EarliestBookingTime").getTextTrim();
//            }
//            String PickupPointLongUrl ="";
//            = city.element("PickupPointLongUrl").getTextTrim();
//            String DropOffPointLongUrl = city.element("DropOffPointLongUrl").getTextTrim();
            System.out.println(id + "--" + Type + "--" + IsAirport + "--" + PaymentType + "--" + Hours + "--" + OpenStatus
                    + "--" + IsAllHoursStore + "--" + DisplayType + "--" + IsPhysicalStore + "--" + name + "--" + NameEn
                    + "--" + cityId + "--" + PinYin + "--" + HasOutService
                    + "--" + District + "--" + BusinessDistrict + "--" + Address + "--" + AddressEn + "--" + phoneNo + "--" + Provider
                    + "--" + Longitude + "--" + Latitude + "--" + OpeningTime + "--" + ClosingTime + "--" + string + "--");
//            System.out.println(String.format(sql, id, cityName, pinYin, "Y".equals(hasOutService) ? 1 : 0));
//            ids.add(id);
        }
//        System.out.println(ids);

    }
}
