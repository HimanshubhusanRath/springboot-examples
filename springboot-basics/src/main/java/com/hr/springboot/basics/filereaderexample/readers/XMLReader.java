package com.hr.springboot.basics.filereaderexample.readers;

import org.springframework.stereotype.Component;

@Component
public class XMLReader implements FileReader{

    @Override
    public String readFile(String filePath) {
        return "XML-Content";
    }

    @Override
    public String getType() {
        return "xml";
    }
}
