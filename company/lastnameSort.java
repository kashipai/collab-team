package com.company;

import java.util.Comparator;

public class lastnameSort implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getLName().compareTo(o2.getLName());
    }
}