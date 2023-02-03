package com.zhang.learn.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/8/20 14:11
 */
@Controller
@RequestMapping("/web")
public class HomeController extends BaseController {

    /**
     * 登录
     * @param request
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login", method= RequestMethod.POST)
    @ResponseBody
    public RespEntity<String> doLogin(HttpServletRequest request, @RequestBody SysUser user) throws Exception {
        RespEntity<String> result = new RespEntity<String>();
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            subject.login(token);
            String authorization = (String) subject.getSession().getId();
            result.setHttpCode(200);
            result.setData(authorization); //将authorization传给前端，用于MySessionManager中请求的验证
            result.setMessage("登陆成功");
        } catch (IncorrectCredentialsException e) {
            result.setMessage("密码错误");
        } catch (LockedAccountException e) {
            result.setMessage("该用户已被禁用");
        } catch (AuthenticationException e) {
            result.setMessage("该用户不存在");
        }
        return result;
    }

    /**
     * 注销
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/logout")
    @ResponseBody
    public RespEntity<String> logout(HttpServletRequest request) throws Exception {
        RespEntity<String> resp = new RespEntity<>();
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        resp.setHttpCode(200);
        resp.setMessage("注销成功");
        return resp;
    }

    /**
     * 未登录
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public RespEntity<String> unauth(HttpServletRequest request) throws Exception {
        RespEntity<String> resp = new RespEntity<>();
        resp.setHttpCode(-2);
        resp.setMessage("重新登录");
        return resp;
    }

    @RequestMapping(value = "/error")
    @ResponseBody
    public RespEntity<String> error(HttpServletRequest request) throws Exception {
        RespEntity<String> resp = new RespEntity<>();
        resp.setHttpCode(-1);
        resp.setMessage("服务器异常");
        return resp;
    }

}
