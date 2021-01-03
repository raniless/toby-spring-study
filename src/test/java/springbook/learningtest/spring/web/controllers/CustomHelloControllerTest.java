package springbook.learningtest.spring.web.controllers;

import org.junit.Test;
import springbook.learningtest.spring.web.servlet.AbstractDispatcherServletTest;

import javax.servlet.ServletException;
import java.io.IOException;

public class CustomHelloControllerTest extends AbstractDispatcherServletTest {
    @Test
    public void simpleHanderAdapterTest() throws ServletException, IOException {
        setClasses(CustomSimpleHandlerAdapter.class, CustomHelloController.class);
        initRequest("/hello").addParameter("name", "Spring").runService();
        assertViewName("/WEB-INF/view/hello.jsp");
        assertModel("message", "Hello Spring");
    }
}
