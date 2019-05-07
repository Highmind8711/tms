/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     ServiceTest
 *
 *    Filename:    EmployeeTest.java
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
 *    Create at:   2019年4月4日 下午2:40:51
 *
 *    Revision:
 *
 *    2019年4月4日 下午2:40:51
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

import com.highmind.entity.Employee;
import com.highmind.service.EmployeeService;

/**
 * @ClassName EmployeeTest
 * @Description TODO
 * @author 61430
 * @Date 2019年4月4日 下午2:40:51
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) 
public class EmployeeTest {
    @Autowired
    private EmployeeService employeeService;
    @Test
    public void insert() {
        Employee mock = new Employee();
        mock.setDomainid((long) 1);
        mock.setIsLoginEnabled((byte) 0);
        mock.setSex((long) 0);
        mock.setDepartment_id((long) 3);
        employeeService.add(mock );
    }
    @Test
    public void select() {
        
    }
    @Test
    public void selectOne() {
        Map<String,Object> map=new HashMap<String,Object>(16);
        map.put("id", 1);
        Employee de=employeeService.selectById(map);
    }
    @Test
    public void update() {
        Map<String,Object> map=new HashMap<String,Object>(16);
        map.put("id", 1);
        Employee de=employeeService.selectById(map);
        de.setDomainid((long) 5);
        employeeService.update(de);
    }
}
