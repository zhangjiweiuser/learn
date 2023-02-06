package com.zhang.learn.chapter03.chapter0318;

import com.zhang.learn.chapter2021.chapter03.chapter0318.HttpUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/18 16:19
 */
public class HttpUtilTest {

    @Test
    void getNoArgsTest() {
        String baidu = HttpUtil.get("http://www.baidu.com");
        System.out.println(baidu);
    }

    @Test
    void getWithArgsTest() {
        String url = "http://www.baidu.com/s";
        Map<String, String> params = new HashMap<>();
        params.put("ie", "utf-8");
        params.put("f", "8");
        params.put("rsv_bp", "1");
        params.put("tn", "baidu");
        params.put("wd", "github");
        params.put("oq", "github%2520java");
        params.put("rsv_pq", "d14276430000781c");
        params.put("rsv_t", "54cdc3dTrNBG8qdOT389PP25NXi4k3ZiBU2cTT3y7Cg9jxqQyejuKnHej1U");
        params.put("rqlang", "cn");
        params.put("rsv_enter", "1");
        params.put("rsv_dl", "tb");
        params.put("rsv_btype", "t");
        params.put("inputT", "5314");
        params.put("rsv_sug3", "115");
        params.put("rsv_sug1", "99");
        params.put("rsv_sug7", "100");
        params.put("bs", "github%20java");
        String baidu = HttpUtil.getWithAras(url, params);
        System.out.println(baidu);
    }


    @Test
    void postNoArgsTest() {
        for (int i = 0; i < 100; i++) {
            String baidu = HttpUtil.post("http://127.0.0.1:10012/rent/car/backend/tenantUser/post");
            System.out.println(baidu);

        }
    }

    @Test
    void postWithArgsTest() {
        Map<String, String> params = new HashMap<>();
        params.put("id","10");
        String baidu = HttpUtil.postWithJsonArag("http://127.0.0.1:10012/rent/car/backend/tenantUser/post2",params);

        System.out.println(baidu);
    }

    @Test
    void postWithWWWArgsTest() {
        Map<String, String> params = new HashMap<>();
        params.put("id","10");
        params.put("name","张三");
        String baidu = HttpUtil.postWithArag("http://127.0.0.1:10012/rent/car/backend/tenantUser/post3",params);

        System.out.println(baidu);
    }
}
