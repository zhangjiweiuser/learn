package learn.webservice;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;


public class HttpClientUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

    private static CloseableHttpClient httpClient;
    private static final Object lock = new Object();

    private static CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            synchronized (lock) {
                if (httpClient == null) {
                    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
                    cm.setMaxTotal(800);
                    cm.setDefaultMaxPerRoute(200);
                    httpClient = HttpClients.custom()
                            .setConnectionManager(cm)
                            .setConnectionTimeToLive(300, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return httpClient;
    }

    /**
     * 发送post请求
     *
     * @param url        请求url
     * @param soapAction 请求头参数
     * @param soapXml    参数
     * @return 接口响应
     */
    public static String doPost(String url, String soapAction, String soapXml) {


        String json = null;
        CloseableHttpClient client = getHttpClient();

        HttpPost method = new HttpPost(url);

        StringEntity data = new StringEntity(soapXml,
                Charset.forName("UTF-8"));
        method.setEntity(data);
        method.setHeader("Content-Type", "text/xml;charset=UTF-8");
        method.setHeader("SOAPAction", soapAction);
        //解决中文乱码

        HttpContext context = new BasicHttpContext();
        try (CloseableHttpResponse result = client.execute(method, context)) {
            json = processResponse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }


    private static String processResponse(CloseableHttpResponse result) throws IOException {
        if (result.getStatusLine().getStatusCode() == 200) {

            return EntityUtils.toString(result.getEntity());

        } else {
            LOGGER.error("HTTP 请求失败，服务端返回：{}", result.getStatusLine());
        }
        return null;
    }
}
