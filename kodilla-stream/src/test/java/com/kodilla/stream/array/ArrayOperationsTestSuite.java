package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {
    @Test
    void testGetAverage(){
        //given
        int[] numbers = {2,10,15,20,30,33,18,24,50,60};
        //when
        double average = ArrayOperations.getAverage(numbers);
        double expectedAverage = 26.2;
        //then
        Assertions.assertEquals(expectedAverage, average);
    }
}
