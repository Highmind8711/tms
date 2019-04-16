/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    EmployeeController.java
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
 *    Create at:   2019年4月3日 上午11:40:04
 *
 *    Revision:
 *
 *    2019年4月3日 上午11:40:04
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.highmind.entity.Employee;
import com.highmind.tool.PropertyHolder;

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
    public String getOne(@PathVariable("id")Long id) {
        // TODO Auto-generated method stub
        return super.getOneResult(employeeService,id);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getAll()
     */
    @Override
    @RequestMapping(value="/employees",method=RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String getAll() {
        // TODO Auto-generated method stub
        return super.getAllResult(employeeService);
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
        String Url=request.getRequestURL().toString();
        System.out.println(Url);
        String url_temp=Url.substring(0, Url.lastIndexOf("/"));
        System.out.println(url_temp);
        String url=url_temp.substring(0, url_temp.lastIndexOf("/")+1);
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
            return jsonObject.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("上传失败");
            e.printStackTrace();
            jsonObject.put("status", 0);
            jsonObject.put("error", "上传失败");
            return jsonObject.toString();
        }
    }
    @RequestMapping(value="/checkIsExist/{loginId}",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String checkIsExist(@PathVariable("loginId")Long id) {
        // TODO Auto-generated method stub
        JSONObject jsonObject=new JSONObject();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("loginId",id);
        int resultId=employeeService.checkUser(map);
        jsonObject.put("status", 1);
        jsonObject.put("data", resultId);
        return jsonObject.toJSONString();
    }
}
