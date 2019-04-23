package com.highmind.service.impl;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highmind.dao.MenuMapper;
import com.highmind.dao.OperationMapper;
import com.highmind.dao.PermissionMapper;
import com.highmind.dao.PermissionMenuMapper;
import com.highmind.dao.PermissionOperationMapper;
import com.highmind.entity.Permission;
import com.highmind.entity.PermissionMenu;
import com.highmind.service.PermissionService;

/**
 * @ClassName PermissionService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 下午1:05:45
 * @version 1.0.0
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired 
    PermissionMapper permissionMapper;
    @Autowired
    OperationMapper operationMapper;
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    PermissionMenuMapper permissionMenuMapper;
    @Autowired
    PermissionOperationMapper permissionOperationMapper;
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectById(java.util.Map)
     */
    @Override
    public Permission selectById(Map<String, Object> map) {
        // TODO Auto-generated method stub
        List<Permission> permissions=permissionMapper.selectPermission(map);
        for (int i = 0; i < permissions.size(); i++) {
            Permission permission = permissions.get(i);
            /*
             * if(permission.getType().equals("1")) { Map<String,Object> tempMap=new HashMap<String,Object>();
             * tempMap.put("id", permission.getId()); List<PermissionOperation> permissionOperations =
             * permissionOperationMapper.selectPermissionOperation(tempMap); PermissionOperation
             * permissionOperation=permissionOperations.size()!=0?permissionOperations.get(0):null;
             * permission.setOperation(permissionOperation.getOperation()); }else
             */if(permission.getType().equals("2")) {
                Map<String,Object> tempMap=new HashMap<String,Object>();
                tempMap.put("id", permission.getId());
                List<PermissionMenu> selectPermissionMenu = permissionMenuMapper.selectPermissionMenu(tempMap);
                PermissionMenu permissionMenu=selectPermissionMenu.size()!=0?selectPermissionMenu.get(0):null;
                permission.setMenu(permissionMenu!=null?permissionMenu.getMenu():null);
            }
        }
        return !permissions.isEmpty()?permissions.get(0):null;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#selectAll()
     */
    @Override
    public List<Permission> selectAll() {
        // TODO Auto-generated method stub
        List<Permission> permissions=permissionMapper.selectPermission(null);
        for (int i = 0; i < permissions.size(); i++) {
            Permission permission = permissions.get(i);
            /*
             * if(permission.getType().equals("1")) { Map<String,Object> tempMap=new HashMap<String,Object>();
             * tempMap.put("id", permission.getId()); List<PermissionOperation> permissionOperations =
             * permissionOperationMapper.selectPermissionOperation(tempMap); PermissionOperation
             * permissionOperation=permissionOperations.size()!=0?permissionOperations.get(0):null;
             * permission.setOperation(permissionOperation.getOperation()); }else*/
            //if(permission.getType().equals("2")) {
             
                Map<String,Object> tempMap=new HashMap<String,Object>();
                tempMap.put("id", permission.getId());
                List<PermissionMenu> selectPermissionMenu = permissionMenuMapper.selectPermissionMenu(tempMap);
                PermissionMenu permissionMenu=!selectPermissionMenu.isEmpty()?selectPermissionMenu.get(0):null;
                permission.setMenu(permissionMenu!=null?permissionMenu.getMenu():null);
            //}
        }
        return permissions;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#add(java.lang.Object)
     */
    @Override
    public int add(Permission record) {
        // TODO Auto-generated method stub
        permissionMapper.insertSelective(record);
        Long pid=record.getId();
        int result = 0;
        /*
         * if(record.getType().equals("1")) { //标志这个是表单权限 Long oid=record.getOperation().getId(); PermissionOperation
         * permissionOperation=new PermissionOperation(); permissionOperation.setDomainid(record.getDomainid());
         * permissionOperation.setOperation_id(oid); permissionOperation.setPermission_id(pid);
         * result=permissionOperationMapper.insertSelective(permissionOperation); }else
         *///if(record.getType().equals("2")){
          //标志这个是菜单权限  
            Long mid=record.getMenu().getId();
            PermissionMenu permissionMenu=new PermissionMenu();
            permissionMenu.setDomainid(record.getDomainid());
            permissionMenu.setMenu_id(mid);
            permissionMenu.setPermission_id(pid);
            result=permissionMenuMapper.insertSelective(permissionMenu);
            
//        }
        return result;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#update(java.lang.Object)
     */
    @Override
    public int update(Permission record) {
        // TODO Auto-generated method stub
        PermissionMenu permissionMenu=permissionMenuMapper.selectByPid(record.getId());
        permissionMenu.setMenu_id(record.getMenu().getId());
        int result=permissionMenuMapper.updateByPrimaryKeySelective(permissionMenu);
        if(result==0) {
            return 0;
        }
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.baseService#del(java.lang.Long)
     */
    @Override
    public int del(Long id) {
        // TODO Auto-generated method stub
        return permissionMapper.deleteByPrimaryKey(id);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.service.PermissionService#selectPermissionByEid(java.util.Map)
     */
    @Override
    public Set<String> selectPermissionByEid(Map<String, Object> map) {
        // TODO Auto-generated method stub
        Set<String> strings=new HashSet<String>();
        List<Permission> permissions=permissionMapper.selectPermissionByEid(map);
        for(Permission permission:permissions) {
            strings.add(permission.getName());
        }
        return strings;
    }
    

   

}
