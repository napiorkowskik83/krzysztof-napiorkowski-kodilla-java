package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.Assert;
import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {

    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        ArrayList<Integer> emptyList = new ArrayList<Integer>();
        ArrayList<Integer> emptyEvensList = new ArrayList<Integer>();

        OddNumbersExterminator ext = new OddNumbersExterminator();
        //When
        ArrayList<Integer> result = ext.exterminate(emptyList);
        System.out.println("Testing with " + emptyList +
                " as a 'exterminate' method argument");
        //Then
        Assert.assertEquals(emptyEvensList, result);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given

        Integer[] numbersArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> numbersList = new ArrayList<Integer>();
        for (Integer number : numbersArray) {
            numbersList.add(number);
        }
        Integer[] evensArray = {2, 4, 6, 8, 10};
        ArrayList<Integer> evensList = new ArrayList<Integer>();
        for (Integer number : evensArray) {
            evensList.add(number);
        }
        OddNumbersExterminator ext = new OddNumbersExterminator();
        //When
        ArrayList<Integer> result = ext.exterminate(numbersList);
        System.out.println("Testing with " + numbersList +
                " as a 'exterminate' method argument");
        //Then
        Assert.assertEquals(evensList, result);
    }
}
