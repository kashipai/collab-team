package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee  {

    private int id;
    private String fname;
    private String lname;
    private LocalDate join;
    private int age;

    public Employee(int id, String fname, String lname, LocalDate join, int age) {

        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.join=join;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFName() {
        return fname;
    }

    public void setFName(String fname) {
        this.fname = fname;
    }
    public String getLName() {
        return lname;
    }

    public void setName(String lname) {
        this.lname = lname;
    }

    public LocalDate getjoin() {
        return join;
    }

    public void setjoin(LocalDate join) {
        this.join = join;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", First name=" + fname +", Last name=" + lname + ",Joining date=" + join +", age=" + age + "]";
    }

}


