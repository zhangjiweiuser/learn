package com.zhang.learn.webservice;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class GetStoreListAllRequest extends AbstractYiHai {


    public GetStoreListAllRequest(String method) {
        this.method = method;
    }

    @Override
    protected String content() {
        Document document = DocumentHelper.createDocument();
        Element getStoresListRequest = document.addElement("GetStoresListAllRequest");
//        Element store = getStoresListRequest.addElement("City");
//        store.addAttribute("Id", String.valueOf(this.id));
        return document.getRootElement().asXML().replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }
}
