package com.zhang.db.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class HttpClientUtils {
    private static PoolingHttpClientConnectionManager cm;

    private static volatile CloseableHttpClient client;
    private static RequestConfig config;

    private static String UTF_8 = "UTF-8";

    static {
        cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);// 整个连接池最大连接数
        cm.setDefaultMaxPerRoute(20);// 每路由最大连接数，默认值是2
        config = RequestConfig.custom().setConnectTimeout(3000) // 创建连接的最长时间
                .setConnectionRequestTimeout(5000) // 从连接池中获取到连接的最长时间
     //           .setSocketTimeout(10000) // 数据传输的最长时间
                .build();
    }

    /**
     * 通过连接池获取HttpClient
     *
     * @return
     */
    private static CloseableHttpClient getHttpClient() {
//        if(null == client){
//            synchronized (HttpClientUtils.class){
//                if(null == client){
                    return HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(config).build();
//                }
//            }
//        }
//        return client;
    }

    /**
     * 带参数的get请求
     *
     * @return
     * @throws Exception
     */
    public static String doGet(String url, Map<String, Object> map) throws Exception {
        // 从连接池获取HttpClient
        CloseableHttpClient httpClient = getHttpClient();

        // 设置请求的url
        URIBuilder uriBuilder = new URIBuilder(url);

        // 创建httpGet
        HttpGet httpGet = new HttpGet();

        // 设置配置信息
        httpGet.setConfig(config);

        // 判断map
        if (map != null) {
            // 遍历map，并设置请求参数
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        // uri设置到httpGet中
        httpGet.setURI(uriBuilder.build());

        // 发起请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

        // 判断状态码为200就返回响应体内容
        if (response.getStatusLine().getStatusCode() == 200) {
            return EntityUtils.toString(response.getEntity(), UTF_8);
        }
        return null;
    }

    /**
     * 不带参数的get请求
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String doGet(String url) throws Exception {
        return doGet(url, null);
    }

    /**
     * 带参数的post请求
     *
     * @return
     * @throws Exception
     */
    public static String doPost(String url, Map<String, Object> map) throws Exception {
        // 从连接池获取HttpClient
        CloseableHttpClient httpClient = getHttpClient();

        // 设置请求的url
        URIBuilder uriBuilder = new URIBuilder(url);

        // 创建httpPost
        HttpPost httpPost = new HttpPost();

        // 设置配置信息
        httpPost.setConfig(config);

        // 判断map
        if (map != null) {

            // 声明保存请求参数的list
            List<NameValuePair> list = new ArrayList<NameValuePair>();

            // 遍历map，并设置请求参数
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }

            // 构造form表单的entity对象
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, UTF_8);
            // 设置该对象到httpPost中
            httpPost.setEntity(urlEncodedFormEntity);
        }

        // uri设置到httpPost中
        httpPost.setURI(uriBuilder.build());

        // 发起请求
        CloseableHttpResponse response = httpClient.execute(httpPost);

        // 构造返回对象
        String result = EntityUtils.toString(response.getEntity(), UTF_8);
        return result;
    }

    /**
     * 不带参数的post请求
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String doPost(String url) throws Exception {
        return doPost(url, null);
    }

    /**
     * 带参数的post请求，请求body为json数据
     *
     * @param url
     * @param json
     * @return
     * @throws Exception
     * @throws
     */
    public static String doPostJson(String url, String json) throws Exception {
        CloseableHttpClient httpClient = null;
        // 从连接池获取HttpClient
        httpClient = getHttpClient();
        // 声明http的post请求
        HttpPost httpPost = new HttpPost(url);
        // 设置请求参数
        httpPost.setConfig(config);

        // 构造请求体
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);

        // 发出请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        // 返回请求结果
        return EntityUtils.toString(response.getEntity(), UTF_8);
    }
}
