/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     ServiceTest
 *
 *    Filename:    Operationtest.java
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
 *    Create at:   2019年4月4日 下午2:58:20
 *
 *    Revision:
 *
 *    2019年4月4日 下午2:58:20
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
import com.highmind.entity.Menu;
import com.highmind.entity.Operation;
import com.highmind.service.EmployeeService;
import com.highmind.service.OperationService;

/**
 * @ClassName Operationtest
 * @Description TODO
 * @author 61430
 * @Date 2019年4月4日 下午2:58:20
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) 
public class Operationtest {
    @Autowired
    private OperationService operationService;
    @Test
    public void insert() {
        Operation mock = mock(Operation.class);
        operationService.add(mock );
    }
    @Test
    public void select() {
        
    }
    @Test
    public void selectOne() {
        Map map=new HashMap<String,String>();
        map.put("id", 1);
        Operation de=operationService.selectById(map);
    }
    @Test
    public void update() {
        Map map=new HashMap<String,String>();
        map.put("id", 1);
        Operation de=operationService.selectById(map);
        de.setDomainid((long) 5);
        operationService.update(de);
    }
}
