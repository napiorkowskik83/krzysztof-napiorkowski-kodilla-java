package com.kodilla.testing.shape;

import org.junit.*;

import java.util.ArrayList;

import static java.lang.Math.PI;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }


    @Test
    public void testAddFigure() {
        //Given
        Square square1 = new Square(1.9);
        Circle circle1 = new Circle(3.4);
        Triangle triangle1 = new Triangle(2.3, 1.7, 2);

        ArrayList<Shape> testFiguresList = new ArrayList<Shape>();
        testFiguresList.add(square1);
        testFiguresList.add(circle1);
        testFiguresList.add(triangle1);

        ShapeCollector sc = new ShapeCollector();

        //When
        sc.addFigure(square1);
        sc.addFigure(circle1);
        sc.addFigure(triangle1);
        ArrayList<Shape> retrievedList = sc.showFigures();

        //Then
        Assert.assertEquals(testFiguresList, retrievedList);
    }

    @Test
    public void testRemoveFigureNotExisting() {
        //Given
        Square square1 = new Square(1.9);
        Circle circle1 = new Circle(3.4);
        Triangle triangle1 = new Triangle(2.3, 1.7, 2);
        Square square2 = new Square(2.7);

        ShapeCollector sc = new ShapeCollector();
        sc.addFigure(square1);
        sc.addFigure(circle1);
        sc.addFigure(triangle1);

        //When
        boolean result = sc.removeFigure(square2);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        Square square1 = new Square(1.9);
        Circle circle1 = new Circle(3.4);
        Triangle triangle1 = new Triangle(2.3, 1.7, 2);

        ArrayList<Shape> testFiguresList = new ArrayList<Shape>();
        testFiguresList.add(square1);
        testFiguresList.add(triangle1);

        ShapeCollector sc = new ShapeCollector();
        sc.addFigure(square1);
        sc.addFigure(circle1);
        sc.addFigure(triangle1);

        //When
        boolean result = sc.removeFigure(circle1);
        ArrayList<Shape> retrievedList = sc.showFigures();

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(testFiguresList, retrievedList);
    }

    @Test
    public void testGetFigure() {
        Square square1 = new Square(1.9);
        Circle circle1 = new Circle(3.4);
        Triangle triangle1 = new Triangle(2.3, 1.7, 2);


        ShapeCollector sc = new ShapeCollector();
        sc.addFigure(square1);
        sc.addFigure(circle1);
        sc.addFigure(triangle1);

        //When
        Shape retrievedFigure;
        retrievedFigure = sc.getFigure(2);

        //Then
        Assert.assertEquals(triangle1, retrievedFigure);
    }

    @Test

    public void testGetField() {
        //Given
        double testField = PI * 2.1 * 2.1;
        Circle circle1 = new Circle(2.1);

        //When
        double result = circle1.getField();

        //Then
        Assert.assertEquals(testField, result, 0);

    }
}
