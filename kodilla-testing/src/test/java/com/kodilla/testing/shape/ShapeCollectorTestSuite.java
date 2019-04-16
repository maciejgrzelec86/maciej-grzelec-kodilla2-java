package com.kodilla.testing.shape;

import org.junit.*;

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
        ShapeCollector shapeCollector = new ShapeCollector();

        //When
        shapeCollector.addFigure(new Circle());

        //Then
        Assert.assertEquals(1, shapeCollector.getShapeListSize());
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle();

        //When
        shapeCollector.addFigure(circle);
        shapeCollector.removeFigure(circle);

        //Then
        Assert.assertEquals(0, shapeCollector.getShapeListSize());
    }

    @Test
    public void testRemoveFigure2() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle();

        //When
        shapeCollector.addFigure(circle);
        boolean result = shapeCollector.removeFigure(circle);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getShapeListSize());
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();

        //When
        Circle circle = new Circle();
        shapeCollector.addFigure(circle);
        Shape testShape = shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(circle, testShape);
    }
}

