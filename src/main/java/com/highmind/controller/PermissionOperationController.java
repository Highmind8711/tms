/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    PermissionOperationController.java
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
 *    Create at:   2019年4月6日 上午9:03:14
 *
 *    Revision:
 *
 *    2019年4月6日 上午9:03:14
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.highmind.entity.PermissionOperation;

/**
 * @ClassName PermissionOperationController
 * @Description TODO
 * @author 61430
 * @Date 2019年4月6日 上午9:03:14
 * @version 1.0.0
 */
public class PermissionOperationController  extends BaseController<PermissionOperation>{

    @Override
    @RequestMapping(value="/permissionoperations",method=RequestMethod.POST)
    public String add(PermissionOperation t) {
        // TODO Auto-generated method stub
        return super.addResult(permissionOperationService, t);
    }

    @Override
    @RequestMapping(value="/permissionoperations",method=RequestMethod.GET)
    public String getAll() {
        // TODO Auto-generated method stub
        return super.getAllResult(permissionOperationService);
    }

    @Override
    @RequestMapping(value="/permissionoperations/{id}",method=RequestMethod.GET)
    public String getOne(Long id) {
        // TODO Auto-generated method stub
        return super.getOneResult(permissionOperationService, id);
    }

    @Override
    @RequestMapping(value="/permissionoperations/{id}",method=RequestMethod.DELETE)
    public String update(PermissionOperation t) {
        // TODO Auto-generated method stub
        return super.updateResult(permissionOperationService, t);
    }

    @Override
    @RequestMapping(value="/permissionoperations/{id}",method=RequestMethod.DELETE)
    public String delete(Long id) {
        // TODO Auto-generated method stub
        return super.deleteResult(permissionOperationService, id);
    }
    
}
