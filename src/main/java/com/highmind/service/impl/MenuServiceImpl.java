package com.highmind.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.MenuMapper;
import com.highmind.dao.PermissionMenuMapper;
import com.highmind.entity.Menu;
import com.highmind.entity.PermissionMenu;
import com.highmind.service.MenuService;

/**
 * @ClassName MenuServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 下午1:03:15
 * @version 1.0.0
 */
@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    PermissionMenuMapper permissionMenuMapper;
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectById(java.util.Map)
     */
    @Override
    public Menu selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return  menuMapper.selectMenu(map).get(0);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectAll()
     */
    @Override
    public List<Menu> selectAll() {
        // TODO Auto-generated method stub
        Map<String, Object> map = new HashMap<String,Object>();
        return  menuMapper.selectMenu(map);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#add(java.lang.Object)
     */
    @Override
    public int add(Menu record) {
        // TODO Auto-generated method stub
        return menuMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#update(java.lang.Object)
     */
    @Override
    public int update(Menu record) {
        // TODO Auto-generated method stub
        return menuMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
        // TODO Auto-generated method stub
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("Mid",id);
        List<PermissionMenu> selectPermissionMenu = permissionMenuMapper.selectPermissionMenu(map);
        if(!selectPermissionMenu.isEmpty()) {
           return 0; 
        }
        return menuMapper.deleteByPrimaryKey(id);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.MenuService#findAllRecursion()
     */
    @Override
    public List<Menu> findAllRecursion(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return menuMapper.findAllRecursion(map);
    }

}
