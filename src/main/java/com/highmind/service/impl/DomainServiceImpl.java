/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.service.impl
 *
 *    Filename:    DomainServiceImpl.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    @author:     61430
 *
 *    @version:    1.0.0
 *
 *    Create at:   2019年4月17日 下午4:56:12
 *
 *    Revision:
 *
 *    2019年4月17日 下午4:56:12
 *        - first revision
 *
 *****************************************************************/
package com.highmind.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.DomainMapper;
import com.highmind.entity.Domain;
import com.highmind.service.DomainService;


/**
 * @ClassName DomainServiceImpl
 * @Description TODO
 * @author 61430
 * @Date 2019年4月17日 下午4:56:12
 * @version 1.0.0
 */
@Service
public class DomainServiceImpl implements DomainService {
    @Autowired
    DomainMapper domainMapper;
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#selectById(java.util.Map)
     */
    @Override
    public Domain selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        List<Domain> selectDomain = domainMapper.selectDomain(map);
        return !selectDomain.isEmpty()?selectDomain.get(0):null;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#selectAll()
     */
    @Override
    public List<Domain> selectAll(Map<String,Object> map) {
        // TODO Auto-generated method stub
        return domainMapper.selectDomain(map);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#add(java.lang.Object)
     */
    @Override
    public Long add(Domain record) {
        // TODO Auto-generated method stub
        return (long) domainMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#update(java.lang.Object)
     */
    @Override
    public int update(Domain record) {
        // TODO Auto-generated method stub
        return domainMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
        // TODO Auto-generated method stub
        return domainMapper.deleteByPrimaryKey(id);
    }

}
