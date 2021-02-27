package com.user.controller;

import com.hello.entity.User;
import com.user.entity.Result;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String openLogin() {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value="/checkloginid/{loginId}", method = RequestMethod.GET)
    public Result checklogin(@PathVariable String loginId) {
        Result result = new Result();

        if(userService.isRegisteredLoginId(loginId)) {
            result.setDuplicated(true);
            result.setAvailableId(loginId + (int)(Math.random()*1000));
        }
        else {
            result.setDuplicated(false);
        }

        return result;
    }

    @RequestMapping("/postlogin")
    public String openPostLogin() {
        return "postlogin";
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    @ResponseBody
    public User registerPost(@RequestBody User user) {
        System.out.println(user.getId());
        System.out.println(user.getPassword());
        System.out.println(user.getName());
        return user;
    }
}