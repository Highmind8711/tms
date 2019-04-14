/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    DepartmentController.java
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
 *    Create at:   2019年4月3日 上午11:39:41
 *
 *    Revision:
 *
 *    2019年4月3日 上午11:39:41
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;

import java.util.List;

import com.highmind.entity.CodeMsg;
import com.highmind.entity.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.highmind.entity.Department;

/**
 * @ClassName DepartmentController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 上午11:39:41
 * @version 1.0.0
 */
@RestController
public class DepartmentController extends BaseController<Department>{
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#add()
     */
    @Override
    @RequestMapping(value="/departments",method=RequestMethod.POST)
    public String add(Department t) {
        return super.addResult(departmentService,t);
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getOne()
     */
    @Override
    @RequestMapping(value="/departments/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getOne(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        return super.getOneResult(departmentService,id);
    }
    /* (非 Javadoc)
     * Description:查询部门下的所有的员工
     * @see com.highmind.controller.BaseController#getAll()
     */
    @Override
    @RequestMapping(value="/departments",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll() {
        // TODO Auto-generated method stub
        return super.getAllResult(departmentService);
    }
    /**
     * 查询全部部门名字
     * @Description
     * @return
     */
    @RequestMapping(value="/departmentnames",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAllName() {
        JSONObject jsonObject=new JSONObject();
        List<Department> selectAll = departmentService.selectDepartmentName();
        return getString(jsonObject, selectAll, !selectAll.isEmpty());
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#update()
     */
    @Override
    @RequestMapping(value="/departments",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8")
    public String update(Department t) {
        // TODO Auto-generated method stub
        return super.updateResult(departmentService,t);
       
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#delete()
     */
    @Override
    @RequestMapping(value="/departments/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8")
    public String delete(@PathVariable("id")Long id) {
        return super.deleteResult(departmentService,id);
    }
    @RequestMapping(value="/departmentrecursion",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String findAllRecursion() {
        JSONObject jsonObject=new JSONObject();
        List<Department> selectAll = departmentService.findAllRecursion();
        return getString(jsonObject, selectAll, !selectAll.isEmpty());
    }
    @RequestMapping(value="/findroot",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String findRoot() {
        JSONObject jsonObject=new JSONObject();
        List<Department> selectAll = departmentService.findRoot();
        return getString(jsonObject, selectAll, !selectAll.isEmpty());
    }

    @RequestMapping(value="/findchild/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String findchild(@PathVariable("id")Long id) {
        JSONObject jsonObject=new JSONObject();
        List<Department> selectAll = departmentService.findChild(id);
        return getString(jsonObject, selectAll, !selectAll.isEmpty());
    }

    /**
     * 文字处理
     * @param jsonObject
     * @param selectAll
     * @param b
     * @return
     */
    private String getString(JSONObject jsonObject, List<Department> selectAll, boolean b) {
        if (b) {
            return JSONObject.toJSONString(Result.success(selectAll),successFilter,SerializerFeature.WriteMapNullValue);
        } else {
            return JSONObject.toJSONString(Result.error(CodeMsg.NOT_FIND_DATA),errorFilter,SerializerFeature.WriteMapNullValue);
        }
    }
}
