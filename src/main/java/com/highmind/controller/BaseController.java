/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    BaseController.java
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
 *    Create at:   2019年4月4日 上午9:38:23
 *
 *    Revision:
 *
 *    2019年4月4日 上午9:38:23
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.highmind.service.*;

/**
 * @ClassName BaseController
 * @Description TODO
 * @author 61430
 * @Date 2019年4月4日 上午9:38:23
 * @version 1.0.0
 */
public abstract class BaseController<T> {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    MenuService menuService;
    @Autowired
    OperationService operationService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    RuleService ruleService;
    @Autowired
    PermissionMenuService permissionMenuService;
    @Autowired
    PermissionOperationService permissionOperationService;
    @Autowired
    RuleEmployeeService ruleEmployeeService;
    @Autowired
    RulePermissionService rulePermissionService;
    public String add(T t) {
        return null;
    }   
    public String getAll() {
        return null;
    }    
    public String getOne(@PathVariable("id") Long id) {
        return null;
    }    
    public String update(T t) {
        return null;
    }
    
    public String delete(@PathVariable("id")Long id) {
        return null;
    }
    public String addResult(BaseService<T> baseService,T t) {
        JSONObject jsonObject=new JSONObject();
        // TODO Auto-generated method stub
        int id =baseService.add(t);
        if(id>=-1) {
            jsonObject.put("status", 1);
            jsonObject.put("data", id);
        }else {
            jsonObject.put("status", 0);
            jsonObject.put("error", "插入数据失败");
        }
        return JSON.toJSONString(jsonObject,SerializerFeature.WriteMapNullValue);
        
    }
    public String getOneResult(BaseService<T> baseService,Long id) {
        JSONObject jsonObject=new JSONObject();
        Map<String,Object> hashMap=new HashMap<String,Object>();
        hashMap.put("id",id);
        T selectById = baseService.selectById(hashMap);
        if(selectById!=null) {
            jsonObject.put("status", 1);
            jsonObject.put("data",selectById);
        }else {
            jsonObject.put("status", 0);
            jsonObject.put("error", "数据获取失败");
        }
        return JSON.toJSONString(jsonObject,SerializerFeature.WriteMapNullValue);
    }
    public String getAllResult(BaseService<T> baseService) {
        JSONObject jsonObject=new JSONObject();
        List<T> selectAll = baseService.selectAll();
        if(selectAll.size()>=0) {
            jsonObject.put("status", 1);
            jsonObject.put("data",selectAll);
        }else {
            jsonObject.put("status", 0);
            jsonObject.put("error", "数据获取失败");
        }
        return JSON.toJSONString(jsonObject,SerializerFeature.WriteMapNullValue);
    }
    public String updateResult(BaseService<T> baseService,T t) {
        JSONObject jsonObject=new JSONObject();
        int id =baseService.update(t);
        if(id>=-1) {
            jsonObject.put("status", 1);
            jsonObject.put("data",  id);
        }else {
            jsonObject.put("status", 0);
            jsonObject.put("error", "更新数据失败");
        }
        return JSON.toJSONString(jsonObject,SerializerFeature.WriteMapNullValue);
    }
    public String deleteResult(BaseService<T> baseService,Long id) {
        JSONObject jsonObject=new JSONObject();
        int result=baseService.del(id);
        if(result>=-1) {
            jsonObject.put("status", 1);
            jsonObject.put("data", id);
        }else {
            jsonObject.put("status", 0);
            jsonObject.put("error", "删除数据失败");
        }
        return JSON.toJSONString(jsonObject,SerializerFeature.WriteMapNullValue);
        
    }
}
