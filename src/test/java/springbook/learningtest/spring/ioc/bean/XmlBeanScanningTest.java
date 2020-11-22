package springbook.learningtest.spring.ioc.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/XmlBeanScanningContext.xml")
public class XmlBeanScanningTest {
    @Autowired
    ApplicationContext ctx;

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void noSuchBeanTest() {
        //Hello 클래스는 스테레오타입 애노테이션이 없으므로 NoSuchBeanDefinitionException 발생
        Hello hello = ctx.getBean("hello", Hello.class);
        assertNull(hello);
    }

    @Test
    public void beanScanningTest() {
        AnnotatedHello hello = ctx.getBean("annotatedHello", AnnotatedHello.class);
        assertNotNull(hello);
        assertEquals("AnnotatedHello Class", hello.sayHello());
    }
}