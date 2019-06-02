package com.tieto.training;

import java.util.Arrays;

public class ArrayHandler {

//	int: 0 = equal; -1 = a less then b; 1 = a bigger then b;

    final int FIRST_BIGGER = 1;
    final int EQUAL = 0;
    final int SECOND_BIGGER = -1;

    private int numberOfResults = 0;

    // LESSON#3 BEGIN //

    public String[] getMax(String[] input, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Parameter n must be >= 0");
        }
        if (n == 0 || input == null) {
            return new String[0];
        }

        String[] result = new String[n];

        initializeResultWithEmpties(result);

        int comparisonResult;
        result[0] = input[0];
        numberOfResults = 1;
        for (int i = 1; i < input.length; i++) {

            if(input[i] == null){
                continue;
            }

            comparisonResult = compareStrings(input[i], result[numberOfResults-1]);
            //ignore if equal
            if(comparisonResult == EQUAL){
                continue;
            }
            // given element is less than existing - add to result
            // ignore if there are already enough results
            if(comparisonResult == SECOND_BIGGER && numberOfResults < n){
               result[numberOfResults] = input[i];
                numberOfResults++;
            }
            // given element is bigger than existing - find place for him and insert
            else if(comparisonResult == FIRST_BIGGER){
                addNewElementToResults(result,input[i]);
            }
        }

        if(numberOfResults < n){
            result = shrinkArray(result,numberOfResults);
        }

