package com.zhang.learn.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/8/20 14:11
 */
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

    /**
     * 登录
     *
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/hello")
    public RespEntity<String> doHello(HttpServletRequest request) throws Exception {
        RespEntity<String> result = new RespEntity<String>();
        try {

            result.setHttpCode(200);
            result.setData("hello");
            result.setMessage("hello");
        } catch (IncorrectCredentialsException e) {
            result.setMessage("密码错误");
        } catch (LockedAccountException e) {
            result.setMessage("该用户已被禁用");
        } catch (AuthenticationException e) {
            result.setMessage("该用户不存在");
        }
        return result;
    }


}
