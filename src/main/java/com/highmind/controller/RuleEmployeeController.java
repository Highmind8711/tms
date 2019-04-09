/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    RuleEmployeeController.java
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
 *    Create at:   2019年4月6日 上午9:42:05
 *
 *    Revision:
 *
 *    2019年4月6日 上午9:42:05
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.highmind.entity.RuleEmployee;

/**
 * @ClassName RuleEmployeeController
 * @Description TODO
 * @author 61430
 * @Date 2019年4月6日 上午9:42:05
 * @version 1.0.0
 */
public class RuleEmployeeController extends BaseController<RuleEmployee>{

    @Override
    @RequestMapping(value="/ruleemployees",method=RequestMethod.POST)
    public String add(RuleEmployee t) {
        // TODO Auto-generated method stub
        return super.addResult(ruleEmployeeService, t);
    }

    @Override
    @RequestMapping(value="/ruleemployees",method=RequestMethod.GET)
    public String getAll() {
        // TODO Auto-generated method stub
        return super.getAllResult(ruleEmployeeService);
    }

    @Override
    @RequestMapping(value="/ruleemployees/{id}",method=RequestMethod.GET)
    public String getOne(Long id) {
        // TODO Auto-generated method stub
        return super.getOneResult(ruleEmployeeService, id);
    }

    @Override
    @RequestMapping(value="/ruleemployees/{id}",method=RequestMethod.DELETE)
    public String update(RuleEmployee t) {
        // TODO Auto-generated method stub
        return super.updateResult(ruleEmployeeService, t);
    }

    @Override
    @RequestMapping(value="/ruleemployees/{id}",method=RequestMethod.DELETE)
    public String delete(Long id) {
        // TODO Auto-generated method stub
        return super.deleteResult(ruleEmployeeService, id);
    }

}
