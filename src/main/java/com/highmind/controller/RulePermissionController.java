/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    RulePermissionController.java
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
 *    Create at:   2019年4月6日 上午9:44:52
 *
 *    Revision:
 *
 *    2019年4月6日 上午9:44:52
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.highmind.entity.RulePermission;

/**
 * @ClassName RulePermissionController
 * @Description TODO
 * @author 61430
 * @Date 2019年4月6日 上午9:44:52
 * @version 1.0.0
 */
public class RulePermissionController extends BaseController<RulePermission>{

    @Override
    @RequestMapping(value="/rulepermissions",method=RequestMethod.POST)
    public String add(RulePermission t) {
        // TODO Auto-generated method stub
        return super.add(t);
    }

    @Override
    @RequestMapping(value="/rulepermissions",method=RequestMethod.GET)
    public String getAll() {
        // TODO Auto-generated method stub
        return super.getAll();
    }

    @Override
    @RequestMapping(value="/rulepermissions/{id}",method=RequestMethod.GET)
    public String getOne(Long id) {
        // TODO Auto-generated method stub
        return super.getOne(id);
    }

    @Override
    @RequestMapping(value="/rulepermissions/{id}",method=RequestMethod.DELETE)
    public String update(RulePermission t) {
        // TODO Auto-generated method stub
        return super.update(t);
    }

    @Override
    @RequestMapping(value="/rulepermissions/{id}",method=RequestMethod.DELETE)
    public String delete(Long id) {
        // TODO Auto-generated method stub
        return super.delete(id);
    }

}
