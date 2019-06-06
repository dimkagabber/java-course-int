package com.tieto.training;

import com.tieto.training.person.Person;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class ArrayHandler {

// Q: How to select method with specific signature when using generic type?

    final static int FIRST_BIGGER = 1;
    final static int EQUAL = 0;
    final static int SECOND_BIGGER = -1;

    // PERSON HANDLER START //
    public Person[] getMax(Person[] input, int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Parameter n must be >= 0");
        }
        if (n == 0 || input == null || input.length == 0) {
            return new Person[0];
        }

        return new Person[0];
    }


    // PERSON HANDLER FINISH //
































    // STRING HANDLER START //
    @NotNull
    public String[] getMax(String[] input, int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Parameter n must be >= 0");
        }
        if (n == 0 || input == null || input.length == 0) {
            return new String[0];
        }

        String[] result = createEmptyArrayStrings(n);

        for(String element: input){
            processGivenElement(element, result);
        }

        return result = shrinkArray(result, findFirstEmptyArrayPosition(result));
    }

    private void processGivenElement(String elementGiven, String[] result) {
        if(elementGiven == null){
              return;
        }

        for (int i = 0; i < result.length; i++) {
            int comparisonResult = compareElements(elementGiven, result[i]);
            if(comparisonResult == EQUAL){
                break;
            }
            if (comparisonResult == FIRST_BIGGER) {
                shiftArrayElementsForward(result,i);
                result[i] = elementGiven;
                break;
            }
        }
    }

    private String[] shrinkArray(String[] source, int length) {
        String[] target = new String[length];
        System.arraycopy(source,0,target,0,length);
        return target;
    }

    private int findFirstEmptyArrayPosition(String[] result) {
        for (int i = 0; i < result.length; i++) {
            if (result[i].isEmpty()){
                return i;
            }
        }
        return result.length;
    }

    private String[] createEmptyArrayStrings(int n) {
        final String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = "";
        }
        return array;
    }

    public void shiftArrayElementsForward(String[] result, int targetPosition){
        for (int i = result.length - 1; i > targetPosition; i--) {
            result[i] = result[i-1];
        }
    }

    public int compareElements(String a, String b){

        if(a == null) {
            return SECOND_BIGGER;
        }
        else if(b == null){
            return FIRST_BIGGER;
        }

        if(a.equals(b)){
            return EQUAL;
        }

        int comparisonLength = Integer.min(a.length(),b.length());
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
        return Integer.compare(a.length(),b.length());
    }

    // DOUBLE HANDLER FINISH //

    // DOUBLE HANDLER START //
    public double[] getMax(double[] input, int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Parameter n must be >= 0");
        }
        if (n == 0 || input == null || input.length == 0) {
            return new double[0];
        }

        double[] result = createEmptyArrayDoubles(n);

        for(double element: input){
            processGivenElement(element, result);
        }

        return result = shrinkArray(result, findFirstEmptyArrayPosition(result));
    }

    private void processGivenElement(double elementGiven, double[] result) {
        if(Double.isNaN(elementGiven)){
            return;
        }

        for (int i = 0; i < result.length; i++) {
            int comparisonResult = compareElements(elementGiven, result[i]);
            if(comparisonResult == EQUAL){
                break;
            }
            if (comparisonResult == FIRST_BIGGER || Double.isNaN(result[i])) {
                shiftArrayElementsForward(result,i);
                result[i] = elementGiven;
                break;
            }
        }
    }

    private double[] shrinkArray(double[] source, int length) {
        double[] target = new double[length];
        System.arraycopy(source,0,target,0,length);
        return target;
    }

    private int findFirstEmptyArrayPosition(double[] result) {
        for (int i = 0; i < result.length; i++) {
            if (Double.isNaN(result[i])){
                return i;
            }
        }
        return result.length;
    }

    private double[] createEmptyArrayDoubles(int n) {
        final double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = Double.NaN;
        }
        return array;
    }

    public void shiftArrayElementsForward(double[] result, int targetPosition){
        for (int i = result.length - 1; i > targetPosition; i--) {
            result[i] = result[i-1];
        }
    }

    public int compareElements(double a, double b) {

        return Double.compare(a, b);
    }
    // DOUBLE HANDLER FINISH //

    // input processing

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
}
