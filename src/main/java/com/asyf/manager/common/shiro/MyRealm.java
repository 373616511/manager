package com.asyf.manager.common.shiro;

import java.util.HashMap;
import java.util.Map;

import com.asyf.manager.modules.sys.entity.User;
import com.asyf.manager.modules.sys.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.omg.CORBA.Principal;
import org.springframework.beans.factory.annotation.Autowired;


//@Service
public class MyRealm extends AuthorizingRealm {

    private static Logger logger = Logger.getLogger(AuthorizingRealm.class);

    @Autowired
    private UserService userService;

    /**
     * 验证当前登录的Subject
     * <p>
     * 经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        System.out.println("doGetAuthenticationInfo执行--");
        // 获取基于用户名和密码的令牌
        // 实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
        // 两个token的引用都是一样的
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        String password = new String(token.getPassword());
        // 接下来进行用户验证,假设可以通过
        // 说白了就是第一个参数填登录用户名,第二个参数填合法的登录密码(可以是从数据库中取到的,本例中为了演示就硬编码了)
        // 这样一来,在随后的登录页面上任意的用户和密码都能通过验证
        Map<String, String> param = new HashMap<String, String>();
        param.put("username", username);
        param.put("password", password);
        // 登录验证
        User user = new User();
        if (user != null && "zhangsan".equals(username)) {
            System.out.println("doGetAuthenticationInfo---user:" + user.toString());
            Principal principal = new Principal(username);
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, password,
                    getName());
            logger.info("返回simpleAuthenticationInfo");
            // 设置session过期时间
            SecurityUtils.getSubject().getSession().setTimeout(20 * 1000);
            return simpleAuthenticationInfo;
        } else {
            throw new AuthenticationException("用户或密码错误");
        }

    }

    /**
     * 为当前登录的Subject授予角色和权限
     * <p>
     * 经测试:本例中该方法的调用时机为需授权资源被访问时
     * 经测试:并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
     * 个人感觉若使用了Spring3.1开始提供的ConcurrentMapCache支持,
     * 则可灵活决定是否启用AuthorizationCache
     * 比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("doGetAuthorizationInfo执行");
        // 获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
        Principal p = (Principal) super.getAvailablePrincipal(principals);
        String currentUsername = p.getUsername();
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        // 实际中可能会从数据库取得
        if (null != currentUsername && "zhangsan".equals(currentUsername)) {
            // 添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
            simpleAuthorInfo.addRole("admin");
            // 添加权限
            simpleAuthorInfo.addStringPermission("manage");
            logger.info("已为用户[zhangsan]赋予了[admin]角色和[manage]权限");
            return simpleAuthorInfo;
        }
        return null;
    }

    @Override
    public String getName() {
        return "MyRealm";
    }

    public static class Principal {

        private String username;

        public Principal(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

    }
}
