package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CollectionTestSuite {

    private static int testCounter = 0;

    @Before
    public void before() {
        testCounter++;
        System.out.println("Test no.: " + testCounter  + " starting");
    }

    @After
    public void after() {
        System.out.println("Test no.: " + testCounter + " finished");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        ArrayList<Integer> numbers = new ArrayList<>();
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> numbersNoOdds = exterminator.exterminate(numbers);
        //Then
        Assert.assertTrue(numbersNoOdds.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        ArrayList<Integer> numbers = new ArrayList<>();
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        //When
        numbers.add(2);
        numbers.add(4);
        numbers.add(5);
        ArrayList<Integer> numbersNoOdds = exterminator.exterminate(numbers);
        //Then
        Assert.assertTrue(numbersNoOdds.size() == 2);
    }

}
