package learn.webservice;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;

public class RequestBuilder {

    public static void main(String[] args) {
        System.out.println(build());
    }

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
    public static String build(){
        return header("GetCitiesList") + content() + footer("GetCitiesList");
    }
    private static String header(String method) {
        String header = "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                + "<s:Body>"
                + "     <" + method + " xmlns=\"http://tempuri.org/\">"
                + "         <requestData xmlns:a=\"EhiServiceDataContract\" xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "             <a:UserName>200462</a:UserName>"
                + "             <a:Password>123qwe</a:Password>"
                + "             <a:RequestContent>";
        return header;
    }

    private static String footer(String method) {
        String footer = "             </a:RequestContent>"
                + "         </requestData>"
                + "     </" + method + ">"
                + " </s:Body>"
                + "</s:Envelope>";
        return footer;
    }

    private static String content() {
        Document document = DocumentHelper.createDocument();
        document.addElement("GetCitiesListRequest");
        return document.getRootElement().asXML().replaceAll("<", "&lt;").replaceAll(">", "&gt;");
//        return document.toString();
    }
}
