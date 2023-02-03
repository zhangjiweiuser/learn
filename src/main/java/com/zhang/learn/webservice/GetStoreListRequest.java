package com.zhang.learn.webservice;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.dom.DOMText;

public class GetStoreListRequest extends AbstractYiHai {
    private int id;

    public GetStoreListRequest(String method, int id) {
        this.id = id;
        this.method = method;
    }

    @Override
    protected String content() {
        Document document = DocumentHelper.createDocument();
        Element getStoresListRequest = document.addElement("GetStoresListRequest");
        Element store = getStoresListRequest.addElement("City");
        store.addAttribute("Id", String.valueOf(this.id));
        return document.getRootElement().asXML().replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }
}
