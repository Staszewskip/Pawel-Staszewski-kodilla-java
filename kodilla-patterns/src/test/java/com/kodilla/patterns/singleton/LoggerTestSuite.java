package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class  LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void createLog() {
        logger = Logger.INSTANCE;
        logger.log("last log");
    }

    @Test
    void testGetLastLog() {
        //When
        String lastLog = logger.getLastLog();

        //Then
        assertEquals("last log", lastLog);
    }
}