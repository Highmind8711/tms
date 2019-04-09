package com.highmind.dao;

import java.util.List;
import java.util.Map;

import com.highmind.entity.PermissionMenu;

public interface PermissionMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PermissionMenu record);

    int insertSelective(PermissionMenu record);

    PermissionMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PermissionMenu record);

    int updateByPrimaryKey(PermissionMenu record);

    List<PermissionMenu> selectPermissionMenu(Map<String,Object> map);
}