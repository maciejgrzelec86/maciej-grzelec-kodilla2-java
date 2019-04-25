package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int integers[] = new int[5];
        integers[0] = 1;
        integers[1] = 2;
        integers[2] = 3;
        integers[3] = 4;
        integers[4] = 5;
        //When
        double testResult = ArrayOperations.getAverage(integers);
        //Then
        Assert.assertEquals(testResult, 3, 0);
    }
}
