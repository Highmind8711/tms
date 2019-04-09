package com.highmind.dao;

import java.util.List;
import java.util.Map;

import com.highmind.entity.PermissionOperation;

public interface PermissionOperationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PermissionOperation record);

    int insertSelective(PermissionOperation record);

    PermissionOperation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PermissionOperation record);

    int updateByPrimaryKey(PermissionOperation record);
    
    List<PermissionOperation> selectPermissionOperation(Map<String,Object> map);
}