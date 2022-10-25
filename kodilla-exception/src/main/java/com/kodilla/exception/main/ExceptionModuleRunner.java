package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;

public class ExceptionModuleRunner {
    public static void main(String[] args) {
        FileReader filereader = new FileReader();
        filereader.readFile();
    }

}