        return result;
    }

    private String[] shrinkArray(String[] source, int length) {
        String[] target = new String[length];
        for (int i = 0; i < length; i++) {
            target[i] = source[i];
        }
        return target;
    }

    private void initializeResultWithEmpties(String[] result) {
        for (int i = 0; i < result.length; i++) {
            result[i]="";
        }
    }

    public void addNewElementToResults(String[] result, String element) {
        int comparisonResult;
        for (int i = 0; i < result.length; i++) {
            comparisonResult = compareStrings(element, result[i]);
            if(comparisonResult == EQUAL){
                break;
            }
            //given element is bigger than existing - a place to insert
            if(comparisonResult == FIRST_BIGGER){
                shiftArrayElementsForward(result,i);
                result[i] = element;
                numberOfResults++;
                break;
            }
        }
    }

    public void shiftArrayElementsForward(String[] result, int targetPosition){
        for (int i = result.length - 1; i > targetPosition; i--) {
            result[i] = result[i-1];
        }
    }

    //compare two elements and return the one which is bigger
    public int compareStrings(String a, String b){

        if(a == null) {
            return SECOND_BIGGER;
        }
        else if(b == null){
            return FIRST_BIGGER;
        }

        if(a.equals(b)){
            return EQUAL;
        }

        int comparisonResult;
        int a_length = a.length();
        int b_length = b.length();

        int comparisonLength = Integer.min(a_length, b_length);
        for (int i = 0; i < comparisonLength; i++) {
            if(a.charAt(i) == b.charAt(i)){
                continue;
            }
            if(a.charAt(i) > b.charAt(i)){
                return FIRST_BIGGER;
            }
            else if(a.charAt(i) < b.charAt(i)){
                return SECOND_BIGGER;
            }
        }

        return Integer.compare(a_length, b_length);
    }

    // LESSON#3 END //


    //returns maximum value from an array of doubles
    public double getMax(double[] input) {
        //check if any data available
        if (input.length == 0) throw new Error("No data entered");
        //first value - first maximum
        double result = input[0];
        //go through elements and compare each next with the previous maximum
        for (int i = 1; i < input.length; i++) {
            if (input[i] > result) {
                result = input[i];
            }
        }
        return result;
    }

    public double[] getMax(double[] input, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Parameter n must be >= 0");
        }

        if (input == null || n == 0 || input.length == 0) {
            return new double[0];
        }

        final double[] result = new double[n];
        initWithNaNs(result);

        for (double nextElement: input) {
            processNextElement(result, nextElement);
        }

        shortenArrayNaNs(result);

        return result;
    }

    private void shortenArrayNaNs(double[] array) {
        for (int i = 0; i < array.length; i++) {
            if(Double.isNaN(array[i])){
                ;
            }
        }
    }

    private void processNextElement(double[] array, double element) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == element) {
                return;
            }

            if(Double.isNaN(array[i])){
                insertNewElement(array, element, i);
                return;
            }

            else if(array[i] < element){
                insertNewElement(array, element, i);
                return;
            }

            else if(array[i] > element) {
                continue;
            }
        }
    }

    private void insertNewElement(double[] array, double element, int startingPos) {
        if(!Double.isNaN(array[startingPos])){
            shiftArrayElementsForward(array, startingPos);
        }

        array[startingPos] = element;
    }

    private void shiftArrayElementsForward(double[] array, int startingPos) {

        for (int i = array.length - 1; i > startingPos; i--) {
            array[i] = array[i-1];
        }
    }

    private void initWithNaNs(double[] array) {
        for(double element: array){
            element = Double.NaN;
        }
    }






    //returns n maximum values from an array of doubles
    public double[] getMaxOld(double[] input, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Parameter n must be >= 0");
        }

        if(input == null){
            return new double[0];
        }

        if(n == 0) {
            return new double[0];
        }

        if(input.length == 0) {
            return new double[0];
        }

        //position in input array
        int i = 0;
        //res array count of elements
        int j = 0;

        double[] result = new double[n];
        result[j] = input[i];

        //prepare n max values for comparison
        for (i = 1; i < input.length; i++) {
            if (j >= n-1) break;
            //new element is less then last -> add
            else if(result[j] > input[i]) {
                result[++j] = input[i];
            }
            //new element is bigger then last -> swipe until it is the first one or there is another one bigger
            else if(result[j] < input[i]) {
                //swipe
                result[j+1] = result[j];
                result[j] = input[i];
                //swipe more
                for (int k = j; k > 0; k--) {
                    if (result[k] > result[k - 1]) {
                        double buffer = result[k - 1];
                        result[k - 1] = result[k];
                        result[k] = buffer;
                    }
                    else {
                        // equal of bigger? -> enough swiping
                        break;
                    }
                }
                j++;
            }
        }

        //go through the rest of the values
        for (;i < input.length; i++) {
            //new element is less then last -> ignore
            if(result[j] >= input[i]) {
                // do nothing (temp)
            }

            //new element is bigger then last -> swipe until it is the first one of there is another one bigger
            else if(result[j] < input[i]) {
                //save the last value just in case
                double tmp[] = result.clone();

                //rewrite last element (prons an issue if list already has the same value but it isn't the last one
                result[j] = input[i];

                //swipe more
                for (int k = j; k > 0; k--) {
                    if (result[k] > result[k - 1]) {
                        double buffer = result[k -1];
                        result[k - 1] = result[k];
                        result[k] = buffer;
                    }
                    else if (result[k] == result[k - 1]) {
                        // temp, later change to recover of the array as it'd contain two duplicated values
                        result = tmp;
                        break;
                    }
                    else {
                        // previous element bigger? -> enough swiping
                        break;
                    }
                }
            }
        }

        return result;

        /*
        // the algorithm with recursion
        double[] result = new double[n];
        result[0] = input[0];

        for (int i = 1; i < input.length; i++) {
            for (int j = result.length; j >= 0 ; j--) {
                compareElements(result[j],input[i]);

            }



                result = processInputElement(result, input[i]);
        }
        return result;



/*
        int compResult;
        for (i = 1; i < input.length; i++) {
            compResult = Double.compare(result[j], input[i]);


            // next element is bigger then previous -> swipe until a bigger found / already the first element
            else if (compResult < 0) {
                for (j = result.length; j > 0; j--) {
                    result[j] = result[j];
                    result[j] = input[i];
                    j++;
                    compResult = Double.compare(result[j], input[i]);

                }

            }



            // next element is less then previous -> add as a next value
            else if (comparison > 0) {
                j++;
                result[j] = input[i];
            }
            // next element is equal to existing -> do nothing
        } */

    }

    public double[] parseDoubles(String[] args) {
        return parseDoubles(args,0);
    }

    public double[] parseDoubles(String[] args, int start_position) {
        double[] result = new double[args.length];
        for (int i = start_position; i < args.length; i++) {
            try {
                result[i] = Double.parseDouble(args[i]);
            } catch (Exception e) {
                throw new ArithmeticException("Not all entered values are doubles");
            }
        }
        return result;
    }

    public int parseFirstInt(String[] args) {
        int n;
        try {
            n = Integer.parseInt(args[0]);
            } catch (Exception e) {
                throw new ArithmeticException("First value is not integer");
            }
            return n;
        }
}
