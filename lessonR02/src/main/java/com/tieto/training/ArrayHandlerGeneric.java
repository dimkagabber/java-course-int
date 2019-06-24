package com.tieto.training;

import com.tieto.training.person.Person;
import jdk.jfr.Percentage;

import java.lang.reflect.Array;
import java.util.Comparator;

import static java.util.Comparator.*;

public class ArrayHandlerGeneric {

    public <T extends Comparable<T>> T[] getMax(T[] input, int n) {
        Comparator<T> naturalOrder = Comparator.naturalOrder();
        return getMax(input, n, naturalOrder);
    }

    public <T> T[] getMax(T[] input, int n, Comparator<T> comparator) {
        if (n < 0) {
            throw new IllegalArgumentException("Parameter n must be >= 0");
        }
        if (input == null) {
            return null;
        }

        Class<?> arrayType = input.getClass().getComponentType();
        if (n == 0 || input.length == 0) {
            return createNewArray(arrayType, 0);
        }
        T[] result = createNewArray(arrayType, n);

        for (T element : input) {
            addNextElementToResult(element, result, comparator);
        }

        result = removeNullsFromArray(result);

        return result;
    }

    private <T> T[] createNewArray(final Class<?> arrayType, final int i) {
        return (T[]) Array.newInstance(arrayType, i);
    }

    private <T> T[] removeNullsFromArray(final T[] array) {
        int targetSize = array.length;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                targetSize = i;
                break;
            }
        }

        Class<?> arrayType = array.getClass().getComponentType();
        T[] result = createNewArray(arrayType, targetSize);
        System.arraycopy(array, 0, result, 0, targetSize);
        return result;
    }

    private <T> void addNextElementToResult(final T newElement, final T[] result, Comparator<T> comparator) {
        for (int i = 0; i < result.length; i++) {
            if (newElement == null) {
                return;
            }
            if (result[i] == null) {
                result[i] = newElement;
                return;
            }
            int comparisonResult = comparator.compare(result[i], newElement);
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

    private <T> void shiftArrayContent(final T[] result, final int startingPosition) {
        for (int i = result.length - 1; i > startingPosition; i--) {
            result[i] = result[i - 1];
        }
    }
}
