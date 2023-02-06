package learn.chapter2021.chapter09.chapter0914;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/14 14:57
 */
public class SsoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        return "success".equals(ticket);
    }
}
