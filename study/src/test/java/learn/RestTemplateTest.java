package learn;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/12/29 16:17
 */
@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RestTemplateTest {

    private RestTemplate restTemplate;

    @BeforeAll
    public void init() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(30000);// 设置连接超时，单位毫秒
        requestFactory.setReadTimeout(30000);  //设置读取超时
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory);
        log.info("RestTemplate初始化完成");
        this.restTemplate = restTemplate;
    }

    @Test
    public void baiDuTest() {
        String url = "https://zhuanlan.zhihu.com/p/77404755";
        String result = restTemplate.getForObject(url, String.class);
        log.info("result:{}", result);
    }

    @Test
    public void openCity() {
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("timestamp", System.currentTimeMillis());
        String sign = sign(paramMap, "3c9417ba35b622450aa77926e123hl123");
        paramMap.put("client_id", "c24f634ce80234233");
        paramMap.put("sign", sign);
        log.info("yaochuxing getCities paramMap:{}", paramMap);
        String result = getObject("https://openapistable2.starrides.com/cop-deploy/v2/common/findOpenCity", paramMap);
        log.info("yaochuxing getCities result:{}", result);
    }

    @Test
    public void openCityByEntity() {
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("timestamp", System.currentTimeMillis());
        String sign = sign(paramMap, "3c9417ba35b622450aa77926e123hl123");
        paramMap.put("client_id", "c24f634ce80234233");
        paramMap.put("sign", sign);
        log.info("yaochuxing getCities paramMap:{}", paramMap);
        ResponseEntity<String> result = getEntity("https://openapistable2.starrides.com/cop-deploy/v2/common/findOpenCity", paramMap);
        System.out.println(result.getStatusCodeValue());
        if(HttpStatus.SC_OK == result.getStatusCodeValue()){
            String body = result.getBody();
            log.info("yaochuxing getCities result:{}", body);
        }

    }

    private String getObject(String url, Map<String, ?> param) {
        if (MapUtils.isNotEmpty(param)) {
            StringBuilder sb = new StringBuilder(url + "?");
            for (Map.Entry<String, ?> entry : param.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url = sb.substring(0, sb.length() - 1);
        }
        return restTemplate.getForObject(url, String.class);
    }

    private ResponseEntity<String> getEntity(String url, Map<String, ?> param) {
        if (MapUtils.isNotEmpty(param)) {
            StringBuilder sb = new StringBuilder(url + "?");
            for (Map.Entry<String, ?> entry : param.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url = sb.substring(0, sb.length() - 1);
        }
        return restTemplate.getForEntity(url, String.class);
    }

    private String postEntity(String url, Map<String, ?> param) {
        if (MapUtils.isNotEmpty(param)) {
            StringBuilder sb = new StringBuilder(url + "?");
            for (Map.Entry<String, ?> entry : param.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url = sb.substring(0, sb.length() - 1);
        }
        return null;
    }
    private final String SIGN_KEY = "sign_key";

    public String sign(Map<String, Object> params, String signKey) {
        params.put(SIGN_KEY, signKey);
        Map<String, String> needVerify = new HashMap<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            needVerify.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        List<Map.Entry<String, String>> entryList = new ArrayList<>(needVerify.entrySet());
        //排序
        entryList.sort(Comparator.comparing(Map.Entry::getKey));
        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<String, String> entry : entryList) {
            buffer.append(entry.getKey()).append(entry.getValue());
        }
        log.info("sha1 签名参数:{}", buffer.toString());
        String sha = DigestUtils.sha1DigestAsHex(buffer.toString());
        params.remove(SIGN_KEY);
        return sha;
    }
}
