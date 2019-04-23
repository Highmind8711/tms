package com.highmind.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highmind.entity.Department;

/**
 * @ClassName DepartmentController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 上午11:39:41
 * @version 1.0.0
 */
@RestController
public class DepartmentController extends BaseController<Department>{
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#add()
     */
    @Override
    @RequestMapping(value="/departments",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String add(Department t) {
        return super.addResult(departmentService,t);
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getOne()
     */
    @Override
    @RequestMapping(value="/departments/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getOne(@PathVariable("id")Long id,HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getOneResult(departmentService,id,domainid);
    }
    /* (非 Javadoc)
     * Description:查询部门下的所有的员工
     * @see com.highmind.controller.BaseController#getAll()
     */
    @Override
    @RequestMapping(value="/departments",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll(HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        System.out.println(domainid);
        return super.getAllResult(departmentService,domainid);
    }
    /**
     * 查询全部部门名字
     * @Description
     * @return
     */
    @RequestMapping(value="/departmentnames",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAllName(HttpServletRequest request) {
        String domainid=request.getHeader("domainid");
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("domainid", domainid);
        List<Department> selectAll = departmentService.selectDepartmentName(map);
        return getString(selectAll, !selectAll.isEmpty());
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#update()
     */
    @Override
    @RequestMapping(value="/departments",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8")
    public String update(Department t) {
        // TODO Auto-generated method stub
        return super.updateResult(departmentService,t);
       
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#delete()
     */
    @Override
    @RequestMapping(value="/departments/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8")
    public String delete(@PathVariable("id")Long id) {
        return super.deleteResult(departmentService,id);
    }
    @RequestMapping(value="/departmentrecursion",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String findAllRecursion(HttpServletRequest request) {
        Long domainid=null ;
        if(request.getHeader("domainid")!=null) {
            domainid=Long.valueOf(request.getHeader("domainid"));
        }
       
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("domainid", domainid);
        List<Department> selectAll = departmentService.findAllRecursion(null);
        return getString(selectAll, !selectAll.isEmpty());
    }
    @RequestMapping(value="/findroot",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String findRoot(HttpServletRequest request) {
        String domainid=request.getHeader("domainid");
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("domainid", domainid);
        List<Department> selectAll = departmentService.findRoot(map);
        return getString(selectAll, !selectAll.isEmpty());
    }

    @RequestMapping(value="/findchild/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String findchild(@PathVariable("id")Long id) {
        List<Department> selectAll = departmentService.findChild(id);
        return getString( selectAll, !selectAll.isEmpty());
    }
 
}
