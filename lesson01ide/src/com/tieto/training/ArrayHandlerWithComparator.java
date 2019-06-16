package com.tieto.training;

import com.tieto.training.person.Address;
import com.tieto.training.person.Gender;
import com.tieto.training.person.Person;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class ArrayHandlerWithComparator {

    public Person[] getMax(Person[] input, int n, Comparator<Person> comparator) {
        if (n < 0) {
            throw new IllegalArgumentException("Parameter n must be >= 0");
        }
        if (n == 0 || input == null || input.length == 0) {
            return new Person[0];
        }

        Person[] result = new Person[n];

        for (Person element : input) {
            addNextElementToResult(element, result, comparator);
        }

        result = removeNullsFromArray(result);

        return result;
    }

    private Person[] removeNullsFromArray(final Person[] array) {
        int targetSize = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == null) {
                targetSize = i + 1;
                break;
            }
        }

        Person[] result = new Person[targetSize];
        System.arraycopy(array, 0, result, 0, targetSize);
        return result;
    }

    private void addNextElementToResult(final Person newElement, final Person[] result, Comparator<Person> comparator) {
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

    private void shiftArrayContent(final Person[] result, final int startingPosition) {
        if (result.length - startingPosition > 0) {
            System.arraycopy(result, startingPosition, result, startingPosition + 1, result.length - 1 - startingPosition);
        }
    }
}
