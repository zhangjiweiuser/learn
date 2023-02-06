package learn.shiro;

import com.alibaba.fastjson2.JSON;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.util.WebUtils;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/8/20 14:12
 */
public class BaseController {
    @Autowired
    private RedisSessionDAO redisSessionDAO;

    public SysUser getUserByHeader(ServletRequest request) throws Exception{
        //前端ajax的headers中必须传入Authorization的值
        String id = WebUtils.toHttp(request).getHeader("Authorization");
        Session session = redisSessionDAO.readSession(id);
        Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        SimplePrincipalCollection coll = (SimplePrincipalCollection) obj;
        String userStr = JSON.toJSON(coll.getPrimaryPrincipal()).toString();
        SysUser user = JSON.parseObject(userStr, SysUser.class);
        return user;
    }

}
