package springbook.learningtest.spring.binding;

import org.junit.Test;
import org.springframework.beans.propertyeditors.CharsetEditor;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class ModelBindingTest {
    @Test
    public void charsetEditor() {
        CharsetEditor charsetEditor = new CharsetEditor();
        charsetEditor.setAsText("UTF-8");
        assertNotNull(charsetEditor.getValue());
        assertEquals(charsetEditor.getValue(), StandardCharsets.UTF_8);
    }
}