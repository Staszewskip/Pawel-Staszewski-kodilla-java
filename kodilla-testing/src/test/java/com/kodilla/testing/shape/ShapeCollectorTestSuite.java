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
//        tworzę obiekt klasy ShapeCollector
            ShapeCollector shapeCollector = new ShapeCollector();
//        tworzę obiekt klasy Square i deklaruję długość boku potrzebną do policzenia pola
            Square shape = new Square(4.0);
//    when
//   metoda addFigure będzie zawierać dodawanie elementu shape do listy
            shapeCollector.addFigure(shape);
//    then
//        sprawdzam czy utworzony obiekt shape jest tym samym co dodany obiekt do listy
            Assertions.assertEquals(shape, shapeCollector.getFigure(0));
//drugi test z inną figurą
            //    given
            //        tworzę obiekt klasy Circle i deklaruję promień koła potrzebny do policzenia pola
            Circle shape2 = new Circle(2.0);
//    when
//   metoda addFigure będzie zawierać dodawanie elementu shape do listy
            shapeCollector.addFigure(shape2);
//    then
//        sprawdzam czy utworzony obiekt shape jest tym samym co dodany obiekt do listy
            Assertions.assertEquals(shape2, shapeCollector.getFigure(1));
        }


        @Test
        void testRemoveFigure() {
            //    given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square shape = new Square(4.0);
            shapeCollector.addFigure(shape);
//    when
//    metoda removeFigure będzie zawierać usuwanie elementu shape z listy
            boolean result = shapeCollector.removeFigure(shape);
//    then
//        sprawdzam czy wykonało się usunięcie
            assertTrue(result);

//      drugi test z inna figurą
            //    given
            Triangle shape2 = new Triangle(4.0, 1.5);
            shapeCollector.addFigure(shape2);
            //    when
//    metoda removeFigure będzie zawierać usuwanie elementu shape z listy
            boolean result2 = shapeCollector.removeFigure(shape2);
            //    then
//        sprawdzam czy wykonało się usunięcie
            assertTrue(result2);
        }
    }

    @Nested
    @DisplayName("Tests for getting/showing figures")
    class GetShowFigure {
        void testGetFigure(int n) {
//            given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square shape = new Square(4.0);
            shapeCollector.addFigure(shape);
//            when
            Shape result = shapeCollector.getFigure(0);
//            then
//        sprawdzam czy utworzony obiekt shape jest tym samym co dodany obiekt do listy
            assertEquals(shape, result);
//            given

            Circle shape2 = new Circle(4.0);
            shapeCollector.addFigure(shape2);
//            when
            Shape result2 = shapeCollector.getFigure(1);
//            then
//        sprawdzam czy utworzony obiekt shape jest tym samym co dodany obiekt do listy
            assertEquals(shape2, result2);

        }

        void testShowFigures() {
//            given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square shape = new Square(4.0);
            shapeCollector.addFigure(shape);
            List<Shape> shapeList = new ArrayList<>();
            shapeList.add(shape);
            //When
//            metoda showFigures będzie zwracać listę typu Shape
            List<Shape> resultList = shapeCollector.showFigures();
            //Then
//            sprawdzam czy utworzona lista w sekcji given (w formie Stringa) jest tą samą listą z metody showFigures
            assertEquals(shapeList.toString(), resultList.toString());
        }
    }

}

