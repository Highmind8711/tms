package com.highmind.dao;

import java.util.List;
import java.util.Map;

import com.highmind.entity.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> selectMenu(Map<String,Object> map);
    
    /**
     *遍历所有的菜单
     * @Description
     * @return
     */
    List<Menu> findAllRecursion(Map<String,Object> map);
}