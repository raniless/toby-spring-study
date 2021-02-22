package com.hello4.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import springbook.learningtest.spring.user.domain.Level;

@Component
public class StringToLevelConverter implements Converter<String, Level> {
    @Override
    public Level convert(String text) {
        return Level.valueOf(Integer.parseInt(text));
    }
}