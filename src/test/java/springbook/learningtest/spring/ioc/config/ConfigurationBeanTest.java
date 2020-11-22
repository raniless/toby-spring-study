package springbook.learningtest.spring.ioc.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.learningtest.spring.ioc.bean.AnnotatedHello;
import springbook.learningtest.spring.ioc.bean.AnnotatedHelloNamed;
import springbook.learningtest.spring.ioc.bean.Hello;

import static org.junit.Assert.*;

public class ConfigurationBeanTest {
    @Test
    public void getBeanTest() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotatedHelloConfig.class, AnnotatedHelloNamed.class);
        //@Configuration 애노테이션
        AnnotatedHello annotatedHello = ctx.getBean("annotatedHello", AnnotatedHello.class);
        assertNotNull(annotatedHello);

        //@Component 메타 애노테이션
        AnnotatedHelloNamed annotatedHelloNamed = ctx.getBean("myAnnotatedHelloNamed", AnnotatedHelloNamed.class);
        assertNotNull(annotatedHelloNamed);
    }

    @Test
    public void beanSingletonTest() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotatedHelloConfig.class);
        AnnotatedHello annotatedHello = ctx.getBean("annotatedHello", AnnotatedHello.class);
        AnnotatedHello annotatedHello2 = ctx.getBean("annotatedHello", AnnotatedHello.class);

        assertEquals(annotatedHello, annotatedHello2);
    }

    @Test
    public void configurationBeanTest() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotatedHelloConfig.class);
        //@Configuration 클래스 자체도 빈으로 등록된다.
        AnnotatedHelloConfig annotatedHelloConfig = ctx.getBean("annotatedHelloConfig", AnnotatedHelloConfig.class);
        assertNotNull(annotatedHelloConfig);
    }

    @Test
    public void configurationBeanSingleTonTest() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotatedHelloConfig.class);
        AnnotatedHello annotatedHello = ctx.getBean("annotatedHello", AnnotatedHello.class);

        //@Configuration 클래스에서 직접 호출
        AnnotatedHelloConfig annotatedHelloConfig = ctx.getBean("annotatedHelloConfig", AnnotatedHelloConfig.class);
        AnnotatedHello annotatedHello2 = annotatedHelloConfig.annotatedHello();

        //@Bean이 만든 Object는 Singleton
        assertEquals(annotatedHello, annotatedHello2);
    }

    @Test
    public void pojoJavaBeanTest() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(HelloConfig2.class);
        Hello hello = ctx.getBean("hello", Hello.class);
        Hello hello2 = ctx.getBean("hello2", Hello.class);
        
        //서로 다른 Bean 메소드이므로 다른 오브젝트
        assertNotEquals(hello, hello2);
        
        //Printer 오브젝트가 다름
        assertNotEquals(hello.getPrinter(), hello2.getPrinter());
    }

    @Test
    public void pojoJavaBeanTest2() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(HelloConfig3.class);
        Hello hello = ctx.getBean("hello", Hello.class);
        Hello hello2 = ctx.getBean("hello2", Hello.class);

        //서로 다른 Bean 메소드이므로 다른 오브젝트
        assertNotEquals(hello, hello2);

        //Printer 오브젝트는 같음(Printer를 DI 받아서 사용하기 때문)
        assertEquals(hello.getPrinter(), hello2.getPrinter());
    }
}