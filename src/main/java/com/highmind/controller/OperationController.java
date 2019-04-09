/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    OperationController.java
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
 *    Create at:   2019年4月3日 上午11:41:05
 *
 *    Revision:
 *
 *    2019年4月3日 上午11:41:05
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.highmind.entity.Operation;

/**
 * @ClassName OperationController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 上午11:41:05
 * @version 1.0.0
 */
@Controller
public class OperationController extends BaseController<Operation>{
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#add()
     */
    @Override
    @RequestMapping(value="/operations",method=RequestMethod.POST)
    public String add(Operation t) {
        return super.addResult(operationService,t);
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getOne()
     */
    @Override
    @RequestMapping(value="/operations/{id}",method=RequestMethod.GET)
    public String getOne(Long id) {
        // TODO Auto-generated method stub
        return super.getOneResult(operationService,id);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getAll()
     */
    @Override
    @RequestMapping(value="/operations",method=RequestMethod.GET)
    public String getAll() {
        // TODO Auto-generated method stub
        return super.getAllResult(operationService);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#update()
     */
    @Override
    @RequestMapping(value="/operations/{id}",method=RequestMethod.PUT)
    public String update(Operation t) {
        // TODO Auto-generated method stub
        return super.updateResult(operationService,t);
       
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#delete()
     */
    @Override
    @RequestMapping(value="/operations/{id}",method=RequestMethod.DELETE)
    public String delete(Long id) {
        // TODO Auto-generated method stub
        return super.deleteResult(operationService,id);
    }
}
