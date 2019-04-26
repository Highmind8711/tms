package com.highmind.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.highmind.entity.Menu;
import com.highmind.tool.CodeMsg;
import com.highmind.tool.JwtUtil;
import com.highmind.tool.Result;

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
    public String getOne(@PathVariable("id")Long id,HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getOneResult(menuService,id,domainid);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getAll()
     */
    @Override
    @RequestMapping(value="/menus",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll(HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getAllResult(menuService,domainid);
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
    
    /**
     *  测试分页
     * @Description
     * @param request
     * @return
     */
    /*
     * @RequestMapping(value="/menusbypage",method=RequestMethod.GET,produces = "text/json;charset=UTF-8") public String
     * getAllByPage(HttpServletRequest request){ // TODO Auto-generated method stub int
     * draw=Integer.parseInt(request.getParameter("draw")); int start=Integer.parseInt(request.getParameter("start"));
     * int length=Integer.parseInt(request.getParameter("length")); int page=start/length+1; JSONObject jsonObject=new
     * JSONObject(); PageHelper.startPage(page,length); List<Menu> selectAll = menuService.selectAll(); int total =
     * (int) new PageInfo<>(selectAll).getTotal(); jsonObject.put("draw", draw); jsonObject.put("recordsTotal", total);
     * jsonObject.put("recordsFiltered", total); jsonObject.put("data", selectAll); return
     * JSONObject.toJSONString(jsonObject); }
     */
    
    @RequestMapping(value="/menurecursion",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String findAllRecursion(String token,HttpSession session) {
        try {
            System.out.println(session.getAttribute("token"));
            if(session.getAttribute("token").toString().equals(token)) {
                if(JwtUtil.verify(token)) {
                    Long userId=JwtUtil.getUserId(token);
                    Map<String,Object> map=new HashMap<String,Object>();
                    map.put("Eid", userId);
                    List<Menu> selectAll =menuService.findAllRecursion(map);
                    return getString(selectAll, !selectAll.isEmpty());
                }else {
                    return JSONObject.toJSONString(Result.error(CodeMsg.SESSION_NOT_EXSIST),errorFilter,SerializerFeature.WriteMapNullValue);
                }
            }else {
                return JSONObject.toJSONString(Result.error(CodeMsg.ILLEGAL_REQUEST),errorFilter,SerializerFeature.WriteMapNullValue);
            }
        }catch (Exception e){
            return JSONObject.toJSONString(Result.error(CodeMsg.ILLEGAL_REQUEST),errorFilter,SerializerFeature.WriteMapNullValue);
        }
       
        
        
    }
}
