package com.highmind.service;

import java.util.Map;

import com.highmind.entity.Employee;

/**
 * @ClassName EmployeeService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 上午11:29:34
 * @version 1.0.0
 */
public interface EmployeeService extends BaseService<Employee>{
   /**
    * 为用户设置角色
    * @Description
    * @param map 传递的参数为用户id 和角色id,domainid
    * @return 
    */
   int addRoleForEmployee(Map<String,Object> map);

   /**
    * 判断用户是否存在
    * @param map 传递的参数为loginId ,domainid
    * @return
    */
   Employee checkUser(Map<String,Object> map);
}
