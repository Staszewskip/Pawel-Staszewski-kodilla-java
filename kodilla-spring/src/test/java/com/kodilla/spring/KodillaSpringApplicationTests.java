package com.kodilla.spring;

import com.kodilla.spring.shape.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class KodillaSpringApplicationTests {

    @Test
    void testCircleLoadedIntoContainer() {
//        given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape) context.getBean("circle");

//        when
        String name = shape.getShapeName();
//        then
        assertEquals("This is a circle", name);
    }


    @Test
    void testTriangleLoadedIntoContainer() {
//        given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape) context.getBean("triangle");

//        when
        String name = shape.getShapeName();

//        then
        assertEquals("This is a triangle", name);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testSquareLoadedIntoContainer() {
//        given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape) context.getBean("createSquare");

//        when
        String name = shape.getShapeName();
//        then
        assertEquals("This is a square", name);
    }

    @Test
    void testShapeLoadedIntoContainer() {
//        given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape) context.getBean("chosenShape");
//        when
        String name = shape.getShapeName();
//        then
        System.out.println("Chosen shape says: " + name);
    }
}
