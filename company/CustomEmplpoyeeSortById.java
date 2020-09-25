package com.company;

import java.time.LocalDate;
import java.util.*;

public class CustomEmplpoyeeSortById {

    public static void main(String[] args) {

        List<Employee> emps = new ArrayList<>();

        emps.add(new Employee(2001, "Vikram", "Kumar", LocalDate.of(2020,9,07), 21));
        emps.add(new Employee(2002, "Sharath", "Agarwal", LocalDate.of(2006,8,13), 35));
        emps.add(new Employee(2003, "Rajesh", "Sharma", LocalDate.of(2008,10,12), 33));

        System.out.println("Before sorting custom list of employees : ");
        Iterator<Employee> it = emps.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Collections.sort(emps, new lastnameSort());
        System.out.println("After sorting custom list of employees based on Last Name: ");
        it = emps.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Collections.sort(emps, new Joinsort());
        System.out.println("After sorting custom list of employees based on Joining Date: ");
        it = emps.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}