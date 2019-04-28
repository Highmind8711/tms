/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.service.impl
 *
 *    Filename:    LoginlogServiceImpl.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    @author:     61430
 *
 *    @version:    1.0.0
 *
 *    Create at:   2019年4月17日 下午4:56:55
 *
 *    Revision:
 *
 *    2019年4月17日 下午4:56:55
 *        - first revision
 *
 *****************************************************************/
package com.highmind.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.LoginlogMapper;
import com.highmind.entity.Loginlog;
import com.highmind.service.LoginlogService;

/**
 * @ClassName LoginlogServiceImpl
 * @Description TODO
 * @author 61430
 * @Date 2019年4月17日 下午4:56:55
 * @version 1.0.0
 */
@Service
public class LoginlogServiceImpl implements LoginlogService{
    @Autowired
    LoginlogMapper loginlogMapper;
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#selectById(java.util.Map)
     */
    @Override
    public Loginlog selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        List<Loginlog> selectLoginlog = loginlogMapper.selectLoginlog(map);
        return !selectLoginlog.isEmpty()?selectLoginlog.get(0):null;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#selectAll()
     */
    @Override
    public List<Loginlog> selectAll(Map<String,Object> map) {
        // TODO Auto-generated method stub
        return loginlogMapper.selectLoginlog(map);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#add(java.lang.Object)
     */
    @Override
    public Long add(Loginlog record) {
        // TODO Auto-generated method stub
        return (long) loginlogMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#update(java.lang.Object)
     */
    @Override
    public int update(Loginlog record) {
        // TODO Auto-generated method stub
        return loginlogMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.BaseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
        // TODO Auto-generated method stub
        return loginlogMapper.deleteByPrimaryKey(id);
    }

}
