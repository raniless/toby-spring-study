package springbook.learningtest.spring.ioc.scope;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

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

    static class SingletonBean {}
    static class SingletonClientBean {
        @Autowired
        SingletonBean bean1;
        @Autowired
        SingletonBean bean2;
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

    @Scope("prototype")
    static class PrototypeBean {}
    static class PrototypeClientBean {
        @Autowired
        PrototypeBean bean1;
        @Autowired
        PrototypeBean bean2;
    }
}