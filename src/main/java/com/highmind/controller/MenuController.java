/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    MenuController.java
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
 *    Create at:   2019年4月3日 上午11:40:24
 *
 *    Revision:
 *
 *    2019年4月3日 上午11:40:24
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.highmind.entity.Menu;

/**
 * @ClassName MenuController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 上午11:40:24
 * @version 1.0.0
 */
@RestController
public class MenuController extends BaseController<Menu>{
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#add()
     */
    @Override
    @RequestMapping(value="/menus",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String add(Menu t) {
        return super.addResult(menuService,t);
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getOne()
     */
    @Override
    @RequestMapping(value="/menus/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getOne(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        return super.getOneResult(menuService,id);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getAll()
     */
    @Override
    @RequestMapping(value="/menus",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll() {
        // TODO Auto-generated method stub
        return super.getAllResult(menuService);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#update()
     */
    @Override
    @RequestMapping(value="/menus",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8")
    public String update(Menu t) {
        // TODO Auto-generated method stub
        return super.updateResult(menuService,t);
       
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#delete()
     */
    @Override
    @RequestMapping(value="/menus/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8")
    public String delete(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        return super.deleteResult(menuService,id);
    }
    
    
    @RequestMapping(value="/menusbypage",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAllByPage(HttpServletRequest request){
        // TODO Auto-generated method stub
        int draw=Integer.parseInt(request.getParameter("draw"));
        int start=Integer.parseInt(request.getParameter("start"));
        int length=Integer.parseInt(request.getParameter("length"));
        int page=start/length+1;
        JSONObject jsonObject=new JSONObject();
        PageHelper.startPage(page,length);
        List<Menu> selectAll = menuService.selectAll();
        int total = (int) new PageInfo<>(selectAll).getTotal();
        jsonObject.put("draw", draw);
        jsonObject.put("recordsTotal", total);
        jsonObject.put("recordsFiltered", total);
        jsonObject.put("data", selectAll);
        return JSONObject.toJSONString(jsonObject);
    }
}
