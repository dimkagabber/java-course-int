package com.tieto.training;

import java.util.Comparator;

public class ArrayHandlerGeneric <T>{

    public T[] getMax(T[] input, int n, Comparator<T> comparator) {
        if (n < 0) {
            throw new IllegalArgumentException("Parameter n must be >= 0");
        }
        if (n == 0 || input == null || input.length == 0) {
            return (T[]) new Object[0];
        }

        T[] result = (T[]) new Object[n];

        for (T element : input) {
            addNextElementToResult(element, result, comparator);
        }

        result = removeNullsFromArray(result);

        return result;
    }

    private T[] removeNullsFromArray(final T[] array) {
        int targetSize = array.length;
        for (int i = 0; i < array.length -1 ; i++) {
            if (array[i] == null) {
                targetSize = i + 1;
                break;
            }
        }

        T[] result = (T[]) new Object[targetSize];
        System.arraycopy(array, 0, result, 0, targetSize);
        return result;
    }

    private void addNextElementToResult(final T newElement, final T[] result, Comparator<T> comparator) {
        for (int i = 0; i < result.length; i++) {
            if (newElement == null){
                return;
            }
            if (result[i] == null){
                result[i] = newElement;
                return;
            }
            int comparisonResult = comparator.compare(result[i],newElement);
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

    private void shiftArrayContent(final T[] result, final int startingPosition) {
        for (int i = result.length - 1; i > startingPosition; i--) {
            result[i] = result[i - 1];
        }
    }
}
