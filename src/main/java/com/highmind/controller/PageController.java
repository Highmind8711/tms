/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    PageController.java
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
 *    Create at:   2019年4月15日 上午9:12:41
 *
 *    Revision:
 *
 *    2019年4月15日 上午9:12:41
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName PageController
 * @Description TODO
 * @author 61430
 * @Date 2019年4月15日 上午9:12:41
 * @version 1.0.0
 */
@Controller
public class PageController {
    @RequestMapping(value="/demo",method=RequestMethod.GET) 
    public String demo(){
        return "demo";
    }
}
