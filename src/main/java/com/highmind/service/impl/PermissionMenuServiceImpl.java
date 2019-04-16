/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.service.impl
 *
 *    Filename:    PermissionMenuService.java
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
 *    Create at:   2019年4月3日 下午1:04:19
 *
 *    Revision:
 *
 *    2019年4月3日 下午1:04:19
 *        - first revision
 *
 *****************************************************************/
package com.highmind.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.PermissionMapper;
import com.highmind.dao.PermissionMenuMapper;
import com.highmind.entity.PermissionMenu;
import com.highmind.service.PermissionMenuService;

/**
 * @ClassName PermissionMenuService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 下午1:04:19
 * @version 1.0.0
 */
@Service
public class PermissionMenuServiceImpl implements PermissionMenuService{
    @Autowired
    PermissionMenuMapper permissionMenuMapper;
    @Autowired 
    PermissionMapper permissionMapper;
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectById(java.util.Map)
     */
    @Override
    public PermissionMenu selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        List<PermissionMenu> selectPermissionMenu = permissionMenuMapper.selectPermissionMenu(map);
        return selectPermissionMenu.size()!=0?selectPermissionMenu.get(0):null;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectAll()
     */
    @Override
    public List<PermissionMenu> selectAll() {
        // TODO Auto-generated method stub
        Map<String, Object> map = new HashMap<String,Object>();
        return permissionMenuMapper.selectPermissionMenu(map);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#add(java.lang.Object)
     */
    @Override
    public int add(PermissionMenu record) {
        // TODO Auto-generated method stub
        return permissionMenuMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#update(java.lang.Object)
     */
    @Override
    public int update(PermissionMenu record) {
        // TODO Auto-generated method stub
        permissionMapper.updateByPrimaryKey(record.getPermission());
        return permissionMenuMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
        // TODO Auto-generated method stub
        PermissionMenu permissionMenu=permissionMenuMapper.selectByPrimaryKey(id);
        permissionMapper.deleteByPrimaryKey(permissionMenu.getPermission_id());
        return permissionMenuMapper.deleteByPrimaryKey(id);
    }

}
