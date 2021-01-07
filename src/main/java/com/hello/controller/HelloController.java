package com.hello.controller;

import com.hello.entity.User;
import com.hello.view.HelloPdfView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @Autowired
    private HelloPdfView helloPdfView;

    @RequestMapping("/hello")
    public String hello(ModelMap model) {
        model.put("message", "Hello Spring!!!!!");
        return "/WEB-INF/view/hello.jsp";
    }

    @RequestMapping("/register")
    public String register(ModelMap model) {
        User user = new User();
        user.setName("Hyoks");
        model.put("user", user);
        return "/WEB-INF/view/register.jsp";
    }

    @RequestMapping("/hellopdf")
    public ModelAndView registerPdf(ModelMap model) {
        model.put("message", "Gooooooooooooooooooooooooooooooooooooooood!!");
        return new ModelAndView(helloPdfView, model);
    }
}