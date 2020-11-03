package com.example.employeerest.model;


import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    String name;
    @Column(name = "age")
    int age;
    @Column(name = "roll")
    String roll;

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee() {
    }

    public Employee(long id, String name, int age,String roll) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.roll = roll;
    }
}
