package springbook.learningtest.spring.web.controllers;

import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;
import springbook.learningtest.spring.web.AbstractDispatcherServletTest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.*;

public class ServletControllerTest extends AbstractDispatcherServletTest  {
    @Test
    public void helloServletContoller() throws ServletException, IOException {
        //핸들러 어댑터와 컨트롤러를 빈으로 등록해준다.
        setClasses(SimpleServletHandlerAdapter.class, HelloServlet.class);
        initRequest("/hello").addParameter("name", "Spring");

        assertEquals("Hello Spring", runService().getContentAsString());
    }

    @Component("/hello")
    static class HelloServlet extends HttpServlet {
        protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            //GET 메소드를 통해 전달받은 name 파라미터 값을 이용해서 메시지를 만든 후에 HttpServletResponse에 넣어준다.
            String name = req.getParameter("name");
            res.getWriter().print("Hello " + name);
        }
    }
}
