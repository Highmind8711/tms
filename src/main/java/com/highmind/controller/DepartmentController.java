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

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
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
        // TODO Auto-generated method stub
        JSONObject jsonObject=new JSONObject();
        List<Department> selectAll = departmentService.selectDepartmentName();
        if(selectAll.size()>=0) {
            jsonObject.put("status", 1);
            jsonObject.put("data",selectAll);
        }else {
            jsonObject.put("status", 0);
            jsonObject.put("error", "数据获取失败");
        }
        return jsonObject.toJSONString();
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#update()
     */
    @Override
    @RequestMapping(value="/departments",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8")
    public String update(Department t) {
        // TODO Auto-generated method stub
        System.out.println(t.getName());
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
}
