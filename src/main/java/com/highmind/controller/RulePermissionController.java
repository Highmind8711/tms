package com.highmind.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.highmind.entity.RulePermission;
import com.highmind.tool.CodeMsg;
import com.highmind.tool.Result;

/**
 * @ClassName RulePermissionController
 * @Description TODO
 * @author 61430
 * @Date 2019年4月6日 上午9:44:52
 * @version 1.0.0
 */
@RestController
public class RulePermissionController extends BaseController<RulePermission>{

   
    @RequestMapping(value="/rulepermissions",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String add(List<RulePermission> t) {
        // TODO Auto-generated method stub
        int id=rulePermissionService.addRulePermissions(t);
        if(id>0) {
            return JSONObject.toJSONString(Result.success(id),successFilter,SerializerFeature.WriteMapNullValue);
        }else {
            return JSONObject.toJSONString(Result.error(CodeMsg.INSERT_ERROR),errorFilter,SerializerFeature.WriteMapNullValue);
        }
    }


    @Override
    @RequestMapping(value="/rulepermissions",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8")
    public String update(RulePermission t) {
        // TODO Auto-generated method stub
        return super.updateResult(rulePermissionService, t);
    }

    @Override
    @RequestMapping(value="/rulepermissions/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8")
    public String delete(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        return super.deleteResult(rulePermissionService, id);
    }

}
