package springbook.learningtest.spring.ioc.property;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.Assert.*;

public class SpelPropertyTest {
    @Test
    public void spelTest() {
        ApplicationContext context = new GenericXmlApplicationContext("propertyTestContext.xml");
        SpelProperty spelProperty = context.getBean("spelProperty", SpelProperty.class);

        assertNotNull(spelProperty);
        assertEquals("com.mysql.cj.jdbc.Driver", spelProperty.getDriverClass());
        assertEquals("jdbc:mysql://localhost/tobydb?serverTimezone=UTC", spelProperty.getUrl());
        assertEquals("root", spelProperty.getUsername());
        assertEquals("root", spelProperty.getPassword());
    }
}
