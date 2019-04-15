/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    TicketController.java
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
 *    Create at:   2019年4月15日 上午6:40:27
 *
 *    Revision:
 *
 *    2019年4月15日 上午6:40:27
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highmind.entity.Ticket;

/**
 * @ClassName TicketController
 * @Description TODO
 * @author 61430
 * @Date 2019年4月15日 上午6:40:27
 * @version 1.0.0
 */
@RestController
public class TicketController extends BaseController<Ticket>{

    @Override
    @RequestMapping(value="/tickets",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String add(Ticket t) {
        // TODO Auto-generated method stub
        return super.addResult(ticketService, t);
    }

    @Override
    @RequestMapping(value="/tickets",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll() {
        // TODO Auto-generated method stub
        return super.getAllResult(ticketService);
    }

    @Override
    @RequestMapping(value="/tickets/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getOne(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        return super.getOneResult(ticketService, id);
    }

    @Override
    @RequestMapping(value="/tickets",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8")
    public String update(Ticket t) {
        // TODO Auto-generated method stub
        return super.updateResult(ticketService, t);
    }

    @Override
    @RequestMapping(value="/tickets/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8")
    public String delete(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        return super.deleteResult(ticketService, id);
    }

}
