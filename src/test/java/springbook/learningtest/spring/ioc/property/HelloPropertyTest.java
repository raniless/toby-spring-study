package springbook.learningtest.spring.ioc.property;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:propertyTestContext.xml")
public class HelloPropertyTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void valueAnnotationTest() {
        HelloProperty helloProperty = context.getBean("helloProperty", HelloProperty.class);

        assertNotNull(helloProperty);
        //@Value 필드 주입 테스트
        assertEquals("fieldValue", helloProperty.getFieldValue());
        //@Value 수정자 주입 테스트
        assertEquals("EveryOne", helloProperty.getName());
        //@Value 메소드 파라미터 주입 테스트
        assertEquals("paramValue", helloProperty.getParam());
        //외부 리소스 주입 테스트
        assertEquals("root", helloProperty.getUserName());
        //환경정보 주입 테스트
        assertEquals("Windows 10", helloProperty.getOsName());

        //PropertyEditor 기본타입 변환 테스트
        assertTrue(helloProperty.isFlag());
        //PropertyEditor 배열 변환 테스트
        assertArrayEquals(new int[]{1,2,3,4}, helloProperty.getIntArr());
    }
}