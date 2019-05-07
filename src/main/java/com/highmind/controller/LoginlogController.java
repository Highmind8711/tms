/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    LoginlogController.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    @author:     61430
 *
 *    @version:    1.0.0
 *
 *    Create at:   2019年4月17日 下午5:04:31
 *
 *    Revision:
 *
 *    2019年4月17日 下午5:04:31
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.highmind.entity.Loginlog;
import com.highmind.tool.CodeMsg;
import com.highmind.tool.Handle;
import com.highmind.tool.Result;

/**
 * @ClassName LoginlogController
 * @Description TODO
 * @author 61430
 * @Date 2019年4月17日 下午5:04:31
 * @version 1.0.0
 */
@RestController
public class LoginlogController extends BaseController<Loginlog>{

    /*
     * @Override
     * @RequestMapping(value="/loginlog",method=RequestMethod.POST,produces = "text/json;charset=UTF-8") public String
     * add(Loginlog t) { // TODO Auto-generated method stub return super.addResult(loginlogService, t); }
     */
    @Override
    @RequestMapping(value="/loginlog",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll(HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getAllResult(loginlogService,domainid);
    }

    @Override
    @RequestMapping(value="/loginlog/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getOne(Long id,HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getOneResult(loginlogService, id,domainid);
    }

    /*
     * @Override
     * @RequestMapping(value="/loginlog",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8") public String
     * update(Loginlog t) { // TODO Auto-generated method stub return super.updateResult(loginlogService, t); }
     */

    /*
     * @Override
     * @RequestMapping(value="/loginlog/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8") public
     * String delete(Long id) { // TODO Auto-generated method stub return super.deleteResult(loginlogService, id); }
     */
    @RequestMapping(value="/loginlogbypage",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String getAllByPage(HttpServletRequest request, @RequestBody Map<String, Object> pram) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        Integer pageNum=(Integer) pram.get("pageNum");
        Integer pageSize=(Integer) pram.get("pageSize");
        List<Handle> handles=null;
        if(pram.get("handles")!=null) {
            String jsonString = JSONArray.toJSONString(pram.get("handles")); 
            System.out.println(jsonString);
            handles=JSONArray.parseArray(jsonString, Handle.class);
        }       
        List<String> sqlLits=new ArrayList<String>();
        StringBuffer strBuffer = new StringBuffer();
        String betweenLeft="";
        String betweenRight="";
        if(handles!=null) {
            for(Handle handle:handles) {
                System.out.println(handle.toString());
                if(handle.getOperation().equals("=")) {
                    strBuffer.append("and"+handle.getName());
                    strBuffer.append(handle.getOperation());
                    strBuffer.append(handle.getData()); 
                    sqlLits.add(strBuffer.toString());
                }else if(handle.getOperation().equals("like")){
                    strBuffer.append("and"+handle.getName());
                    strBuffer.append(handle.getOperation());
                    strBuffer.append("%"+handle.getData()+"%"); 
                    sqlLits.add(strBuffer.toString());
                }else if(handle.getOperation().equals("between")){
                    betweenLeft="and"+handle.getName()+handle.getOperation()+handle.getData();    
                }else if(handle.getOperation().equals("end")) {
                    betweenRight=handle.getOperation()+handle.getData();
                }else {
                    return JSONObject.toJSONString(Result.error(CodeMsg.ILLEGAL_REQUEST),errorFilter);
                }
                if(!betweenLeft.equals("")||!betweenRight.equals("")) {
                    strBuffer.append(betweenLeft);
                    strBuffer.append(betweenRight);
                    sqlLits.add(strBuffer.toString());
                }
            }
        }
        Map<String,Object> map=new HashMap<String,Object>(16);
        map.put("domainid", domainid);
        map.put("handles", handles);
        JSONObject jsonObject=new JSONObject();
        PageHelper.startPage(pageNum, pageSize);
        List<Loginlog> selectAll = loginlogService.selectAll(map);
        int total =(int) new PageInfo<>(selectAll).getTotal();
        jsonObject.put("total", total); 
        jsonObject.put("currentPage", pageNum);
        jsonObject.put("status", 1); 
        jsonObject.put("data", selectAll); 
        return JSONObject.toJSONString(jsonObject,SerializerFeature.WriteMapNullValue,SerializerFeature.DisableCircularReferenceDetect);
    }
    
}
