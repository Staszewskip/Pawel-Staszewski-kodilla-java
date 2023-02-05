package com.kodilla.testing.collection;


import org.junit.jupiter.api.*;

import java.util.*;

public class CollectionTestSuite {
        @BeforeEach
        public void before() {
            System.out.println("Test Case: begin");
        }

        @AfterEach
        public void after() {
            System.out.println("Test Case: end");
        }

        @BeforeAll
        public static void beforeAll() {
            System.out.println("Test Suite: begin");
        }

        @AfterAll
        public static void afterAll() {
            System.out.println("Test Suite: end");
        }
@DisplayName(
        "when the list is empty" + ",then if the class works properly"
)
    @Test
    void testCaseOddNumbersExterminatorEmptyList(){
//            given

            List<Integer> emptyList = new ArrayList<>();
//            when
    OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

    List<Integer> listNumbers =  oddNumbersExterminator.exterminate(emptyList);
    System.out.println("Testing " + listNumbers);
    //Then
    Assertions.assertEquals(emptyList,listNumbers);}
    @DisplayName(
            "when the list is filled by numbers from 0 to 49" + ",then if the class works properly"
    )
    @Test
    void testCaseOddNumbersExterminatorNormalList() {
//            given
        ArrayList<Integer> normalList = new ArrayList<>();
//        when
       for (int i = 0; i<50; i++) {
           normalList.add(i);
       }
       OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
      List<Integer> filledList = oddNumbersExterminator.exterminate(normalList);
        ArrayList<Integer> expectedList = new ArrayList<>();
        for (int i = 0; i<50; i = i+2) {
            expectedList.add(i);
        }
       System.out.println("Testing " + filledList);
//       then
        Assertions.assertEquals(expectedList, filledList);
    }
    @DisplayName("testing Arrays.asList")
    @Test
    void testCaseOddNumbersExterminatorArrayasList(){
//            given
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(123,421,44,999,14,125,33,50));
        ArrayList<Integer> evenList = new ArrayList<Integer>(Arrays.asList(44,14,50));
//        when
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> listNumbers = oddNumbersExterminator.exterminate(list);
        System.out.println("Even " + listNumbers);
//        then
        Assertions.assertEquals(evenList,listNumbers);
    }

}

