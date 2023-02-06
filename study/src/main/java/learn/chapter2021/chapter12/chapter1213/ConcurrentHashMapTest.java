package learn.chapter2021.chapter12.chapter1213;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/12/13 14:18
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(16);
        map.put("a", "a");
        map.put("b", "b");
        map.put("97", "b");
    }
}
