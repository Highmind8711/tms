/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.service.impl
 *
 *    Filename:    TicketServiceImpl.java
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
 *    Create at:   2019年4月15日 上午6:33:41
 *
 *    Revision:
 *
 *    2019年4月15日 上午6:33:41
 *        - first revision
 *
 *****************************************************************/
package com.highmind.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.TicketMapper;
import com.highmind.entity.Ticket;
import com.highmind.service.TicketService;

/**
 * @ClassName TicketServiceImpl
 * @Description TODO
 * @author 61430
 * @Date 2019年4月15日 上午6:33:41
 * @version 1.0.0
 */
@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    TicketMapper ticketMapper;

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#selectById(java.util.Map)
     */
    @Override
    public Ticket selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        List<Ticket> selectTicket = ticketMapper.selectTicket(map);
        return selectTicket.size()!=0?selectTicket.get(0):null;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#selectAll()
     */
    @Override
    public List<Ticket> selectAll() {
        // TODO Auto-generated method stub
        Map<String, Object> hashMap = new HashMap<String,Object>();
        return ticketMapper.selectTicket(hashMap);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#add(java.lang.Object)
     */
    @Override
    public int add(Ticket record) {
        // TODO Auto-generated method stub
        return ticketMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#update(java.lang.Object)
     */
    @Override
    public int update(Ticket record) {
        // TODO Auto-generated method stub
        return ticketMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
        // TODO Auto-generated method stub
        return ticketMapper.deleteByPrimaryKey(id);
    }

}
