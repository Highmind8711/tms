package com.highmind.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.PermissionMapper;
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
    @Autowired 
    PermissionMapper permissionMapper;
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectById(java.util.Map)
     */
    @Override
    public PermissionOperation selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        List<PermissionOperation> selectPermissionOperation = permissionOperationMapper.selectPermissionOperation(map);
        return selectPermissionOperation.size()!=0?selectPermissionOperation.get(0):null;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectAll()
     */
    @Override
    public List<PermissionOperation> selectAll(Map<String,Object> map) {
        // TODO Auto-generated method stub
        return permissionOperationMapper.selectPermissionOperation(map);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#add(java.lang.Object)
     */
    @Override
    public Long add(PermissionOperation record) {
        // TODO Auto-generated method stub
        return (long) permissionOperationMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#update(java.lang.Object)
     */
    @Override
    public int update(PermissionOperation record) {
        // TODO Auto-generated method stub
        int temp=permissionMapper.updateByPrimaryKey(record.getPermission());
        if(temp==1) {
            return permissionOperationMapper.updateByPrimaryKeySelective(record);
        }else{
            return 0;
        }
        
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
     // TODO Auto-generated method stub
        PermissionOperation permissionOperation = permissionOperationMapper.selectByPrimaryKey(id);
        
        int temp=permissionMapper.deleteByPrimaryKey(permissionOperation.getPermission_id());
        if(temp==1) {
            return permissionOperationMapper.deleteByPrimaryKey(id);
        }else {
            return 0;
        }
        
    }

}
