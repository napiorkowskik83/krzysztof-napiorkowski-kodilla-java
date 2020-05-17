package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import static com.kodilla.stream.array.ArrayOperations.getAverage;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        //Given
        int[] numbers = {12, 31, 46, 9};

        //When
        double expectedAverage = 24.5;
        double averageByTestedMethod =  ArrayOperations.getAverage(numbers);

        //Then
        Assert.assertEquals(expectedAverage, averageByTestedMethod, 0);
    }
}
