/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.shiro.realm.DatabaseRealm
 *
 *    Filename:    WebCasRealm.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    @author:     61430
 *
 *    @version:    1.0.0
 *
 *    Create at:   2019年4月22日 下午8:33:18
 *
 *    Revision:
 *
 *    2019年4月22日 下午8:33:18
 *        - first revision
 *
 *****************************************************************/
package com.highmind.shiro.realm.DatabaseRealm;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.highmind.entity.Employee;
import com.highmind.service.EmployeeService;
import com.highmind.service.PermissionService;
import com.highmind.service.RuleService;
import com.highmind.tool.Constants;

import io.buji.pac4j.realm.Pac4jRealm;

/**
 * @ClassName WebCasRealm
 * @Description TODO
 * @author 61430
 * @Date 2019年4月22日 下午8:33:18
 * @version 1.0.0
 */
public class WebCasRealm extends Pac4jRealm{
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    RuleService ruleService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        // TODO Auto-generated method stub
        //调用父类的方法，然后授权用户
        AuthenticationInfo authc = super.doGetAuthenticationInfo(token);
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
        SecurityUtils.getSubject().getSession().setAttribute(Constants.SESSION_USER_INFO, employee); 
        return authc;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // TODO Auto-generated method stub

        // 用户名称
        Object loginid = principals.getPrimaryPrincipal();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("Eid", loginid);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //通过service获取角色和权限
        Set<String> permissions = permissionService.selectPermissionByEid(map);
        Set<String> roles = ruleService.selectRuleByEid(map);

        //把通过service获取到的角色和权限放进去
        info.setStringPermissions(permissions);
        info.setRoles(roles);
        return info;
    }
    
}
