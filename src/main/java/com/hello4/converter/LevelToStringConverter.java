package com.hello4.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import springbook.learningtest.spring.user.domain.Level;

@Component
public class LevelToStringConverter implements Converter<Level, String> {
    @Override
    public String convert(Level level) {
        return String.valueOf(level.intValue());
    }
}