package com.emplyoee.bean;

public class Employee {

    private String EmpId;
    private String Name;
    private String location;
    private int phone;
 
    public Employee() {
 
    }
 
    public Employee(String EmpId, String Name, String location, int phone) {
        super();
        this.EmpId = EmpId;
        this.Name = Name;
        this.location = location;
        this.phone = phone;
    }
 
    public String getEmpId() {
        return EmpId;
    }
 
    public void setEmpId(String EmpId) {
        this.EmpId = EmpId;
    }
 
    public String getName() {
        return Name;
    }
 
    public void setName(String Name) {
        this.Name = Name;
    }
 
    public String getLocation() {
        return location;
    }
 
    public void setLocation(String location) {
        this.location = location;
    }
 
    public int getPhone() {
        return phone;
    }
 
    public void setPhone(int phone) {
        this.phone = phone;
    }
 
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person Id:- " + getEmpId() + " First Name:- " + getName() + " Last Name:- " +
            getLocation() + " Age:- " + getPhone());
        return builder.toString();
    }

}
