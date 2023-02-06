package learn;

import com.alibaba.fastjson2.JSONObject;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/10 15:13
 */
public class PaiXuTest {
    @Test
    void paixu() throws IOException {
        List<String> lines = Files.readLines(new File("D:/paixu.txt"), Charset.forName("UTF-8"));
        System.out.println(lines.get(0));
        JSONObject jsonObject = JSONObject.parseObject(lines.get(0));

        jsonObject.remove("_sign");
        jsonObject.remove("autohomeua");
        Map<String, String> map = new HashMap<>();
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.getString(key);
            if (value != null) {
                map.put(key, value.toString());
            }
        }

        TreeMap<String, String> sortMap = new TreeMap(map);
        StringBuilder sb = new StringBuilder("123456789");
        for (Map.Entry<String, String> entry : sortMap.entrySet()) {
            if (StringUtils.isNotEmpty(entry.getKey()) && StringUtils.isNotEmpty(entry.getValue())) {
                //排除掉 sign、autohomeua
                if ("_sign".equals(entry.getKey()) || "sign".equals(entry.getKey()) || "autohomeua".equalsIgnoreCase(entry.getKey())) {
                    continue;
                }
                sb.append(entry.getKey());

                sb.append(entry.getValue());

            }
        }
        sb.append("123456789");
        System.out.println(sb.toString());
    }
}
