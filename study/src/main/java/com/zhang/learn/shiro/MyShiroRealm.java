package com.zhang.learn.shiro;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/8/20 14:10
 */
public class MyShiroRealm extends AuthorizingRealm {

//    @Autowired
//    private SysUserMapper sysUserMapper;

    /**
     * 主要是用来进行身份认证的，即验证用户输入的账号和密码是否正确
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户的输入的账号.
        UsernamePasswordToken t = (UsernamePasswordToken) token;
        // 用户名
        String username = (String) token.getPrincipal();
        // 密码
        String password = new String(t.getPassword());
        // 获取数据库中的密码
        String passwordDb = "123456";

        // 通过username从数据库中查找
//        SysUser user = sysUserMapper.getByUsername(username);
//        if (user == null) {
//            return null;
//        }
//        if (user.getStatus() == SysUser.Status.Disabled.getCode()) {
//            throw new LockedAccountException();
//        }
        if (!password.equals(passwordDb)) {
            throw new AuthenticationException();
        }

        String passwordJia = DigestUtils.md5Hex("123456");
        SysUser user = new SysUser("zhangsan", passwordJia, 1);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, // 用户名
                passwordJia, // 密码
                getName() // realm name
        );

        return authenticationInfo;

    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

}
