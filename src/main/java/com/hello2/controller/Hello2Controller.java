package com.hello2.controller;

import com.common.exception.NotInServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@Controller
public class Hello2Controller {
    @RequestMapping("/hello2")
    public void hello2() {
        throw new QueryTimeoutException("Query Timeout!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @RequestMapping("/hello2/responseStatus")
    public void hello2ResponseStatus() {
        throw new NotInServiceException();

    }

    @RequestMapping("/hello2/simpleMappingException")
    public void hello2SimpleMappingException() {
        throw new IllegalArgumentException();

    }

    @RequestMapping("/hello2/simpleMappingException2")
    public void hello2SimpleMappingException2() {
        throw new NoSuchElementException();

    }
    @ExceptionHandler(DataAccessException.class)
    public ModelAndView dataAccessException(DataAccessException ex) {
        return new ModelAndView("dataException").addObject("msg", ex.getMessage());
    }

    //Controller 내에 선언된게 우선으로 적용된다.
    @ExceptionHandler(NotInServiceException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Controller Inner Bad Request!!!")
    public void notInServiceException(NotInServiceException ex) {
        System.out.println("하하하하하하하하하하하하하");
    }
}