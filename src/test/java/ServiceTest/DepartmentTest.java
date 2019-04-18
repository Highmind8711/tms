/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     ServiceTest
 *
 *    Filename:    DepartmentTest.java
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
 *    Create at:   2019年4月4日 下午1:19:34
 *
 *    Revision:
 *
 *    2019年4月4日 下午1:19:34
 *        - first revision
 *
 *****************************************************************/
package ServiceTest;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.highmind.entity.Department;
import com.highmind.service.DepartmentService;

/**
 * @ClassName DepartmentTest
 * @Description TODO
 * @author 61430
 * @Date 2019年4月4日 下午1:19:34
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) 
public class DepartmentTest {
    @Autowired
    private DepartmentService departmentService;
    @Test
    public void insert() {
        Department mock = mock(Department.class);
        departmentService.add(mock );
    }
    @Test
    public void select() {
        
    }
    @Test
    public void selectOne() {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id", 1);
        Department de=departmentService.selectById(map);
    }
    @Test
    public void update() {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id", 1);
        Department de=departmentService.selectById(map);
        de.setDomainid((long) 5);
        departmentService.update(de);
    }

}
