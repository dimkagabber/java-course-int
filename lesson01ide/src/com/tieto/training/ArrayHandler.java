package com.tieto.training;

import com.tieto.training.person.Address;
import com.tieto.training.person.Gender;
import com.tieto.training.person.Person;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class ArrayHandler implements Comparator<Person> {

    final static int FIRST_BIGGER = 1;
    final static int EQUAL = 0;
    final static int SECOND_BIGGER = -1;


    public Person[] getMax(Person[] input, int n, Comparator<Person> comparator) {
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

        return new Person[0];
    }

    private Person[] removeNullsFromArray(final Person[] array) {

        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] == null) {
                break;
            }
        }

        Person[] result = new Person[i + 1];
        System.arraycopy(array, 0, result, 0, result.length);
        return result;
    }

    private void addNextElementToResult(final Person newElement, final Person[] result) {
        for (int i = 0; i < result.length; i++) {
            int comparisonResult = compare(newElement, result[i]);
            if (comparisonResult == EQUAL) {
                return;
            }
            if (comparisonResult == FIRST_BIGGER) {
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

    @Override
    public int compare(final Person o1, final Person o2) {
        if (o1 == null) {
            return SECOND_BIGGER;
        }
        if(o2 == null){
            return FIRST_BIGGER;
        }
        return o1.compareTo(o2);
    }
}
