/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    LoginlogController.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    @author:     61430
 *
 *    @version:    1.0.0
 *
 *    Create at:   2019年4月17日 下午5:04:31
 *
 *    Revision:
 *
 *    2019年4月17日 下午5:04:31
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highmind.entity.Loginlog;

/**
 * @ClassName LoginlogController
 * @Description TODO
 * @author 61430
 * @Date 2019年4月17日 下午5:04:31
 * @version 1.0.0
 */
@RestController
public class LoginlogController extends BaseController<Loginlog>{

    /*
     * @Override
     * @RequestMapping(value="/loginlog",method=RequestMethod.POST,produces = "text/json;charset=UTF-8") public String
     * add(Loginlog t) { // TODO Auto-generated method stub return super.addResult(loginlogService, t); }
     */
    @Override
    @RequestMapping(value="/loginlog",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll(HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getAllResult(loginlogService,domainid);
    }

    @Override
    @RequestMapping(value="/loginlog/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getOne(Long id,HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getOneResult(loginlogService, id,domainid);
    }

    /*
     * @Override
     * @RequestMapping(value="/loginlog",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8") public String
     * update(Loginlog t) { // TODO Auto-generated method stub return super.updateResult(loginlogService, t); }
     */

    /*
     * @Override
     * @RequestMapping(value="/loginlog/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8") public
     * String delete(Long id) { // TODO Auto-generated method stub return super.deleteResult(loginlogService, id); }
     */
    
}
