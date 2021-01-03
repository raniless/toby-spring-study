package springbook.learningtest.spring.web.controllers;

import org.springframework.stereotype.Controller;
import springbook.learningtest.spring.web.annotation.RequiredParams;
import springbook.learningtest.spring.web.annotation.ViewName;

import java.util.Map;

@Controller("/hello")
public class CustomHelloController implements CustomSimpleController {
    @ViewName("/WEB-INF/view/hello.jsp")
    @RequiredParams({"name"})
    @Override
    public void control(Map<String, String> params, Map<String, Object> model) {
        model.put("message", "Hello " + params.get("name"));
    }
}
