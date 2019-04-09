/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.service.impl
 *
 *    Filename:    PermissionOperationServiceImpl.java
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
 *    Create at:   2019年4月3日 下午1:05:10
 *
 *    Revision:
 *
 *    2019年4月3日 下午1:05:10
 *        - first revision
 *
 *****************************************************************/
package com.highmind.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.PermissionOperationMapper;
import com.highmind.entity.PermissionOperation;
import com.highmind.service.PermissionOperationService;

/**
 * @ClassName PermissionOperationServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 下午1:05:10
 * @version 1.0.0
 */
@Service
public class PermissionOperationServiceImpl implements PermissionOperationService{
    @Autowired
    PermissionOperationMapper permissionOperationMapper;
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectById(java.util.Map)
     */
    @Override
    public PermissionOperation selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return permissionOperationMapper.selectPermissionOperation(map).get(0);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectAll()
     */
    @Override
    public List<PermissionOperation> selectAll() {
        // TODO Auto-generated method stub
        Map<String, Object> map = new HashMap<String,Object>();
        return permissionOperationMapper.selectPermissionOperation(map);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#add(java.lang.Object)
     */
    @Override
    public int add(PermissionOperation record) {
        // TODO Auto-generated method stub
        return permissionOperationMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#update(java.lang.Object)
     */
    @Override
    public int update(PermissionOperation record) {
        // TODO Auto-generated method stub
        return permissionOperationMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
        // TODO Auto-generated method stub
        return permissionOperationMapper.deleteByPrimaryKey(id);
    }

}
