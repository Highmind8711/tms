/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    PermissionMenuController.java
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
 *    Create at:   2019年4月6日 上午8:53:25
 *
 *    Revision:
 *
 *    2019年4月6日 上午8:53:25
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highmind.entity.PermissionMenu;

/**
 * @ClassName PermissionMenuController
 * @Description TODO
 * @author 61430
 * @Date 2019年4月6日 上午8:53:25
 * @version 1.0.0
 */
@RestController
public class PermissionMenuController extends BaseController<PermissionMenu>{

    /*
     * @Override
     * @RequestMapping(value="/permissionmenus",method=RequestMethod.POST,produces = "text/json;charset=UTF-8") public
     * String add(PermissionMenu t) { // TODO Auto-generated method stub return super.addResult(permissionMenuService,
     * t); }
     */
    

    @Override
    @RequestMapping(value="/permissionmenus",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll() {
        // TODO Auto-generated method stub
        return super.getAllResult(permissionMenuService);
    }


    @Override
    @RequestMapping(value="/permissionmenus/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getOne(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        return super.getOneResult(permissionMenuService, id);
    }


    @Override
    @RequestMapping(value="/permissionmenus",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8")
    public String update(PermissionMenu t) {
        // TODO Auto-generated method stub
        return super.updateResult(permissionMenuService, t);
    }

    @Override
    @RequestMapping(value="/permissionmenus/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8")
    public String delete(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        return super.deleteResult(permissionMenuService, id);
    }
    
}
