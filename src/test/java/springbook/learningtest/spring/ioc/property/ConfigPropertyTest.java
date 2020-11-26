package springbook.learningtest.spring.ioc.property;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springbook.learningtest.spring.ioc.bean.Hello;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigProperty.class})
public class ConfigPropertyTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void valueAnnotationTest() {
        Hello hello = context.getBean("hello", Hello.class);
        Hello hello2 = context.getBean("hello2", Hello.class);

        assertNotNull(hello);
        assertNotNull(hello2);

        assertEquals("Hello root", hello.sayHello());
        assertEquals("Hello root", hello2.sayHello());
    }
}
