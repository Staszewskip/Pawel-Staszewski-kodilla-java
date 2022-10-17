package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

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
        void testGetFigure(int n) {
            //    given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(4.0);
            Shape shape2 = new Circle(4.0);
            shapeCollector.addFigure(shape);
            shapeCollector.addFigure(shape2);
            //    when
            Shape result = shapeCollector.getFigure(0);
            Shape result2 = shapeCollector.getFigure(1);
            //    then
            assertEquals(shape, result);
//            assertEquals(shape2, result2);
        }
        @Test
        void testShowFigures() {
        //   given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(4.0);
            Shape circle = new Circle(4.0);
            Shape triangle = new Triangle(4.0, 2.0);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);

            //When
        //   metoda showFigures będzie zwracać listę typu Shape
            List<Shape> resultList = shapeCollector.showFigures();
            //Then
        //   sprawdzam czy utworzona lista w sekcji given (w formie Stringa) jest tą samą listą z metody showFigures
            assertEquals("squarecircletriangle", resultList.getFigure().toString());
        }
    }
}

