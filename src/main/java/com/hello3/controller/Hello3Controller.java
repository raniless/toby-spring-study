package com.hello3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hello3")
public class Hello3Controller {
    @RequestMapping("/modelAttribute")
    public String getModelAttribute(ModelMap modelMap) {
        modelMap.addAttribute("modelTest", "modelTest");
        modelMap.addAttribute("modelTest2", "modelTest2");

        return "autoModelAdd";
    }

    @ModelAttribute("codes")
    public List<String> getCodes() {
        List<String> codes = new ArrayList<>();
        codes.add("CODE1");
        codes.add("CODE2");
        codes.add("CODE3");
        codes.add("CODE4");

        return codes;
    }
}