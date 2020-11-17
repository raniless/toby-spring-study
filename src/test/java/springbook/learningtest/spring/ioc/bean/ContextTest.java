package springbook.learningtest.spring.ioc.bean;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.Assert.*;

public class ContextTest {
    private String xmlResourceLocation;
    private String propsResourceLocation;

    @Before
    public void setUp() {
        xmlResourceLocation = "applicationContext.xml";
        propsResourceLocation = "applicationContext.properties";
    }

    @Test
    public void genericApplicationContextWithXmlTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(xmlResourceLocation);
        //초기화 명령
        context.refresh();

        Hello hello = context.getBean("hello", Hello.class);
        hello.print();

        assertEquals("Hello Spring", context.getBean("printer").toString());
    }

    @Test
    public void genericApplicationContextWithPropertiesTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(context);
        reader.loadBeanDefinitions(propsResourceLocation);
        //초기화 명령
        context.refresh();

        Hello hello = context.getBean("hello", Hello.class);
        hello.print();

        assertEquals("Hello Spring", context.getBean("printer").toString());
    }

    @Test
    public void genericXmlApplicationContextTest() {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext(xmlResourceLocation);

        Hello hello = context.getBean("hello", Hello.class);
        hello.print();

        assertEquals("Hello Spring", context.getBean("printer").toString());
    }
}
