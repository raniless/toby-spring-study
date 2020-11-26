package springbook.learningtest.spring.converter;

import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ConversionServiceFactoryBean;
import springbook.learningtest.spring.ioc.bean.ConverterBean;
import springbook.learningtest.spring.ioc.bean.Hello;

import static org.junit.Assert.*;

public class ConverterTest {
    @Test
    public void converterTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("classpath:propertyTestContext.xml");
        context.registerBean(ConverterBean.class);
        context.refresh();

        ConverterBean converterBean = context.getBean(ConverterBean.class);
        assertNotNull(converterBean);
        assertSame(Hello.class, converterBean.getHello().getClass());
        assertEquals("Hello Hyoks", converterBean.getHello().sayHello());
    }
}