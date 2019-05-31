package com.tieto.training;

public class RunArrayHandler {
    public static void main(String[] args) {
        ArrayHandler array = new ArrayHandler();
        double[] input;
        input = array.parseDoubles(args);
        for (int i = 0; i < input.length; i++) {
            System.out.println("input = " + input[i]);
        }

        System.out.println("The maximum entered value = " + array.getMax(input));
    }
}
