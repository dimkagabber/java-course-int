package com.tieto.training;

import java.util.Arrays;

public class ArrayHandler {
    public double getMax(double[] input) {
        if (input == null || input.length == 0) {
            return Double.NaN;
        }

        double max = input[0];
        for (final double item: input) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    public double[] getMax(double[] input, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Parameter n must be >= 0");
        }
        if (input == null || input.length == 0 || n == 0) {
            return new double[0];
        }

        final double[] result = createArrayOfNans(n);
        for (final double element: input) {
            insertElementToArrayIfBigger(result, element);
        }
        return trimNaNs(result);
    }

    private void insertElementToArrayIfBigger(final double[] array, final double newElement) {
        if (Double.isNaN(newElement)) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            final double element = array[i];
            if (newElement == element) {
                return;
            }
            if (newElement > element || Double.isNaN(element)) {
                insertElementToArray(array, newElement, i);
                return;
            }
        }
    }

    private void insertElementToArray(final double[] array, final double newElement, final int position) {
        for (int i = array.length-1; i > position ; i--) {
            array[i] = array[i-1];
        }
        array[position] = newElement;
    }

    private double[] trimNaNs(final double[] array) {
        for (int i = 0; i < array.length; i++) {
            if (Double.isNaN(array[i])) {
                return Arrays.copyOf(array, i);
            }
        }
        return array;
    }

    private double[] createArrayOfNans(final int n) {
        final double[] result = new double[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = Double.NaN;
        }
        return result;
    }
}
