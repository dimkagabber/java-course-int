package com.tieto.training;

import com.tieto.training.person.Person;

import java.util.Comparator;

public class ArrayHandlerWithComparable {

    public Person[] getMax(Person[] input, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Parameter n must be >= 0");
        }
        if (n == 0 || input == null || input.length == 0) {
            return new Person[0];
        }

        Person[] result = new Person[n];

        for (Person element : input) {
            addNextElementToResult(element, result);
        }

        result = removeNullsFromArray(result);

        return result;
    }

    private Person[] removeNullsFromArray(final Person[] array) {
        int targetSize = array.length;
        for (int i = 0; i < array.length -1 ; i++) {
            if (array[i] == null) {
                targetSize = i + 1;
                break;
            }
        }

        Person[] result = new Person[targetSize];
        System.arraycopy(array, 0, result, 0, targetSize);
        return result;
    }

    private void addNextElementToResult(final Person newElement, final Person[] result) {
        for (int i = 0; i < result.length; i++) {
            if (newElement == null){
                return;
            }
            if (result[i] == null){
                result[i] = newElement;
                return;
            }
            int comparisonResult = result[i].compareTo(newElement);
            if (comparisonResult == 0) {
                return;
            }
            if (comparisonResult < 0) {
                shiftArrayContent(result, i);
                result[i] = newElement;
                return;
            }
        }
    }

    private void shiftArrayContent(final Person[] result, final int startingPosition) {
        for (int i = result.length - 1; i > startingPosition; i--) {
            result[i] = result[i - 1];
        }
    }
}
