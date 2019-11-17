package com.tieto.training;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PrimePredicate implements IntPredicate {

    @Override
    public boolean test(final int value) {
        if(value < 2) {
            return false;
        }

        if(value == 2) {
            return true;
        }

        if(value % 2 == 0) {
            return false;
        }

        for (int i = 2; i <= value; i++){
            if(2 * i == value) {
                return false;
            }
        }

        return false;
    }

    public int getNthPrime(int rangeSize){
        return IntStream.range(1,rangeSize)
                .filter(
                        x -> test(x))
                .max()
                .getAsInt();
    }


}
