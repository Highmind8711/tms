/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.service
 *
 *    Filename:    baseService.java
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
 *    Create at:   2019年4月4日 上午8:51:20
 *
 *    Revision:
 *
 *    2019年4月4日 上午8:51:20
 *        - first revision
 *
 *****************************************************************/
package com.highmind.service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName baseService
 * @Description TODO
 * @author 61430
 * @Date 2019年4月4日 上午8:51:20
 * @version 1.0.0
 */
public interface BaseService<T>  {
    /**
    *
    * @Description 根据id查询
    * @param map 传递的参数为id
    * @returnT
    */
   T selectById(Map<String,Object> map);
  /**
   * 
   * @Description 查询全部
   * @return
   */
   List<T> selectAll();
   /**
    * 
    * @Description  添加
    * @return
    */
   int add(T record);
   /**
    * 
    * @Description 更新
    * @return
    */
   int update(T record);
   /**
        *删除
    * @Description
    * @return
    */
   int del(Long id);
}
