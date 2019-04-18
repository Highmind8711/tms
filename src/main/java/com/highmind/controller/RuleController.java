package com.highmind.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.highmind.entity.Rule;
import com.highmind.tool.CodeMsg;
import com.highmind.tool.Result;

/**
 * @ClassName RuleController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 下午12:57:03
 * @version 1.0.0
 */
@RestController
public class RuleController extends BaseController<Rule> {
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#add()
     */
    @Override
    @RequestMapping(value="/rules",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String add(Rule t) {
        return super.addResult(ruleService,t);
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getOne()
     */
    @Override
    @RequestMapping(value="/rules/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getOne(@PathVariable("id")Long id,HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getOneResult(ruleService,id,domainid);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getAll()
     */
    @Override
    @RequestMapping(value="/rules",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll(HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getAllResult(ruleService,domainid);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#update()
     */
    @Override
    @RequestMapping(value="/rules",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8")
    public String update(Rule t) {
        // TODO Auto-generated method stub
        return super.updateResult(ruleService,t);
       
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#delete()
     */
    @Override
    @RequestMapping(value="/rules/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8")
    public String delete(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        return super.deleteResult(ruleService,id);
    }
    @RequestMapping(value="/rulesnames",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAllName() {
        // TODO Auto-generated method stub
        List<Rule> selectAll = ruleService.selectRuleName();
        if(!selectAll.isEmpty()) {
            return JSONObject.toJSONString(Result.success(selectAll),successFilter,SerializerFeature.WriteMapNullValue);
        }else {
            return JSONObject.toJSONString(Result.error(CodeMsg.NOT_FIND_DATA),errorFilter,SerializerFeature.WriteMapNullValue);
        }
    }
    
    @RequestMapping(value="/rulePermissions/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getOneRulePermission(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        HashMap<String, Object> hashMap=new HashMap<String,Object>();
        hashMap.put("id",id);
        List<Rule> selectById = ruleService.selectRulePermission(hashMap);
        
        Rule rule=!selectById.isEmpty()?selectById.get(0):null;
        if(rule!=null) {
            return JSONObject.toJSONString(Result.success(selectById),successFilter,SerializerFeature.WriteMapNullValue);
        }else {
            return JSONObject.toJSONString(Result.error(CodeMsg.NOT_FIND_DATA),errorFilter,SerializerFeature.WriteMapNullValue);
        }
    }
    @RequestMapping(value="/rulePermissions",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAllRulePermission() {
        // TODO Auto-generated method stub
        HashMap<String, Object> hashMap=new HashMap<String,Object>();
        List<Rule> selectAll = ruleService.selectRulePermission(hashMap);
        if(!selectAll.isEmpty()) {
            return JSONObject.toJSONString(Result.success(selectAll),successFilter,SerializerFeature.WriteMapNullValue);
        }else {
            return JSONObject.toJSONString(Result.error(CodeMsg.NOT_FIND_DATA),errorFilter,SerializerFeature.WriteMapNullValue);
        }
    }
}
