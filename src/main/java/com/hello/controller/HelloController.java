package com.hello.controller;

import com.hello.entity.User;
import com.hello.view.HelloPdfView;
import com.hello.view.HelloXlsView;
import com.hello.view.HelloXlsxView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private HelloPdfView helloPdfView;
    @Autowired
    private HelloXlsView helloXlsView;
    @Autowired
    private HelloXlsxView helloXlsxView;

    @RequestMapping("/hello")
    public String hello(ModelMap model) {
        model.put("message", "Hello Spring!!!!!");
        return "hello";
    }

    @RequestMapping("/register")
    public String register(ModelMap model) {
        User user = new User();
        user.setName("Hyoks");
        model.put("user", user);
        return "register";
    }

    @RequestMapping("/hellopdf")
    public ModelAndView registerPdf(ModelMap model) {
        model.put("message", "Gooooooooooooooooooooooooooooooooooooooood!!");
        return new ModelAndView(helloPdfView, model);
    }

    @RequestMapping("/helloxls")
    public ModelAndView registerXls(ModelMap model) {
        List<String> list = new ArrayList<>();
        list.add("캡슐화");
        list.add("상속성");
        list.add("다형성");

        model.put("oop", list);
        return new ModelAndView(helloXlsView, model);
    }

    @RequestMapping("/helloxlsx")
    public ModelAndView registerXlsx(ModelMap model) {
        List<String> list = new ArrayList<>();
        list.add("캡슐화");
        list.add("상속성");
        list.add("다형성");

        model.put("oop", list);
        return new ModelAndView(helloXlsxView, model);
    }
}