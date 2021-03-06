package com.highmind.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highmind.entity.PermissionOperation;

/**
 * @ClassName PermissionOperationController
 * @Description TODO
 * @author 61430
 * @Date 2019年4月6日 上午9:03:14
 * @version 1.0.0
 */
@RestController
public class PermissionOperationController  extends BaseController<PermissionOperation>{

    /*
     * @Override
     * @RequestMapping(value="/permissionoperations",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
     * public String add(PermissionOperation t) { // TODO Auto-generated method stub return
     * super.addResult(permissionOperationService, t); }
     */

    @Override
    @RequestMapping(value="/permissionoperations",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8")
    public String update(PermissionOperation t) {
        // TODO Auto-generated method stub
        return super.updateResult(permissionOperationService, t);
    }
    @Override
    @RequestMapping(value="/permissionoperations",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll(HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getAllResult(permissionOperationService,domainid);
    }


    @Override
    @RequestMapping(value="/permissionoperations/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getOne(@PathVariable("id")Long id,HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getOneResult(permissionOperationService, id,domainid);
    }
    @Override
    @RequestMapping(value="/permissionoperations/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8")
    public String delete(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        return super.deleteResult(permissionOperationService, id);
    }
    
}
