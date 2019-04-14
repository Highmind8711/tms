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

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.highmind.entity.CodeMsg;
import com.highmind.entity.Result;
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

    SimplePropertyPreFilter successFilter = new SimplePropertyPreFilter(Result.class, "status","data");
    SimplePropertyPreFilter errorFilter = new SimplePropertyPreFilter(Result.class, "status","error");
    public String addResult(BaseService<T> baseService,T t) {
        // TODO Auto-generated method stub
        int id =baseService.add(t);
        if(id>0) {
            return JSONObject.toJSONString(Result.success(id),successFilter,SerializerFeature.WriteMapNullValue);
        }else {
            return JSONObject.toJSONString(Result.error(CodeMsg.INSERT_ERROR),errorFilter,SerializerFeature.WriteMapNullValue);
        }
        
    }
    public String getOneResult(BaseService<T> baseService,Long id) {
        Map<String,Object> hashMap=new HashMap<String,Object>();
        hashMap.put("id",id);
        T selectById = baseService.selectById(hashMap);
        if(selectById!=null) {
            return JSONObject.toJSONString(Result.success(selectById),successFilter,SerializerFeature.WriteMapNullValue);
        }else {
            return JSONObject.toJSONString(Result.error(CodeMsg.NOT_FIND_DATA),errorFilter,SerializerFeature.WriteMapNullValue);
        }

    }
    public String getAllResult(BaseService<T> baseService) {
        List<T> selectAll = baseService.selectAll();
        if(!selectAll.isEmpty()) {
            return JSONObject.toJSONString(Result.success(selectAll),successFilter,SerializerFeature.WriteMapNullValue);
        }else {
            return JSONObject.toJSONString(Result.error(CodeMsg.NOT_FIND_DATA),errorFilter,SerializerFeature.WriteMapNullValue);
        }

    }
    public String updateResult(BaseService<T> baseService,T t) {
        int id =baseService.update(t);
        if(id>0) {
            return JSONObject.toJSONString(Result.success(id),successFilter,SerializerFeature.WriteMapNullValue);
        }else {
            return JSONObject.toJSONString(Result.error(CodeMsg.UPDATE_ERROR),errorFilter,SerializerFeature.WriteMapNullValue);
        }
    }
    public String deleteResult(BaseService<T> baseService,Long id) {
        int result=baseService.del(id);
        if(result>0) {
            return JSONObject.toJSONString(Result.success(id),successFilter,SerializerFeature.WriteMapNullValue);
        }else {
            return JSONObject.toJSONString(Result.error(CodeMsg.DELETE_ERROR),errorFilter,SerializerFeature.WriteMapNullValue);
        }
        
    }
}
