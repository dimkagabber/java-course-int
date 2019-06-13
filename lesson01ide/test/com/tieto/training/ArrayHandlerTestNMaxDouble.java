package com.tieto.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class ArrayHandlerTestNMaxDouble {

    private ArrayHandler arrayHandler;

    @BeforeEach
    void setUp() {
        arrayHandler = new ArrayHandler();
    }

//-----------------------------------
    //tests for: double[] getMax(double[], int)
    //-----------------------------------

    @Test
    @DisplayName("double getMax(double[],int) basic scenario")
    void testGetMaxNBasicScenario(){
        //•	Basic scenario / all positive
        double[] input = {8.,7.,9.,2.,5.,4.};
        double[] result = {9.,8.,7.};
        assertArrayEquals(result, arrayHandler.getMax(input,3));
    }

    @Test
    void testGetMaxNNegative(){
        //•	All elements negative
        double[] input = {-9.,-7.,-8.,-2.,-5.,-4.};
        double[] result = {-2.,-4.,-5.};
        assertArrayEquals(result, arrayHandler.getMax(input,3));
    }

    @Test
    void testGetMaxNIncludesSeveralDoublicatesOfOneValue(){
        //Some elements the same
        double[] input = {9.,8.,8.,10.,8.,4.};
        double[] result = {10.,9.,8.};
        assertArrayEquals(result, arrayHandler.getMax(input,3));
    }

    @Test
    void testGetMaxNIncludesSeveralDoublicatesOfSeveralValues(){
        //•	Various duplicate elements
        double[] input = {4.,4.,9.,9.,4.,8.,9.,8.,8.,10.,8.,4.,9.};
        double[] result = {10.,9.,8.};
        assertArrayEquals(result, arrayHandler.getMax(input,3));
    }

    @Test
    void testGetMaxNBiggestAtTheBeginning(){
        //•	The biggest element at the beginning
        double[] input = {11.,1.,3.,10.,8.,4.};
        double[] result = {11.,10.,8.};
        assertArrayEquals(result, arrayHandler.getMax(input,3));
    }

    @Test
    void testGetMaxNBiggestAtTheEnd(){
        //•	The biggest element at the end
        double[] input = {1.,3.,10.,8.,4.,11.};
        double[] result = {11.,10.,8.};
        assertArrayEquals(result, arrayHandler.getMax(input,3));
    }

    @Test
    void testGetMaxNNotEnoughElelementsInInput(){
        //•	Not enough elements in the input array
        double[] input = {1.,3.,10.};
        double[] result = {10.,3.,1.};
        assertArrayEquals(result, arrayHandler.getMax(input,5));
    }

    @Test
    void testGetMaxNNotEnoughDifferentElelementsInInput(){
        //•	Not enough different elements in the input array
        double[] input = {1.,1.,10.,2.,10.,1.,2.};
        double[] result = {10.,2.,1.};
        assertArrayEquals(result, arrayHandler.getMax(input,5));
    }

    @Test
    void testGetMaxNEmptyInput(){
        //•	Empty array
        double[] input = {};
        double[] result = {};
        assertArrayEquals(result, arrayHandler.getMax(input,5));
    }

    @Test
    void testGetMaxNNullInput(){
        //•	null array
        double[] input = null;
//        double[] result = null;
        double[] result = {};
        assertArrayEquals(result, arrayHandler.getMax(input,5));
    }

    @Test
    void testGetMaxNNIsNegative(){
        //•	n is negative
        double[] input = {1.,2.,3.,4.,5.};
        final Exception ex = assertThrows(IllegalArgumentException.class,
                () -> {
                    arrayHandler.getMax(input,-5);
                });
        assertEquals("Parameter n must be >= 0", ex.getMessage());
    }

    @Test
    void testGetMaxNIsZero(){
        //•	n is 0
        double[] input = {1.,2.,3.,4.,5.};
        double[] result = {};
        assertArrayEquals(result, arrayHandler.getMax(input,0));
    }

    @Test
    @DisplayName("parseDoubles() only numbers")
    void testParseDoublesCorrect() {
        //entered data contains only numbers
        String[] args = {"1","2","3","4"};
        double[] array = {1,2,3,4};
        assertArrayEquals(array, arrayHandler.parseDoubles(args));
    }

    @Test
    @DisplayName("parseDoubles() chars entered")
    void testParseDoublesEnteredChar() {
        //entered data contains chars
        String[] args = {"1","2","three","4"};
        final Exception ex = assertThrows(ArithmeticException.class,
                () -> {
                    arrayHandler.parseDoubles(args);
                });
        assertEquals("Not all entered values are doubles", ex.getMessage());
    }
}