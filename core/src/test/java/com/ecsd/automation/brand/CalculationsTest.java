package com.ecsd.automation.brand;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * @author olufemi on 2021-09-22
 */
public class CalculationsTest {

    private Calculations under_test = new Calculations();


    @Test
    public void test_getIndexOfBalancedArray_should_return_the_correct_index() {
        //GIVEN
        int[] testArray = {13, 40, 53, 80, 10, 20, 145, 13, 8};
        int length = testArray.length;

        //WHEN

        String indexOfBalancedArray = under_test.getIndexOfBalancedArray(length, testArray);


        //THEN
        Assert.assertEquals(indexOfBalancedArray, "4");

    }


    @Test
    public void test_getIndexOfBalancedArray_should_return_null_when_unblanaced() {
        //GIVEN
        int[] testArray = {1, 40, 53, 80, 10, 20, 145, 13, 8};
        int length = testArray.length;

        //WHEN

        String indexOfBalancedArray = under_test.getIndexOfBalancedArray(length, testArray);


        //THEN
        Assert.assertNull(indexOfBalancedArray);

    }
}
