package com.hello4.controller;

import com.hello.entity.UserSearch;
import com.hello4.entity.Member;
import com.hello4.propertyeditor.MinMaxPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello4")
public class Hello4Controller {
    @RequestMapping("/userSearch")
    public String userSearch(@ModelAttribute UserSearch userSearch) {
        return "initBinder";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(@ModelAttribute Member member) {
        return "id : " + member.getId() + ", age : " + member.getAge();
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        //int 타입에 변수명이 age인 프로퍼티만 MinMaxPropertyEditor 적용
        dataBinder.registerCustomEditor(int.class, "age", new MinMaxPropertyEditor(0, 200));
    }
}
