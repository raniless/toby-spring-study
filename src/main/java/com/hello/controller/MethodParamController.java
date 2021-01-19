package com.hello.controller;

import com.hello.entity.UserSearch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/methodparam")
public class MethodParamController {
    @RequestMapping("/http")
    public String getHttpObject(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("message", "request!!");
        response.setHeader("Test-Title", "Response Test");

        return "methodparam";
    }

    @RequestMapping("/httpsession")
    public String getHttpSession(HttpSession session, ModelMap model) {
        session.setAttribute("testSessionValue", "Session Test Value!");
        return "methodparam";
    }

    @RequestMapping("/pathvariable/{code}/{id}")
    public String getPathVariable(@PathVariable("code") String code, @PathVariable int id, Model model) {
        model.addAttribute("code", code);
        model.addAttribute("id", id);

        return "methodparam";
    }

    @RequestMapping("/requestparam")
    public String getRequestParam(@RequestParam("id2") int id2, @RequestParam String code2, Model model) {
        model.addAttribute("id2", id2);
        model.addAttribute("code2", code2);

        return "methodparam";
    }

    @RequestMapping("/requestparam2")
    public String getRequestParam2(@RequestParam Map<String, String> params, Model model) {
        model.addAllAttributes(params);

        return "methodparam";
    }

    @RequestMapping("/requestparam3")
    public String getRequestParam3(@RequestParam(value="id2", required=false, defaultValue="1") int id2,
                                   @RequestParam(value="code2", required=false, defaultValue="defaultCode") String code2, Model model) {
        model.addAttribute("id2", id2);
        model.addAttribute("code2", code2);
        return "methodparam";
    }

    @RequestMapping("/requestparam4")
    public String getRequestParam4(int id2, String code2, Model model) {
        model.addAttribute("id2", id2);
        model.addAttribute("code2", code2);
        return "methodparam";
    }

    @RequestMapping("/cookievalue")
    public String getCookieValue(@CookieValue("JSESSIONID") String jsessionid, Model model) {
        model.addAttribute("jsessionid", jsessionid);
        return "methodparam";
    }

    @RequestMapping("/requestheader")
    public String getRequestHeader(@RequestHeader("host") String host, @RequestHeader("accept") String accept, Model model) {
        model.addAttribute("host", host);
        model.addAttribute("accept", accept);
        return "methodparam";
    }

    @RequestMapping("/modelattr")
    public String getRequestHeader(@ModelAttribute UserSearch userSearch) {
        return "methodparam";
    }
}