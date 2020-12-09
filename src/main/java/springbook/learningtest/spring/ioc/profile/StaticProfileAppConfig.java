package springbook.learningtest.spring.ioc.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springbook.learningtest.spring.ioc.bean.Hello;
import springbook.learningtest.spring.ioc.bean.Printer;
import springbook.learningtest.spring.ioc.bean.StringPrinter;

/* applicationProfileContext.xml */
@Configuration
public class StaticProfileAppConfig {
    @Bean
    public Printer printer() {
        return new StringPrinter();
    }

    @Configuration
    @Profile("local")
    public static class LocalConfig {
        @Autowired
        private Printer printer;

        @Bean
        public Hello hello() {
            Hello hello = new Hello();
            hello.setName("Local Spring");
            hello.setPrinter(printer);
            return hello;
        }
    }

    @Configuration
    @Profile("dev")
    public static class DevConfig {
        @Autowired
        private Printer printer;

        @Bean
        public Hello hello() {
            Hello hello = new Hello();
            hello.setName("Dev Spring");
            hello.setPrinter(printer);
            return hello;
        }
    }

    @Configuration
    @Profile("production")
    public static class ProductionConfig {
        @Autowired
        private Printer printer;

        @Bean
        public Hello hello() {
            Hello hello = new Hello();
            hello.setName("Production Spring");
            hello.setPrinter(printer);
            return hello;
        }
    }
}
