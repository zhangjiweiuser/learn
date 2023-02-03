package com.zhang.learn.webservice;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;

public class GetCityRequest extends AbstractYiHai {
    public GetCityRequest(String method){
        this.method = method;
    }
    @Override
    protected String content() {
        Document document = DocumentHelper.createDocument();
        document.addElement("GetCitiesListRequest");
        return document.getRootElement().asXML().replaceAll("<", "&lt;").replaceAll(">", "&gt;");
//        return document.toString();
    }
}
