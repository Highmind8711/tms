package com.highmind.service;

import java.util.List;
import java.util.Map;

import com.highmind.entity.Menu;

/**
 * @ClassName MenuService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 上午11:29:53
 * @version 1.0.0
 */
public interface MenuService extends BaseService<Menu>{
    /**
     * 递归查询所有子菜单 
     * @Description
     * @param map 参数为雇员id Eid
     * @return
     */
   List<Menu> findAllRecursion(Map<String, Object> map);

}
