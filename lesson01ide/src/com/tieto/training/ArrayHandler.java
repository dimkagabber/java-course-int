package com.tieto.training;

import com.tieto.training.person.Address;
import com.tieto.training.person.Gender;
import com.tieto.training.person.Person;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class ArrayHandler {

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

        return new Person[0];
    }

    private Person[] removeNullsFromArray(final Person[] array) {
        /* TODO FIX possible error with array size */
        int i;
        for (i = 0; i < array.length -1 ; i++) {
            if (array[i] == null) {
                break;
            }
        }

        Person[] result = new Person[i + 1];
        System.arraycopy(array, 0, result, 0, i);
        return result;
    }

    private void addNextElementToResult(final Person newElement, final Person[] result, Comparator<Person> comparator) {
        for (int i = 0; i < result.length; i++) {
            int comparisonResult = comparator.compare(newElement, result[i]);
            if (comparisonResult == 0) {
                return;
            }
            if (comparisonResult == +1) {
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
