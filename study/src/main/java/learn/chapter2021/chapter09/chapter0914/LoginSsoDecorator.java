package learn.chapter2021.chapter09.chapter0914;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/14 15:00
 */
public class LoginSsoDecorator extends SsoInterceptor {

    private static Map<String, String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        boolean success = "success".equals(ticket);
        if (!success) {
            return false;
        }
        String userId = request.substring(9);
        String method = authMap.get(userId);
        return "queryUserInfo".equals(method);
    }
}
