package learn.chapter2021.chapter03.chapter0318;

import com.alibaba.fastjson2.JSONObject;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/18 16:11
 */
public class HttpUtil {
    public static String get(String url) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                StatusLine statusLine = response.getStatusLine();
                System.out.println("statusLine = " + statusLine);
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    public static String getWithAras(String url, Map<String, String> params) {
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            StringBuilder urlParam = new StringBuilder();
            for (Map.Entry<String, String> param : params.entrySet()) {
                String key = param.getKey();
                String value = param.getValue();
                urlParam.append(key).append("=").append(value).append("&");
            }
            String urlLast = url + "?" + urlParam.deleteCharAt(urlParam.length() - 1);
            System.out.println(urlLast);
            HttpGet httpGet = new HttpGet(urlLast);
            response = client.execute(httpGet);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                StatusLine statusLine = response.getStatusLine();
                System.out.println("statusLine = " + statusLine);
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    public static String post(String url) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpGet = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                StatusLine statusLine = response.getStatusLine();
                System.out.println("statusLine = " + statusLine);
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    public static String postWithArag(String url, Map<String, String> params) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            List<NameValuePair> nvps = new ArrayList<>();
            for (Map.Entry<String, String> param : params.entrySet()) {
                nvps.add(new BasicNameValuePair(param.getKey(), param.getValue()));
            }

            httpPost.setEntity(new UrlEncodedFormEntity(nvps,Consts.UTF_8));


            response = client.execute(httpPost);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                StatusLine statusLine = response.getStatusLine();
                System.out.println("statusLine = " + statusLine);
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    public static String postWithJsonArag(String url, Map<String, String> params) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            JSONObject jsonParam = new JSONObject();
            for (Map.Entry<String, String> param : params.entrySet()) {
                jsonParam.put(param.getKey(), param.getValue());
            }
            httpPost.setEntity(new StringEntity(jsonParam.toString()));
            httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
            response = client.execute(httpPost);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                StatusLine statusLine = response.getStatusLine();
                System.out.println("statusLine = " + statusLine);
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
