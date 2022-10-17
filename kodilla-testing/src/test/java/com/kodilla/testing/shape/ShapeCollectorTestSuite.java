package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("ShapeCollector Test Suite")
public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for adding/removing figures")
    class AddRemoveTest {
        @Test
        void testAddFigure() {
            //    given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square shape = new Square(4.0);
            Circle shape2 = new Circle(2.0);
            //    when
            shapeCollector.addFigure(shape);
            shapeCollector.addFigure(shape2);
            //    then
            Assertions.assertEquals(shape, shapeCollector.getFigure(0));
            Assertions.assertEquals(shape2, shapeCollector.getFigure(1));
        }

        @Test
        void testRemoveFigure() {
            //    given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square shape = new Square(4.0);
            Triangle shape2 = new Triangle(4.0, 1.5);
            shapeCollector.addFigure(shape);
            shapeCollector.addFigure(shape2);
            //    when
            boolean result = shapeCollector.removeFigure(shape);
            boolean result2 = shapeCollector.removeFigure(shape2);
            //    then
            assertTrue(result);
            assertTrue(result2);
        }
    }

    @Nested
    @DisplayName("Tests for getting/showing figures")
    class GetShowFigure {
        @Test
        void testGetFigure() {
            //    given
            ShapeCollector shapeList = new ShapeCollector();
            Square shape = new Square(4.0);
            Circle circle = new Circle(4.0);
            shapeList.addFigure(shape);
            shapeList.addFigure(circle);
            //    when
            Shape result = shapeList.getFigure(0);
            Shape result2 = shapeList.getFigure(1);
            //    then
            assertEquals(shape, result);
            assertEquals(circle, result2);
        }

        @Test
        void testShowFigures() {
//            given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square shape = new Square(4.0);
            Circle shape2 = new Circle(3.0);
            shapeCollector.addFigure(shape);
            shapeCollector.addFigure(shape2);
            List<Shape> listOfShapes = new ArrayList<>();
            listOfShapes.add(shape);
            listOfShapes.add(shape2);
            //When
            List<Shape> resultList = shapeCollector.showFigures();
            //Then
            assertEquals(listOfShapes.toString(), resultList.toString());
        }
    }
}



