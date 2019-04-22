/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    DomainController.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    @author:     61430
 *
 *    @version:    1.0.0
 *
 *    Create at:   2019年4月17日 下午5:21:49
 *
 *    Revision:
 *
 *    2019年4月17日 下午5:21:49
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highmind.entity.Domain;

/**
 * @ClassName DomainController
 * @Description TODO
 * @author 61430
 * @Date 2019年4月17日 下午5:21:49
 * @version 1.0.0
 */
@RestController
public class DomainController extends BaseController<Domain>{

    @Override
    @RequestMapping(value="/domain",method=RequestMethod.POST,produces = "text/json;charset=UTF-8") 
    public String add(Domain t) { // TODO Auto-generated method stub 
        return super.addResult(domainService, t); 
    }
     

    @Override
    @RequestMapping(value="/domain",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll(HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getAllResult(domainService,domainid);
    }


     @Override
     @RequestMapping(value="/domain/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8") 
     public String getOne(@PathVariable("id")Long id,HttpServletRequest request) {
         // TODO Auto-generated method stub 
         String domainid=request.getHeader("domainid"); 
         return super.getOneResult(domainService, id,domainid); 
    }
    @Override
    @RequestMapping(value="/domain",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8") 
    public String update(Domain t) { 
        // TODO Auto-generated method stub 
        return super.updateResult(domainService, t); 
        
    }
    @Override
    @RequestMapping(value="/domain/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8") 
    public String delete(Long id) { 
        // TODO Auto-generated method stub 
        return super.deleteResult(domainService, id); 
        
    }
     
    
}
