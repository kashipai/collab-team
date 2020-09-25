package com.company;

import java.util.Comparator;

public class Joinsort implements Comparator<Employee> {

@Override
public int compare(Employee o1, Employee o2) {
        return o1.getjoin().compareTo(o2.getjoin());
        }
}