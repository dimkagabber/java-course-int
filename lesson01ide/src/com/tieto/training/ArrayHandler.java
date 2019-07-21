package com.tieto.training;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ArrayHandler {
    public <T> List<T> getMax(final Collection<T> input, final int n, final Comparator<T> comparator) {
        List<T> result = new ArrayList<>();
        initListWithNulls(result, n);

        for (T element : input) {
            addElementToResult(element, result, n, comparator);
        }
        removeAllNulls(result);
        return result;
    }

    private <T> void initListWithNulls(List<T> result, int n) {
        for (int i = 0; i < n; i++) {
            result.add(null);
        }
    }

    private <T> void removeAllNulls(List<T> result) {
        while (result.contains(null)){
            result.remove(null);
        }
    }

    private <T> void addElementToResult(T element, List<T> result, int n, Comparator<T> comparator) {
        if(element == null){
            return;
        }

        if (result.size() == 0) {
            result.add(element);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (result.get(i) == null) {
                result.set(i, element);
                return;
            }

            int comparisonResult = comparator.compare(element, result.get(i));
            if (comparisonResult == 0) {
                return;
            }
            if (comparisonResult > 0) {
                shiftArrayContent(result, i);
                result.set(i, element);
                return;
            }
        }
    }

    private <T> void shiftArrayContent(List<T> result, int insertPosition) {
        int lengthOfResult = result.size();
        for (int i = lengthOfResult - 1; i > insertPosition; i--) {
            T previousElement = result.get(i - 1);
            if (previousElement != null) {
                result.set(i, previousElement);
            }
        }
    }

    public <T extends Comparable<T>> List<T> getMax(final Collection<T> input, final int n) {
        List<T> result = new ArrayList<>();
        initListWithNulls(result, n);

        for (T element : input) {
            addElementToResult(element, result, n);
        }
        removeAllNulls(result);
        return result;
    }

    private <T extends Comparable<T>> void addElementToResult(T element, List<T> result, int n) {
        if(element == null){
            return;
        }

        if (result.size() == 0) {
            result.add(element);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (result.get(i) == null) {
                result.set(i, element);
                return;
            }

            int comparisonResult = element.compareTo(result.get(i));
            if (comparisonResult == 0) {
                return;
            }
            if (comparisonResult > 0) {
                shiftArrayContent(result, i);
                result.set(i, element);
                return;
            }
        }
    }
}
