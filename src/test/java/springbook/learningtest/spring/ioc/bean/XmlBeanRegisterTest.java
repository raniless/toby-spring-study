package springbook.learningtest.spring.ioc.bean;

import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class XmlBeanRegisterTest {
    @Test
    public void registerBeanByXmlBeanTagTest() {
        //<Bean> 태그를 이용한 Bean 등록 테스트
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
        Hello hello = ctx.getBean("hello", Hello.class);

        assertNotNull(hello);
        assertEquals("Hello Spring", hello.sayHello());
    }

    @Test
    public void registerBeanByBeanScanningTest() {
        //Bean 스캐닝을 이용한 Bean 등록 테스트
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("springbook.learningtest.spring.ioc.bean");
        AnnotatedHello hello = ctx.getBean("annotatedHello", AnnotatedHello.class);

        assertNotNull(hello);
        assertEquals("AnnotatedHello Class", hello.sayHello());
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void registerNamingBeanByBeanScanningTest() {
        //Bean 스캐닝을 이용한 Naming Bean 등록 테스트
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("springbook.learningtest.spring.ioc.bean");
        //Bean 이름을 지정했기 때문에 대상 default Name으로 찾으면 Excpetion 발생
        AnnotatedHelloNamed hello = ctx.getBean("annotatedHelloNamed", AnnotatedHelloNamed.class);
    }

    @Test
    public void registerNamingBeanByBeanScanning2Test() {
        //Bean 스캐닝을 이용한 Naming Bean 등록 테스트
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("springbook.learningtest.spring.ioc.bean");
        //@Component에 지정된 Bean 이름로 호출했기 때문에 정상적으로 가져옴
        AnnotatedHelloNamed hello = ctx.getBean("myAnnotatedHelloNamed", AnnotatedHelloNamed.class);

        assertNotNull(hello);
        assertEquals("AnnotatedHelloNamed Class", hello.sayHello());
    }
}