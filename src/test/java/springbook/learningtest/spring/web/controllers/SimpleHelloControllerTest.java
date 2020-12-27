package springbook.learningtest.spring.web.controllers;

import org.junit.Test;
import springbook.learningtest.spring.web.SimpleHelloController;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SimpleHelloControllerTest {
    @Test
    public void controllerTest() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("name", "Spring");
        Map<String, Object> model = new HashMap<>();

        new SimpleHelloController().control(params, model);

        assertEquals("Hello Spring", (String) model.get("message"));
    }
}
