/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     dataCollect
 *
 *    Filename:    PropertyHolderLazy.java
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
 *    Create at:   2019年3月21日 上午5:52:34
 *
 *    Revision:
 *
 *    2019年3月21日 上午5:52:34
 *        - first revision
 *
 *****************************************************************/
package com.highmind.tool;

import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName PropertyHolderLazy
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 61430
 * @Date 2019年3月21日 上午5:52:34
 * @version 1.0.0
 */
public class PropertyHolder {
    private static Properties prop= null;
    public static  Properties getProps() throws IOException {
        if(prop==null) {
            synchronized(PropertyHolder.class) {
                if(prop==null) {
                    prop= new Properties();
                    prop.load(PropertyHolder.class.getClassLoader().getResourceAsStream("config.properties"));
                }
            }
        }
         return prop;

    }
}
