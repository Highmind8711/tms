/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.highmind.tool
 *
 *    Filename:    Handle.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    @author:     61430
 *
 *    @version:    1.0.0
 *
 *    Create at:   2019年4月29日 上午9:39:18
 *
 *    Revision:
 *
 *    2019年4月29日 上午9:39:18
 *        - first revision
 *
 *****************************************************************/
package com.highmind.tool;


/**
 * @ClassName Handle 
 * @Description TODO 前台传入该类操作数组后台处理
 * @author 61430
 * @Date 2019年4月29日 上午9:39:18
 * @version 1.0.0
 */
public class Handle {
    private String operation;
    private String name;
    private String data;
    
    public String getOperation() {
        return operation;
    }
    
    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Handle [operation=" + operation + ", name=" + name + ", data=" + data + "]";
    }
    
    
}
