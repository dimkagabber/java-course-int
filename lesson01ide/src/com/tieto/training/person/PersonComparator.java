package com.tieto.training.person;

import com.sun.nio.file.ExtendedWatchEventModifier;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(o1 == o2){
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if(o2 == null){
            return +1;
        }

        //handling of higher prio of ""
        if (o1.getLastName().compareTo("") == 0 || o2.getLastName().compareTo("") == 0) {
            if(o1.getLastName().compareTo(o2.getLastName())== 0) {
                if (o1.getFirstName().compareTo("") == 0 || o2.getFirstName().compareTo("") == 0) {
                    if(o1.getFirstName().compareTo(o2.getFirstName()) == 0) {
                        return 0;
                    }
                    if (o1.getFirstName().compareTo("") == 0 ){
                        return +1;
                    }
                    if (o2.getFirstName().compareTo("") == 0 ){
                        return -1;
                    }
                }
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
            if (o1.getLastName().compareTo("") == 0 ){
                return +1;
            }
            if (o2.getLastName().compareTo("") == 0 ){
                return -1;
            }
        }

        //normal case
        int comparisonResult = o1.getLastName().compareTo(o2.getLastName());
        if(comparisonResult == 0){
            comparisonResult = o1.getFirstName().compareTo(o2.getFirstName());
        }
        return comparisonResult;
    }
}
