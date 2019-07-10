package com.tieto.training;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ArrayHandler {
    public <T> List<T> getMax(final Collection<T> input, final int n, final Comparator<T> comparator){
        return new ArrayList<>();
    }

    public <T extends Comparable<T>> List<T> getMax(final Collection<T> input, final int n){
        return new ArrayList<>();
    }
}
