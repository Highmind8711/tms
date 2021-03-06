package com.highmind.dao;

import java.util.List;
import java.util.Map;

import com.highmind.entity.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    List<Permission> selectPermission(Map<String,Object> map);
    /**
     * 查询权限根据用户id
     * @Description
     * @return
     */
    List<Permission> selectPermissionByEid(Map<String,Object> map);
}