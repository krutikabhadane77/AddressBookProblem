package com.address.booksystem;

import java.util.Collections;
import java.util.List;

public class Sort {
    public static void sortPersonByCity(List<personDetails>person){
        Collections.sort(person, personDetails.citySorting);
        for (personDetails p:person){
            System.out.println(p);
        }
    }

    public static void sortPersonByState(List<personDetails>person){
        Collections.sort(person, personDetails.stateSorting);
        for (personDetails p:person){
            System.out.println(p);
        }
    }
}
