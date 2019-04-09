/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     ServiceTest
 *
 *    Filename:    PermissionTest.java
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
 *    Create at:   2019年4月4日 下午2:58:33
 *
 *    Revision:
 *
 *    2019年4月4日 下午2:58:33
 *        - first revision
 *
 *****************************************************************/
package ServiceTest;

import static org.mockito.Mockito.mock;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.highmind.entity.Employee;
import com.highmind.entity.Operation;
import com.highmind.entity.Permission;
import com.highmind.service.EmployeeService;
import com.highmind.service.PermissionService;

/**
 * @ClassName PermissionTest
 * @Description TODO
 * @author 61430
 * @Date 2019年4月4日 下午2:58:33
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) 
public class PermissionTest {
    @Autowired
    private PermissionService permissionService;
    @Test
    public void insert() {
        Permission mock = mock(Permission.class);
        permissionService.add(mock );
    }
    @Test
    public void select() {
        
    }
    @Test
    public void selectOne() {
        Map map=new HashMap<String,String>();
        map.put("id", 1);
        Permission de=permissionService.selectById(map);
    }
    @Test
    public void update() {
        Map map=new HashMap<String,String>();
        map.put("id", 1);
        Permission de=permissionService.selectById(map);
        de.setDomainid((long) 5);
        permissionService.update(de);
    }
}
