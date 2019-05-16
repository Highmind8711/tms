package com.highmind.service;



import java.util.List;
import java.util.Map;
import java.util.Set;

import com.highmind.entity.Permission;

/**
 * @ClassName PermissionService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 上午11:32:32
 * @version 1.0.0
 */
public interface PermissionService extends BaseService<Permission>{
    /**
     * 查询权限根据用户id
     * @Description
     * @param map 传入的参数Eid
     * @return
     */
    Set<String> selectPermissionByEid(Map<String, Object> map);
    /**
     * 查询组根据用户id
     * @Description
     * @param map
     * @return
     */
    List<String> selectGroupByEid(Map<String,Object> map);
}
