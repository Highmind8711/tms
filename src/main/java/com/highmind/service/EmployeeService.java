/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.service
 *
 *    Filename:    EmployeeService.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     61430
 *
 *    @version:    1.0.0
 *
 *    Create at:   2019年4月3日 上午11:29:34
 *
 *    Revision:
 *
 *    2019年4月3日 上午11:29:34
 *        - first revision
 *
 *****************************************************************/
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
    * @param map 传递的参数为用户id 和角色id
    * @return 
    */
   int addRoleForEmployee(Map<String,String> map);
}
