package springbook.learningtest.spring.web.controllers;

import org.junit.Test;
import springbook.learningtest.spring.web.servlet.AbstractDispatcherServletTest;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AnnotationHelloControllerTest extends AbstractDispatcherServletTest  {
    @Test
    public void helloServletContoller() throws ServletException, IOException {
        //컨트롤러를 빈으로 등록한다.
        setClasses(AnnotationHelloController.class);
        initRequest("/hello").addParameter("name", "Spring");


        assertEquals("Hello Spring", (String)(runService().getModelAndView().getModelMap().get("message")));
    }
}
