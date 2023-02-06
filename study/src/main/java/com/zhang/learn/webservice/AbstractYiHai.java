package com.zhang.learn.webservice;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;

public abstract class AbstractYiHai {
    protected String method;

    public String build() {
        return header(this.method) + content() + footer(this.method);
    }

    private String header(String method) {
        String header = "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                + "<s:Body>"
                + "     <" + method + " xmlns=\"http://tempuri.org/\">"
                + "         <requestData xmlns:a=\"EhiServiceDataContract\" xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "             <a:UserName>200462</a:UserName>"
                + "             <a:Password>123qwe</a:Password>"
                + "             <a:RequestContent>";
        return header;
    }

    private String footer(String method) {
        String footer = "             </a:RequestContent>"
                + "         </requestData>"
                + "     </" + method + ">"
                + " </s:Body>"
                + "</s:Envelope>";
        return footer;
    }

    protected abstract String content();
}
