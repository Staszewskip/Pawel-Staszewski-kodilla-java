package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTestSuite {

    @Test
    void testAdd() {
//        given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
//        when
        double result = calculator.add(2,1);
//        then
       assertEquals(3, result);
    }

    @Test
    void sub() {
        //        given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
//        when
        double result = calculator.sub(10,8);
//        then
        assertEquals(2, result);
    }

    @Test
    void mul() {
        //        given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
//        when
        double result = calculator.mul(20,1);
//        then
        assertEquals(20, result);
    }

    @Test
    void div() {
        //        given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
//        when
        double result = calculator.div(25,5);
//        then
        assertEquals(5, result);
    }
}