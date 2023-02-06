package learn;

import cn.hutool.http.HttpUtil;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/7/28 10:33
 */
public class HttpTest {
    public static void main(String[] args) {
        String result = HttpUtil.get("https://www.baidu.com/");
        System.out.println(result);
    }
}
