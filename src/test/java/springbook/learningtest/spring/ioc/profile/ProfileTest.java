package springbook.learningtest.spring.ioc.profile;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.learningtest.spring.ioc.bean.Hello;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProfileTest {
    @Test
    public void xmlLocalProfileTest() {
        ApplicationContext ctx = createApplicationContext("local");
        assertTrue(matchLocalProfile(ctx));
    }

    @Test
    public void xmlDevProfileTest() {
        ApplicationContext ctx = createApplicationContext("dev");
        assertTrue(matchDevProfile(ctx));
    }

    @Test
    public void xmlProductionProfileTest() {
        ApplicationContext ctx = createApplicationContext("production");
        assertTrue(matchProductionProfile(ctx));
    }

    @Test
    public void importAnnotationLocalProfileTest() {
        ApplicationContext ctx = createApplicationContext(AppConfig.class, "local");
        assertTrue(matchLocalProfile(ctx));
    }

    @Test
    public void importAnnotationDevProfileTest() {
        ApplicationContext ctx = createApplicationContext(AppConfig.class, "dev");
        assertTrue(matchDevProfile(ctx));
    }

    @Test
    public void importAnnotationProductionProfileTest() {
        ApplicationContext ctx = createApplicationContext(AppConfig.class, "production");
        assertTrue(matchProductionProfile(ctx));
    }

    @Test
    public void staticAnnotationLocalProfileTest() {
        ApplicationContext ctx = createApplicationContext(StaticProfileAppConfig.class, "local");
        assertTrue(matchLocalProfile(ctx));
    }

    @Test
    public void staticAnnotationDevProfileTest() {
        ApplicationContext ctx = createApplicationContext(StaticProfileAppConfig.class, "dev");
        assertTrue(matchDevProfile(ctx));
    }

    @Test
    public void staticAnnotationProductionProfileTest() {
        ApplicationContext ctx = createApplicationContext(StaticProfileAppConfig.class, "production");
        assertTrue(matchProductionProfile(ctx));
    }

    private ApplicationContext createApplicationContext(String profile) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles(profile);

        ctx.load("applicationProfileContext.xml");
        ctx.refresh();
        return ctx;
    }

    private ApplicationContext createApplicationContext(Class<?> configClass, String profile) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles(profile);

        ctx.register(configClass);
        ctx.refresh();

        return ctx;
    }

    private boolean matchLocalProfile(ApplicationContext ctx) {
        return matchProfile(ctx, "Local");
    }

    private boolean matchDevProfile(ApplicationContext ctx) {
        return matchProfile(ctx, "Dev");
    }

    private boolean matchProductionProfile(ApplicationContext ctx) {
        return matchProfile(ctx, "Production");
    }

    private boolean matchProfile(ApplicationContext ctx, String Name) {
        String expected = "Hello " + Name + " Spring";

        Hello hello = ctx.getBean("hello", Hello.class);
        hello.print();
        return expected.equals(hello.getPrinter().toString());
    }
}