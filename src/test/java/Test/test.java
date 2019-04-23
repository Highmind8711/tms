/******************************************************************
 *
 *    Java Lib For Android, Powered By personal.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     Test
 *
 *    Filename:    test.java
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
 *    Create at:   2019年4月4日 下午2:24:33
 *
 *    Revision:
 *
 *    2019年4月4日 下午2:24:33
 *        - first revision
 *
 *****************************************************************/
package Test;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * @ClassName test
 * @Description TODO
 * @author 61430
 * @Date 2019年4月4日 下午2:24:33
 * @version 1.0.0
 */
public class test {
    @Test
    public void verify_behaviour(){
     // mock creation
        @SuppressWarnings("unchecked")
        List<String> mockedList = mock(List.class);
      //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");
        verify(mockedList, times(2)).add("once");
    }
}
