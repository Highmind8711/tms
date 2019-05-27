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
import com.highmind.entity.Permission;
import com.highmind.tool.CodeMsg;
import com.highmind.tool.JwtUtil;
import com.highmind.tool.Result;

/**
 * @ClassName PermissionController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 上午11:41:26
 * @version 1.0.0
 */
@RestController
public class PermissionController extends BaseController<Permission> {

    /*
     * (非 Javadoc) Description:
     * @see com.highmind.controller.BaseController#add()
     */
    @Override
    @RequestMapping(value = "/permissions", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    public String add(Permission t) {
        return super.addResult(permissionService, t);
    }

    /*
     * (非 Javadoc) Description:
     * @see com.highmind.controller.BaseController#getOne()
     */
    @Override
    @RequestMapping(value = "/permissions/{id}", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    public String getOne(@PathVariable("id") Long id,HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getOneResult(permissionService, id,domainid);
    }

    /*
     * (非 Javadoc) Description:
     * @see com.highmind.controller.BaseController#getAll()
     */
    @Override
    @RequestMapping(value = "/permissions", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    public String getAll(HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getAllResult(permissionService,domainid);
       
    }
 
    @Override
    @RequestMapping(value="/permissions",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8")
    public String update(Permission t) {
        // TODO Auto-generated method stub
        return super.updateResult(permissionService, t);
    }
    
    @RequestMapping(value="/group",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String findGroup(String token,HttpSession session,HttpServletRequest request) {
        try {
            System.out.println(session.getAttribute("token"));
            String domainid=request.getHeader("domainid");
            if(session.getAttribute("token").toString().equals(token)) {
                if(JwtUtil.verify(token)) {
                    Long userId=JwtUtil.getUserId(token);
                    Map<String,Object> map=new HashMap<String,Object>(16);
                    map.put("Eid", userId);
                    map.put("domainid", domainid);
                    List<String> selectAll =permissionService.selectGroupByEid(map);
                    return JSONObject.toJSONString(Result.success(selectAll),successFilter,SerializerFeature.WriteMapNullValue);
                }else {
                    return JSONObject.toJSONString(Result.error(CodeMsg.SESSION_NOT_EXSIST),errorFilter,SerializerFeature.WriteMapNullValue);
                }
            }else {
                return JSONObject.toJSONString(Result.error(CodeMsg.ILLEGAL_REQUEST),errorFilter,SerializerFeature.WriteMapNullValue);
            }
        }catch (Exception e){
            e.printStackTrace();
            return JSONObject.toJSONString(Result.error(CodeMsg.ILLEGAL_REQUEST),errorFilter,SerializerFeature.WriteMapNullValue);
        }
       
    }
}
