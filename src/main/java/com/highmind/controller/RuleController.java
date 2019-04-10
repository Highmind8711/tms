/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    RuleController.java
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
 *    Create at:   2019年4月3日 下午12:57:03
 *
 *    Revision:
 *
 *    2019年4月3日 下午12:57:03
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.highmind.entity.Department;
import com.highmind.entity.Rule;

/**
 * @ClassName RuleController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 下午12:57:03
 * @version 1.0.0
 */
@RestController
public class RuleController extends BaseController<Rule> {
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#add()
     */
    @Override
    @RequestMapping(value="/rules",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String add(Rule t) {
        return super.addResult(ruleService,t);
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getOne()
     */
    @Override
    @RequestMapping(value="/rules/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getOne(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        return super.getOneResult(ruleService,id);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getAll()
     */
    @Override
    @RequestMapping(value="/rules",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll() {
        // TODO Auto-generated method stub
        return super.getAllResult(ruleService);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#update()
     */
    @Override
    @RequestMapping(value="/rules",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8")
    public String update(Rule t) {
        // TODO Auto-generated method stub
        return super.updateResult(ruleService,t);
       
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#delete()
     */
    @Override
    @RequestMapping(value="/rules/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8")
    public String delete(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        return super.deleteResult(ruleService,id);
    }
    @RequestMapping(value="/rulesnames",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
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
        return JSON.toJSONString(jsonObject,SerializerFeature.WriteMapNullValue);
    }
}
