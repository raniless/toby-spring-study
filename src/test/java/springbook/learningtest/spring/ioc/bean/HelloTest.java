package springbook.learningtest.spring.ioc.bean;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class HelloTest {
    @Test
    public void registerBeanWithManual() {
        StaticApplicationContext ac = new StaticApplicationContext();
        ac.registerSingleton("hello1", Hello.class);

        Hello hello1 = ac.getBean("hello1", Hello.class);
        assertNotNull(hello1);

        BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
        helloDef.getPropertyValues().addPropertyValue("name", "Spring");

        ac.registerBeanDefinition("hello2", helloDef);

        Hello hello2 = ac.getBean("hello2", Hello.class);
        assertNotNull(hello2);
        assertEquals("Hello Spring", hello2.sayHello());
        assertNotEquals(hello1, hello2);
        assertEquals(2, ac.getBeanFactory().getBeanDefinitionCount());
    }
}
