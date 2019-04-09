/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    EmployeeController.java
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
 *    Create at:   2019年4月3日 上午11:40:04
 *
 *    Revision:
 *
 *    2019年4月3日 上午11:40:04
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.highmind.entity.Employee;

/**
 * @ClassName EmployeeController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 上午11:40:04
 * @version 1.0.0
 */
@Controller
public class EmployeeController extends BaseController<Employee>{
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#add()
     */
    @Override
    @RequestMapping(value="/employees",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String add(Employee t) {
        return super.addResult(employeeService,t);
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getOne()
     */
    @Override
    @RequestMapping(value="/employees/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getOne(Long id) {
        // TODO Auto-generated method stub
        return super.getOneResult(employeeService,id);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getAll()
     */
    @Override
    @RequestMapping(value="/employees",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll() {
        // TODO Auto-generated method stub
        return super.getAllResult(employeeService);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#update()
     */
    @Override
    @RequestMapping(value="/employees/{id}",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8")
    public String update(Employee t) {
        // TODO Auto-generated method stub
        return super.updateResult(employeeService,t);
       
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#delete()
     */
    @Override
    @RequestMapping(value="/employees/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8")
    public String delete(Long id) {
        // TODO Auto-generated method stub
        return super.deleteResult(employeeService,id);
    }
}
