package springbook.learningtest.spring.web.controllers;

import java.util.Map;

public interface CustomSimpleController {
    void control(Map<String, String> params, Map<String, Object> model);
}