package springbook.learningtest.spring.ioc.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springbook.learningtest.spring.ioc.bean.Printer;
import springbook.learningtest.spring.ioc.bean.StringPrinter;

@Configuration
@Import({LocalConfig.class, DevConfig.class, ProductionConfig.class})
public class AppConfig {
    @Bean
    public Printer printer() {
        return new StringPrinter();
    }
}
