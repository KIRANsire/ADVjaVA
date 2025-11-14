package com.example.tags;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Simple custom tag that prints "Hello, {name}!"
 */
public class GreetTag extends SimpleTagSupport {
    private String name;          // attribute

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (name == null || name.trim().isEmpty()) {
            out.print("Hello, guest!");
        } else {
            out.print("Hello, " + name + "!");
        }
    }
}