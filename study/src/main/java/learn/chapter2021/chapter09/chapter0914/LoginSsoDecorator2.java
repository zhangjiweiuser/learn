package learn.chapter2021.chapter09.chapter0914;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/14 15:00
 */
public class LoginSsoDecorator2 extends SsoDecorator {

    private static Map<String, String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    public LoginSsoDecorator2(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {

        boolean success = super.preHandle(request, response, handler);
        if (!success) {
            return false;
        }
        String userId = request.substring(9);
        String method = authMap.get(userId);
        return "queryUserInfo".equals(method);
    }
}
