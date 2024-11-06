package com.hr.springboot.basics.filereaderexample.readers;

import org.springframework.stereotype.Component;

@Component
public class HTMLReader implements FileReader{

    @Override
    public String readFile(String filePath) {
        return "HTML-Content";
    }

    @Override
    public String getType() {
        return "html";
    }
}
