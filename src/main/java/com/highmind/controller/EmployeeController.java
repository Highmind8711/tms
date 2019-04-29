package com.highmind.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.highmind.entity.Employee;
import com.highmind.entity.Loginlog;
import com.highmind.tool.CodeMsg;
import com.highmind.tool.JwtUtil;
import com.highmind.tool.PropertyHolder;
import com.highmind.tool.Result;

/**
 * @ClassName EmployeeController
 * @Description TODO 雇员控制
 * @author 61430
 * @Date 2019年4月3日 上午11:40:04
 * @version 1.0.0
 */
@RestController
public class EmployeeController extends BaseController<Employee>{

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        System.out.println("come in------------------------");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#add()
     */
    @Override
    @RequestMapping(value="/employees",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String add(Employee t) {
        System.out.println(JSONObject.toJSONString(t));
        return super.addResult(employeeService,t);
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getOne()
     */
    @Override
    @RequestMapping(value="/employees/{id}",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getOne(@PathVariable("id")Long id,HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getOneResult(employeeService,id,domainid);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getAll()
     */
    @Override
    @RequestMapping(value="/employees",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll(HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        return super.getAllResult(employeeService,domainid);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#update()
     */
    @Override
    @RequestMapping(value="/employees",method=RequestMethod.PUT,produces = "text/json;charset=UTF-8")
    public String update(Employee t) {
        // TODO Auto-generated method stub
        return super.updateResult(employeeService,t);
       
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#delete()
     */
    @Override
    @RequestMapping(value="/employees/{id}",method=RequestMethod.DELETE,produces = "text/json;charset=UTF-8")
    public String delete(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        return super.deleteResult(employeeService,id);
    }
    /**
     *  http://localhost:8080/upload_image/4219aa11df224e40a859ff243db2111atimg.jpg
     * @Description 上传接口
     * @param picture
     * @param request
     * @return
     */
    @RequestMapping("/upload")
    public String uploadImage(MultipartFile picture, HttpServletRequest request) {
        JSONObject jsonObject=new JSONObject();
        String urlAll=request.getRequestURL().toString();
        System.out.println(urlAll);
        String urlTemp=urlAll.substring(0, urlAll.lastIndexOf("/"));
        System.out.println(urlTemp);
        String url=urlTemp.substring(0, urlTemp.lastIndexOf("/")+1);
        System.out.println(url);
        try {
            Properties prop=PropertyHolder.getProps();
            String path=prop.getProperty("File_Upload");
            File filePath = new File(path);
            System.out.println("文件的保存路径：" + path);
            if (!filePath.exists() && !filePath.isDirectory()) {
                System.out.println("目录不存在，创建目录:" + filePath);
                filePath.mkdir();
            }
            //获取原始文件名称(包含格式)
            String originalFileName = picture.getOriginalFilename();
            System.out.println("原始文件名称：" + originalFileName);

            //获取文件类型，以最后一个`.`为标识
            String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            System.out.println("文件类型：" + type);
            //获取文件名称（不包含格式）
            String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

            //设置文件新名称: 当前时间+文件名称（不包含格式）
            String uuid=java.util.UUID.randomUUID().toString().replaceAll("-", "");
            String fileName = uuid + name + "." + type;
            System.out.println("新文件名称：" + fileName);

            //在指定路径下创建一个文件
            File targetFile = new File(path, fileName);
            picture.transferTo(targetFile);
            System.out.println("上传成功");
            //将文件在服务器的存储路径返回
            jsonObject.put("status", 1);
            jsonObject.put("data", "upload_image/" + fileName);
            return jsonObject.toJSONString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("上传失败");
            e.printStackTrace();
            jsonObject.put("status", 0);
            jsonObject.put("error", "上传失败");
            return jsonObject.toJSONString();
        }
    }
    @RequestMapping(value="/checkIsExist/{loginId}",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String checkIsExist(@PathVariable("loginId")Long id,HttpServletRequest request) {
        // TODO Auto-generated method stub
        String domainid=request.getHeader("domainid");
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("loginId",id);
        map.put("domainid", domainid);
        Employee employee=employeeService.checkUser(map);
        if(employee.getId()>0) {
            return JSONObject.toJSONString(Result.success(employee.getId()),successFilter,SerializerFeature.WriteMapNullValue);
        }else {
            return JSONObject.toJSONString(Result.error(CodeMsg.USER_EXSIST),errorFilter,SerializerFeature.WriteMapNullValue);
        }
    }
    @RequestMapping(value="/login",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String login(String loginid,String password,String domainid,HttpSession session,HttpServletRequest request) throws Exception {
//        Subject currentUser = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(loginid, password,domainid);
//        try {
//            currentUser.login(token);
//            return JSONObject.toJSONString(Result.success(),successFilter,SerializerFeature.WriteMapNullValue);
//        } catch (AuthenticationException e) {
//            return JSONObject.toJSONString(Result.error(CodeMsg.USER_NOT_EXSIST),errorFilter,SerializerFeature.WriteMapNullValue);
//        }
//        
        
        Map<String,Object> mapLogin=new HashMap<String,Object>();
        
        mapLogin.put("loginId",loginid);
        mapLogin.put("password",password);
        mapLogin.put("domainid", domainid);
        System.out.println(domainid);
        if(domainid==null) {
            throw new Exception();
        }
        Employee employee=employeeService.checkUser(mapLogin);
        if(employee!=null) {
            String token =JwtUtil.sign(employee.getId(),employee.getLoginId(),employee.getPassword());
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("token", token);
            session.setAttribute("token", token);
            Loginlog loginlog=new Loginlog();
            System.out.println(token);
            loginlog.setDomainid(Long.parseLong(domainid));
            loginlog.setEmployee_id(employee.getId());
            loginlog.setEnterdate(new Date());
            loginlog.setIp(getIpAddress(request));
            loginlogService.add(loginlog);
            return JSONObject.toJSONString(Result.success(jsonObject),successFilter,SerializerFeature.WriteMapNullValue);
        }else {
            return JSONObject.toJSONString(Result.error(CodeMsg.USER_NOT_EXSIST),errorFilter,SerializerFeature.WriteMapNullValue);
        }
        
    }
    /**
     * 获取请求ip
     * @Description
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {  
        String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }
    @RequestMapping(value="/loginout",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public void loginOut(HttpSession session) {
        
        session.invalidate();
        
    }
    @RequestMapping(value="/getInfo",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getinfo(String token) {
        System.out.println(token);
        if(JwtUtil.verify(token)) {
            Long userId=JwtUtil.getUserId(token);
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("id", userId);
            Employee employee=employeeService.selectById(map);
            if(employee!=null) {
                return JSONObject.toJSONString(Result.success(employee),successFilter,SerializerFeature.WriteMapNullValue);
            }else{
                return JSONObject.toJSONString(Result.error(CodeMsg.USER_NOT_EXSIST),errorFilter,SerializerFeature.WriteMapNullValue);
            }
        }else {
            return JSONObject.toJSONString(Result.error(CodeMsg.SESSION_NOT_EXSIST),errorFilter,SerializerFeature.WriteMapNullValue);
        }
    }
}
