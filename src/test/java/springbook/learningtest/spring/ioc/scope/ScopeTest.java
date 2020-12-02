package springbook.learningtest.spring.ioc.scope;

import org.junit.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.learningtest.spring.ioc.scope.config.ObjectFactoryConfig;
import springbook.learningtest.spring.ioc.scope.config.ServiceLocatorConfig;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ScopeTest {
    @Test
    public void singletonScopeTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class, SingletonClientBean.class);
        Set<SingletonBean> beans = new HashSet<>();

        //DL(Dependency Lookup)에서 싱글톤 테스트
        beans.add(ac.getBean(SingletonBean.class));
        beans.add(ac.getBean(SingletonBean.class));
        assertEquals(1, beans.size());

        //DI(Dependency Injection)에서 싱글톤 테스트
        beans.add(ac.getBean(SingletonClientBean.class).bean1);
        beans.add(ac.getBean(SingletonClientBean.class).bean2);
        assertEquals(1, beans.size());
    }

    @Test
    public void prototypeScopeTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class, PrototypeClientBean.class);
        Set<PrototypeBean> beans = new HashSet<>();

        //DL(Dependency Lookup)에서 프로토타입 테스트
        beans.add(ac.getBean(PrototypeBean.class));
        assertEquals(1, beans.size());
        beans.add(ac.getBean(PrototypeBean.class));
        assertEquals(2, beans.size());

        //DI(Dependency Injection)에서 프로토타입 테스트
        beans.add(ac.getBean(PrototypeClientBean.class).bean1);
        assertEquals(3, beans.size());
        beans.add(ac.getBean(PrototypeClientBean.class).bean2);
        assertEquals(4, beans.size());
    }

    //Prototype 빈 DL 전략
    @Test
    public void objectFactoryTest() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PrototypeBean.class, ObjectFactoryConfig.class);
        ObjectFactory<PrototypeBean> beanFactory = ctx.getBean("prototypeBeanFactory", ObjectFactory.class);

        Set<PrototypeBean> beans = new HashSet<>();
        for(int i=1; i<=4; i++) {
            beans.add(beanFactory.getObject());
            assertEquals(i, beans.size());
        }
    }

    //Prototype 빈 DL 전략
    @Test
    public void serviceLocatorFactoryBeanTest() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PrototypeBean.class, ServiceLocatorConfig.class);
        PrototypeBeanFactory beanFactory = ctx.getBean(PrototypeBeanFactory.class);
        Set<PrototypeBean> beans = new HashSet<>();
        for(int i=1; i<=4; i++) {
            beans.add(beanFactory.getPrototypeBean());
            assertEquals(i, beans.size());
        }
    }

    //Prototype 빈 DL 전략
    @Test
    public void providerTest() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PrototypeBean.class, ProviderClient.class);
        ProviderClient providerClient = ctx.getBean(ProviderClient.class);
        Set<PrototypeBean> beans = new HashSet<>();
        for(int i=1; i<=4; i++) {
            beans.add(providerClient.prototypeBeanProvider.get());
            assertEquals(i, beans.size());
        }
    }
}