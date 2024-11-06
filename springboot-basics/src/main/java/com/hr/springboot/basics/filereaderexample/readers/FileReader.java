package com.hr.springboot.basics.filereaderexample.readers;

public interface FileReader {

    String readFile(final String filePath);
    String getType();
}
