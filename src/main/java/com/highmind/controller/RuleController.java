/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.controller
 *
 *    Filename:    RuleController.java
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
 *    Create at:   2019年4月3日 下午12:57:03
 *
 *    Revision:
 *
 *    2019年4月3日 下午12:57:03
 *        - first revision
 *
 *****************************************************************/
package com.highmind.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.highmind.entity.Rule;

/**
 * @ClassName RuleController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年4月3日 下午12:57:03
 * @version 1.0.0
 */
@Controller
public class RuleController extends BaseController<Rule> {
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#add()
     */
    @Override
    @RequestMapping(value="/rules",method=RequestMethod.POST)
    public String add(Rule t) {
        return super.addResult(ruleService,t);
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getOne()
     */
    @Override
    @RequestMapping(value="/rules/{id}",method=RequestMethod.GET)
    public String getOne(Long id) {
        // TODO Auto-generated method stub
        return super.getOneResult(ruleService,id);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#getAll()
     */
    @Override
    @RequestMapping(value="/rules",method=RequestMethod.GET)
    public String getAll() {
        // TODO Auto-generated method stub
        return super.getAllResult(ruleService);
    }
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#update()
     */
    @Override
    @RequestMapping(value="/rules/{id}",method=RequestMethod.PUT)
    public String update(Rule t) {
        // TODO Auto-generated method stub
        return super.updateResult(ruleService,t);
       
    }
    
    /* (非 Javadoc)
     * Description:
     * @see com.highmind.controller.BaseController#delete()
     */
    @Override
    @RequestMapping(value="/rules/{id}",method=RequestMethod.DELETE)
    public String delete(Long id) {
        // TODO Auto-generated method stub
        return super.deleteResult(ruleService,id);
    }
}
