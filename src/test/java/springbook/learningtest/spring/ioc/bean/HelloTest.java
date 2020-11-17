package springbook.learningtest.spring.ioc.bean;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class HelloTest {
    @Test
    public void registerBeanWithManual() {
        StaticApplicationContext context = new StaticApplicationContext();
        context.registerSingleton("hello", Hello.class);

        Hello hello = context.getBean("hello", Hello.class);
        assertNotNull(hello);
    }

    @Test
    public void registerBeanWithBeanDefinition() {
        StaticApplicationContext context = new StaticApplicationContext();

        //<bean class="springbook.learningtest.spring.ioc.bean.Hello" />에 해당
        BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
        //<property name="name" value="Spring" />에 해당
        helloDef.getPropertyValues().addPropertyValue("name", "Spring");
        //hello라는 이름으로 빈 등록
        context.registerBeanDefinition("hello", helloDef);

        Hello hello = context.getBean("hello", Hello.class);
        assertNotNull(hello);
        assertEquals("Hello Spring", hello.sayHello());
        assertEquals(1, context.getBeanFactory().getBeanDefinitionCount());
    }

    @Test
    public void registerBeanWithDependency(){
        StaticApplicationContext context = new StaticApplicationContext();

        context.registerBeanDefinition("printer", new RootBeanDefinition(StringPrinter.class));

        BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
        helloDef.getPropertyValues().addPropertyValue("name", "Spring");
        helloDef.getPropertyValues().addPropertyValue("printer", new RuntimeBeanReference("printer"));

        context.registerBeanDefinition("hello", helloDef);

        Hello hello = context.getBean("hello", Hello.class);
        hello.print();

        assertEquals("Hello Spring", context.getBean("printer").toString());
    }
}