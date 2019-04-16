/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    PermissionController.java
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
 *    Create at:   2019年4月3日 上午11:41:26
 *
 *    Revision:
 *
 *    2019年4月3日 上午11:41:26
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highmind.entity.Permission;

/**
 * @ClassName PermissionController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 上午11:41:26
 * @version 1.0.0
 */
@RestController
public class PermissionController extends BaseController<Permission> {

    /*
     * (非 Javadoc) Description:
     * @see com.highmind.controller.BaseController#add()
     */
    @Override
    @RequestMapping(value = "/permissions", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    public String add(Permission t) {
        return super.addResult(permissionService, t);
    }

    /*
     * (非 Javadoc) Description:
     * @see com.highmind.controller.BaseController#getOne()
     */
    @Override
    @RequestMapping(value = "/permissions/{id}", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    public String getOne(@PathVariable("id") Long id) {
        // TODO Auto-generated method stub
        return super.getOneResult(permissionService, id);
    }

    /*
     * (非 Javadoc) Description:
     * @see com.highmind.controller.BaseController#getAll()
     */
    @Override
    @RequestMapping(value = "/permissions", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    public String getAll() {
        // TODO Auto-generated method stub
        return super.getAllResult(permissionService);
       
    }
    /*
     * (非 Javadoc) Description:
     * @see com.highmind.controller.BaseController#update()
     */
    /*
     * @Override
     * @RequestMapping(value="/permissions",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8") public String
     * update(Permission t) { // TODO Auto-generated method stub return super.updateResult(permissionService,t); } (非
     * Javadoc) Description:
     * @see com.highmind.controller.BaseController#delete()
     * @Override
     * @RequestMapping(value="/permissions/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8")
     * public String delete(@PathVariable("id")Long id) { // TODO Auto-generated method stub return
     * super.deleteResult(permissionService,id); }
     */
}
