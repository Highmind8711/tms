package com.highmind.shiro.realm.DatabaseRealm;
 
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.highmind.entity.Employee;
import com.highmind.service.EmployeeService;
import com.highmind.service.PermissionService;
import com.highmind.service.RuleService;
import com.highmind.tool.Constants;
 
 
public class DatabaseRealm extends AuthorizingRealm {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    RuleService ruleService;
    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //能进入到这里，表示账号已经通过验证了
        Session session = SecurityUtils.getSubject().getSession();
        Employee employee=(Employee)session.getAttribute(Constants.SESSION_USER_INFO);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("Eid", employee.getId());
        //通过service获取角色和权限
        Set<String> permissions = permissionService.selectPermissionByEid(map);
        Set<String> roles = ruleService.selectRuleByEid(map);
         
        //授权对象
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        //把通过service获取到的角色和权限放进去
        s.setStringPermissions(permissions);
        s.setRoles(roles);
        return s;
    }
    /**
     * 先认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取账号密码
        UsernamePasswordToken t = (UsernamePasswordToken) token;
        String loginid= t.getUsername();
        String domainId=t.getHost();
        String password= new String( t.getPassword());
        Map<String,Object> mapLogin=new HashMap<String,Object>();
        mapLogin.put("loginId",loginid);
        mapLogin.put("password",password);
        mapLogin.put("domainid", domainId);
        Employee employee=employeeService.checkUser(mapLogin);
        if(employee == null) {
          //没找到帐号
            throw new UnknownAccountException();
        }
        
        //认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
        SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(loginid,password,getName());
        SecurityUtils.getSubject().getSession().setAttribute(Constants.SESSION_USER_INFO, employee); 
        return a;
    }
 
}
