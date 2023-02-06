package learn.chapter2023.chapter02.chapter0203.gongchangmoshi.store;

import java.util.Map;

public interface ICommodity {
    void sendCommodity(String uId, String commodity, String bizId, Map<String,String> extMap) throws Exception;
}
